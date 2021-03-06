package com.User;
//import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.util.ArrayList;

/**
 * Created by leann on 19/04/2016.
 */
public class Catalogue {

    // Applying singleton pattern
    private static Catalogue instance = null;

    //creating an arraylist to hold all Books in the Catalogue
    public ArrayList<Book> bookList = new ArrayList<Book>();

    // create a static getInstance() method to provide access - Singleton method
    public static Catalogue getInstance()
    {
        if(instance == null)
        {
            instance = new Catalogue();
        }
        return instance;
    }
    // Adding private constructor - singleton pattern
    private Catalogue()
    {

    }

    // The nullInstance method was added for testablility purposes since the incstance of catalogue is assumed to be
    // empty for each test. This was done by using this method.
    public static void nullInstance() {
        instance = null;
    }

    //a method to search a Book by ISBN
    protected Book searchBookByIsbn (String isbn )
    {
        for (int i = 0 ; i < bookList.size() ; i++)
        {
            if (bookList.get(i).getIsbn().equalsIgnoreCase(isbn))
            {
                return bookList.get(i);
            }
        }
        return null;
    }

    //a method to add a book
    protected String addBook(Book book) throws EmptyStringException,FieldAlreadyExistsException {
        String bookIsbn = book.getIsbn();
        //if bookID empty
        if (bookIsbn.trim().isEmpty()) {
            throw new EmptyStringException("Book Isbn cannot be empty");
        } else {
            Book temp = searchBookByIsbn(bookIsbn);

            if (temp != null)
            {
                throw new FieldAlreadyExistsException("Book ISBN already exists");
            } else
            {
                bookList.add(book);
                return "Book has been added successfully";
            }
        }
    }

    //a method to delete a Book
    protected String deleteBook(String bookIsbn) throws ErrorException
    {
        String errMessage = "";
        if (bookList.isEmpty())
        {
            throw new ErrorException("Book List is empty. No book to delete");
        }
        else
        {
            Book toDelete = searchBookByIsbn(bookIsbn);
            if (toDelete == null)
            {
                throw new ErrorException("Book not found");
            }
            else
            {
                bookList.remove(toDelete);
                errMessage = "Book deleted successfully";
            }
        }

        return errMessage;
    }

    /* Commenting search methods since general filter function is to be implemented to cater for all searches
    //a method to search a Book by title
    protected Book searchBookByTitle (String title)
    {
        Book result = null;
        for (int i = 0; i < bookList.size(); i++)
        {
            if (bookList.get(i).getTitle().equalsIgnoreCase(title))
            {
                result = bookList.get(i);
            }
        }
        return result;
    }

    //a method to search a Book by genre
    protected Book searchBookByGenre (Genre genre)
    {
        Book result = null;
        for (int i = 0; i < bookList.size(); i++)
        {
            if (bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType()))
            {
                result = bookList.get(i);
            }
        }
        return result;
    }

    protected Book searchBookByYearOfPublication (int year)
    {
        Book result = null;
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getYearOfPublication() == year)
            {
                result = bookList.get(i);
            }
        }
        return result;
    }
    */
}