package com.atguigu.ioc.xml.di;

public class Book {

    private String bname;
    private String author;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String bname, String author) {
        System.out.println("有参数构造执行.......");
        this.bname = bname;
        this.author = author;
    }

    public Book() {
        System.out.println("no 参数构造执行.......");

    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //原生set方法注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("kevin");

        //2：构造器
        Book book1 = new Book("c++", "czy");


    }
}
