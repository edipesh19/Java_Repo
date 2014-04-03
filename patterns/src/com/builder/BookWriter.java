package com.builder;
public class BookWriter {
 
 BookBuilder bookBuilder;
 
 public BookWriter(BookBuilder bookBuilder) {
  super();
  this.bookBuilder = bookBuilder;
 }
 
 public Book getBook()
 {
  return this.bookBuilder.getBook();
 }
 
 public void printBook()
 {
  this.bookBuilder.buildTableOfContent();
  this.bookBuilder.buildPreface();
  this.bookBuilder.buildIntroduction();
  this.bookBuilder.buildChapters();
  this.bookBuilder.buildGlossary();
 }
}