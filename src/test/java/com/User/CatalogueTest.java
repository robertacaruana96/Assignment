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



}







