package com.User;

/**
 * Created by leann on 13/04/2016.
 */
public class Book {

    private int bookId;
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int yearOfPublication;
    private int edition;

   /* public Book(String isbn, int bookId, String title, String author, String genre, int edition, int yearOfPublication) {
        this.isbn = isbn;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.edition = edition;
        this.yearOfPublication = yearOfPublication;
    }
    */

    public Book(){
        this.isbn = null;
        this.bookId = 0;
        this.title = null;
        this.author = null;
        this.genre = null;
        this.yearOfPublication = 0;
        this.edition = 0;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
