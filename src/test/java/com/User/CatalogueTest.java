package com.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by leann on 19/04/2016.
 */
public class CatalogueTest {

    Catalogue catalogue;
    Book book;

    @Before
    public void setUp() throws Exception {

        catalogue = new Catalogue();
        book = new Book();
    }

    @After
    public void tearDown() throws Exception {

        catalogue = null;
        book = null;

    }

    //this test is the case when no Book Isbn is entered
    @Test
    public void testAddBookIdEmptyIsbn() {
        Throwable e = null;
        Book book1 = new Book(" ", 2345678, "Alice in Wonderland", "Leanne", "Adventure", 2001, 1);

        try {
            catalogue.addBook(book1);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof EmptyStringException);
    }

    //testing a successful delete
    @Test
    public void testDelete() {
        Throwable e = null;
        String result = "";

        try {
            Book book1 = new Book("222ret", 3244030, "Birds", "Jonathan", "Educational", 2002, 3);
            catalogue.addBook(book1);
            result = catalogue.deleteBook("222ret");
        } catch (Throwable ex) {
            e = ex;
        }
        assertEquals("Book deleted successfully", result);
    }

    //testing the delete when book list is empty
    @Test
    public void testDeleteEmptyList() {
        Throwable e = null;

        try {
            catalogue.deleteBook("234opp");
        } catch (Throwable ex) {
            e = ex;
            assertEquals("Book List is empty. No book to delete", e.getMessage());
        }

        assertTrue(e instanceof ErrorException);
    }

    @Test
    //test to validate the length of the bookID
    public void testLengthBookID() {
        Throwable e = null;
        String length;

        try {
            Book book1 = new Book("123abc", 1234567, "The World", "Nina", "Non-Fiction", 2014, 8);
            catalogue.addBook(book1);
            length = String.valueOf(book1.getBookId());
            assertEquals(7, length);
        } catch (Throwable ex) {
            e = ex;
        }
    }

    @Test
    //test to validate the ISBN entry for a particular book
    public void testBookIsbn() {
        Throwable e = null;

        try {
            Book book1 = new Book("234bcd", 3456789, "Snow White", "Maria", "Fantasy", 2011, 2);
            catalogue.addBook(book1);
            assertEquals("234bcd", book1.getIsbn());
        } catch (Throwable ex) {
            ex = e;
        }
    }

    //test to make sure book is added successfully to the book list.
    @Test
    public void testAddBook() {
        Throwable e = null;
        String result;

        try {
            Book book1 = new Book("567def", 1123202, "Stars", "Leah", "Non-Fiction", 2000, 1);
            result = catalogue.addBook(book1);
            assertEquals("Book Added Successfully", result);
        } catch (Throwable ex) {
            e = ex;
        }
    }

    //test to make sure the length of the year is equal to 4
    @Test
    public void testYearLength() {
        Throwable e = null;
        String length;

        try {
            Book book1 = new Book("887aab", 10029382, "School", "Dorianne", "Educational", 2003, 2);
            catalogue.addBook(book1);
            length = String.valueOf(book1.getYearOfPublication());
            assertEquals(4, length);
        } catch (Throwable ex) {
            e = ex;
        }
    }

    @Test
    //test to validate the title entry for a particular book
    public void testBookTitle() {
        Throwable e = null;
        String result;

        try {
            Book book1 = new Book("929asd", 9909298, "Oceans around the world", "Lucy", "Educational", 2006, 3);
            catalogue.addBook(book1);
            result = book1.getTitle();
            assertEquals("Oceans around the world", result);
        } catch (Throwable ex) {
            e = ex;
        }
    }

    //test to ensure an exception is thrown when book isbn which already exists is inputted.
    @Test
    public void checkIfBookIsbnIsValid() {
        Throwable e = null;

        try {
            Book book1 = new Book("234arf", 9022321, "England", "John", "Educational", 2000, 1);
            Book book2 = new Book("234arf", 2832933, "Asia", "Edward", "Educational", 2003, 2);
            catalogue.addBook(book1);
            catalogue.addBook(book2);
        } catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof FieldAlreadyExistsException);
    }

    //test to validate the title in search by genre
    @Test
    public void testGenre() {
        Throwable e = null;
        String result;

        try {

            Book book1 = new Book("929asd", 9909292, "Trees", "Lucy", "Educational", 2006, 3);
            catalogue.addBook(book1);
            result = book1.getGenre();
            assertEquals("Educational", result);
        } catch (Throwable ex) {
            e = ex;
        }

    }

    //testing the searchBookByTitle method.
    @Test
    public void testSearchBookByTitle(){
        Throwable e = null;
        Book result;

        try{

            Book book1 = new Book ("929asd", 99075292, "Trees", "Lucy", "Educational", 2006, 3);
            catalogue.addBook(book1);
            result = catalogue.searchBookByTitle(book1.getTitle());
            assertEquals(book1, result);
        } catch (Throwable ex){
            e = ex;
        }
    }

    //testing the searchBookByGenre method.
    @Test
    public void testSearchBookByGenre() {
        Throwable e = null;
        Book result;

        try {

            Book book1 = new Book ("881rde", 2031929, "Houses", "Leanne", "Informative", 2001, 1);
            catalogue.addBook(book1);
            result = catalogue.searchBookByGenre(book1.getGenre());
            assertEquals(book1, result);
        } catch (Throwable ex){
            e = ex;
        }
    }

    //testing the searchBookByYearOfPublication method
    @Test
    public void testSearchBookByYearOfPublication(){
        Throwable e = null;
        Book result;

        try {

            Book book1 = new Book ("332ssa", 2334234, "Cats", "Nina", "Animals", 2014, 1);
            catalogue.addBook(book1);
            result = catalogue.searchBookByYearOfPublication(book1.getYearOfPublication());
            assertEquals(book1, result);
        } catch (Throwable ex){
            e = ex;
        }
    }




}







