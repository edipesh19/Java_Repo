
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPDemo {


	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=dxr");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        DirContext context = new InitialDirContext(env);


        NamingEnumeration<Binding> enumeration = context.listBindings("");

        DirContext groupCtx = (DirContext)context.lookup("ou=groups");
        DirContext userCtx = (DirContext)context.lookup("ou=users");

        NameParser nameParser = userCtx.getNameParser("");

        NamingEnumeration<Binding> groups = groupCtx.listBindings("");

        while(groups.hasMore()){
        	String bindingName = groups.next().getName();
        	Attributes attributes = groupCtx.getAttributes(bindingName);
        	Attribute attributeMember = attributes.get("member");
        	Attribute attributeDesc = attributes.get("description");
        	Attribute attributeName = attributes.get("cn");
        	System.out.printf("\t%s%s(%d)\n",attributeName,attributeDesc, attributeMember.size());

        	NamingEnumeration<?> members = attributeMember.getAll();

        	while(members.hasMore()){
        		String memberDN = members.next().toString();
        		Name memberName = nameParser.parse(memberDN);
        		DirContext member = (DirContext) userCtx.lookup(memberName.get(2));

        		Attributes memberAttributes = member.getAttributes("", new String[]{"cn", "mail"});
        		System.out.printf("%s, %s\n",memberAttributes.get("cn"), memberAttributes.get("mail"));

        	}

        }




	}
}
