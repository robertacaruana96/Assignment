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

}







