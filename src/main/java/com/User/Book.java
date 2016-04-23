package com.User;

/**
 * Created by leann on 13/04/2016.
 */
public class Book
{

    private int bookId;
    private String isbn;
    private String title;
    private String author;
    private int yearOfPublication;
    private int edition;
    private boolean isBorrowed;
    private Genre genre;

    public Book(String isbn, int bookId, String title, String author, Genre genre, int edition, int yearOfPublication)
    {
        this.isbn = isbn;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }


    public Book()
    {
        this.isbn = null;
        this.bookId = 0;
        this.title = null;
        this.author = null;
        this.yearOfPublication = 0;
        this.edition = 0;
        this.genre = null;
        this.isBorrowed = false;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getYearOfPublication()
    {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication)
    {
        this.yearOfPublication = yearOfPublication;
    }

    public int getEdition()
    {
        return edition;
    }

    public void setEdition(int edition)
    {
        this.edition = edition;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public boolean isBorrowed()
    {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed)
    {
        isBorrowed = borrowed;
    }
}
