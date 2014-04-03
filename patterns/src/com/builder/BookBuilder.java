package com.builder;

public interface BookBuilder {
	 
    public void buildTableOfContent();
    public void buildPreface();
    public void buildIntroduction();
    public void buildChapters();
    public void buildGlossary();
    public Book getBook();
}