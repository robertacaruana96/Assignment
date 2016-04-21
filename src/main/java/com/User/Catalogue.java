package com.User;
import java.util.ArrayList;

/**
 * Created by leann on 19/04/2016.
 */
public class Catalogue {

    //creating an arraylist to hold all Books in the Catalogue
    private ArrayList<Book> bookList = new ArrayList<Book>();

    //a method to search a Book by ISBN
    protected Book searchBookByIsbn (String isbn ){
        for (int i = 0 ; i < bookList.size() ; i++){
            if (bookList.get(i).getIsbn().equalsIgnoreCase(isbn)){
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
            throw new EmptyStringException("UserIsbn cannot be empty");
        } else {
            Book temp = searchBookByIsbn(bookIsbn);

            if (temp != null){
                throw new FieldAlreadyExistsException("Book ISBN already exists");
            } else {
                bookList.add(book);
                return "Book has been added successfully";
            }
        }
    }






}
