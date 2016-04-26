package com.User;

import java.io.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class BookTest
{

    Book book;

    @Before
    public void setUp() throws Exception
    {

        book = new Book();
    }

    @After
    public void tearDown() throws Exception
    {

        book = null;
    }

    //a test to validate the setBookId
    @Test
    public void testBookId()
    {
        book.setBookId(1234);
        int result = book.getBookId();
        assertEquals(1234, result);
    }

    //a test to validate the isbn
    @Test
    public void testBookIsbn()
    {
        book.setIsbn("a12b");
        String result = book.getIsbn();
        assertEquals("a12b", result);
    }

    //a test to validate the title
    @Test
    public void testBookTitle()
    {
        book.setTitle("A title");
        String result = book.getTitle();
        assertEquals("A title", result);
    }

    //a test to validate the author
    @Test
    public void testBookAuthor()
    {
        book.setAuthor("Nina");
        String result = book.getAuthor();
        assertEquals("Nina", result);
    }

    //a test to validate the genre
    @Test
    public void testBookGenre()
    {
        Genre genre = new Genre("Fiction");
        book.setGenre(genre);
        String result = genre.getGenreType();
        assertEquals("Fiction", result);
    }

    //a test to validate the yearOfPublication
    @Test
    public void testBookYearOfPublication()
    {
        book.setYearOfPublication(2/02/12);
        int result = book.getYearOfPublication();
        assertEquals(2/02/12, result);
    }

    //a test to validate the edition
    @Test
    public void testBookEdition() {
        book.setEdition(3);
        int result = book.getEdition();
        assertEquals(3, result);
    }
}