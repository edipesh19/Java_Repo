package com.training;

public class ExampleOuterClass {
	
	String comp = "PP";
	
	
	Travel t = new Travel() {
		
		DefaultTravelImpl impl = new DefaultTravelImpl();
		@Override
		public int speed() {
			return impl.speed();
		}

		@Override
		public int getName() {
			return 0;
		}
	};
	
	Abs ab = new Abs() {
		
		@Override
		public void invoke() {
			System.out.println("invoke called.");			
		}
	};
	
	
	public ExampleOuterClass(){
		t.speed();
		ab.invoke();
		
		//Travel t = new ExampleOuterClass();
	}
	
	public void sendEmail(String mailid){
		
		final String d = mailid;
		class Test{
			public Test(){
				String t  = comp;
				String e = d;
			}
		}
		Test p = new Test();
		
	}
	
	public static class StaticClass{
		
	}
	class InnerClass {
	
		public InnerClass(){
			
		}
	}
	public static void main(String[] args) {
		ExampleOuterClass oc = new ExampleOuterClass();
		InnerClass ic = oc.new InnerClass();
		StaticClass sc = new StaticClass();
		
	}

}
