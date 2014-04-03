package com.builder;

public class Main {
 
 
 public static void main(String[] args) {
  
  System.out.println("Printing technical book:");
  BookBuilder technialbookBuilder=new TechnicalBookBuilder();
  BookWriter technicalBookWriter=new BookWriter(technialbookBuilder);
  technicalBookWriter.printBook();
  Book technicalbook=technicalBookWriter.getBook();
  System.out.println("Technical Book Printed:"+technicalbook);
  System.out.println("******************************************");
  System.out.println("Printing fictional book:");
  BookBuilder fictionalbookBuilder=new FictionalBookBuilder();
  BookWriter fictionalBookWriter=new BookWriter(fictionalbookBuilder);
  fictionalBookWriter.printBook();
  Book fictionalbook=fictionalBookWriter.getBook();
  System.out.println("Fictionalbook book printed:"+fictionalbook);
 }
}