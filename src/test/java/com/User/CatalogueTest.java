package com.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogueTest {

    Catalogue catalogue;
    Book book;

    @Before
    public void setUp() throws Exception
    {
        // using 1 instance of catalogue - singleton
        catalogue = Catalogue.getInstance();
        book = new Book();
    }

    @After
    public void tearDown() throws Exception {

        Catalogue.nullInstance();
        book = null;
    }

    //this test is the case when no Book Isbn is entered
    @Test
    public void testAddBookIdEmptyIsbn() {
        Throwable e = null;
        Genre genre = new Genre("Adventure");
        Book book1 = new Book(" ", 2345678, "Alice in Wonderland", "Leanne", genre, 2001, 1);

        try {
            Catalogue.getInstance().addBook(book1);
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
        Genre genre = new Genre("Educational");
        try {
            Book book1 = new Book("222ret", 3244030, "Birds", "Jonathan", genre, 2002, 3);
            Catalogue.getInstance().addBook(book1);
            result = Catalogue.getInstance().deleteBook("222ret");
        } catch (Throwable ex) {
            e = ex;
        }
        assertEquals("Book deleted successfully", result);
    }

    //testing the delete when book list is empty
    @Test
    public void testDeleteEmptyList() {
        Throwable e = null;

        // Emptying the list

        try {
            Catalogue.getInstance().deleteBook("234opp");
        } catch (Throwable ex) {
            e = ex;
            assertEquals("Book List is empty. No book to delete", e.getMessage());
        }

        assertTrue(e instanceof ErrorException);
    }

    @Test
    public void testDeleteBookNotInList()
    {
        Throwable e = null;

        try
        {
            Genre genre = new Genre("Animals");
            Book book1 = new Book("222ret", 3244030, "Birds", "Jonathan", genre, 2002, 3);
            Catalogue.getInstance().addBook(book1);
            Catalogue.getInstance().deleteBook("456");
        }
        catch (Throwable ex)
        {
            e = ex;
            assertEquals("Book not found", e.getMessage());
        }
        assertTrue(e instanceof  ErrorException);
    }

    @Test
    //test to validate the length of the bookID
    public void testLengthBookID() {
        Throwable e = null;
        String length;
        Genre genre = new Genre("Non-Fiction");

        try {
            Book book1 = new Book("123abc", 1234567, "The World", "Nina", genre, 2014, 8);
            Catalogue.getInstance().addBook(book1);
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

        Genre genre = new Genre("Fantasy");
        try {
            Book book1 = new Book("234bcd", 3456789, "Snow White", "Maria", genre, 2011, 2);
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
        Genre genre = new Genre("Non-Fiction");
        try {
            Book book1 = new Book("567def", 1123202, "Stars", "Leah", genre, 2000, 1);
            result = Catalogue.getInstance().addBook(book1);
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
        Genre genre = new Genre("Educational");
        try {
            Book book1 = new Book("887aab", 10029382, "School", "Dorianne", genre, 2003, 2);
            Catalogue.getInstance().addBook(book1);
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
        Genre genre = new Genre("Educational");

        try {
            Book book1 = new Book("929asd", 9909298, "Oceans around the world", "Lucy", genre, 2006, 3);
            Catalogue.getInstance().addBook(book1);
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

        Genre genre = new Genre("Educational");
        try {
            Book book1 = new Book("234arf", 9022321, "England", "John", genre, 2000, 1);
            Book book2 = new Book("234arf", 2832933, "Asia", "Edward", genre, 2003, 2);
            Catalogue.getInstance().addBook(book1);
            Catalogue.getInstance().addBook(book2);
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

        Genre genre = new Genre("Educational");

        try {

            Book book1 = new Book("929asd", 9909292, "Trees", "Lucy", genre, 2006, 3);
            Catalogue.getInstance().addBook(book1);
            result = genre.getGenreType();
            assertEquals("Educational", result);
        } catch (Throwable ex) {
            e = ex;
        }

    }

    /*
    //testing the searchBookByTitle method.
    @Test
    public void testSearchBookByTitle(){
        Throwable e = null;
        Book result;

        Genre genre = new Genre("Educational");

        try{
            Book book1 = new Book ("929asd", 99075292, "Trees", "Lucy", genre, 2006, 3);
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
        Genre genre = new Genre("Informative");

        try {

            Book book1 = new Book ("881rde", 2031929, "Houses", "Leanne", genre, 2001, 1);

            catalogue.addBook(book1);

            result = catalogue.searchBookByGenre(genre);
            assertEquals(book1, result);
        } catch (Throwable ex){
            e = ex;
        }
    }

    //testing the searchBookByYearOfPublication method
    @Test
    public void testSearchBookByYearOfPublicationFactoryMethod(){
        Throwable e = null;
        Book result;

        FilterFactory filterFactory = new FilterFactory();
        Filter filter1 = filterFactory.getFilter("YEAROFPUBLICATION");
        Genre genre = new Genre("Animals");
        try {

            Book book1 = new Book ("332ssa", 2334234, "Cats", "Nina", genre, 2014, 1);
            catalogue.addBook(book1);
            result = filter1.search(book1.getYearOfPublication());
            assertEquals(book1, result);
        } catch (Throwable ex){
            e = ex;
        }
    }
    */

    // Testing the search by method
    @Test
    public void testSearchByFilter() {
        Throwable e = null;
        Book result;
        Book result2;
        Book result3;
        Book result4;
        Book result5;
        Book result6;
        Book result7;

        FilterFactory filterFactory = new FilterFactory();
        Filter filter1 = filterFactory.getFilter();

        Genre genre = new Genre("Informative");

        try {

            Book book1 = new Book("234bcd", 3456789, "Snow White", "Maria", genre, 2011, 2);
            catalogue.addBook(book1);


            //filter1 = new SearchBy();
            // searching by genre
            result = filter1.search(book1.getGenre());
            result2 = filter1.search(book1.getTitle());
            result3 = filter1.search(book1.getYearOfPublication());
            result4 = filter1.search(book1.getTitle(), book1.getGenre());
            result5 = filter1.search(book1.getTitle(), book1.getYearOfPublication());
            result6 = filter1.search(book1.getYearOfPublication(), book1.getGenre());
            result7 = filter1.search(book1.getTitle(), book1.getGenre(), book1.getYearOfPublication());

            assertEquals(book1, result);
            assertEquals(book1, result2);
            assertEquals(book1, result3);
            assertEquals(book1, result4);
            assertEquals(book1, result5);
            assertEquals(book1, result6);
            assertEquals(book1, result7);
        } catch (Throwable ex){
            e = ex;
        }
    }
}