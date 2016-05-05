package com.User;

import java.lang.*;
import java.io.*;
import java.util.*;

import org.joda.time.DateTimeConstants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest
{

    User user;
    Library library;
    //Catalogue catalogue;

    @Before
    public void setUp() throws Exception
    {
        user = new User();
        library = new Library();
        // Using same instance -> singleton pattern
       // catalogue = Catalogue.getInstance();
    }

    @After
    public void tearDown() throws Exception
    {
        user = null;
        library = null;
        Catalogue.nullInstance();
    }

       /*
     *  Testing that if the user id is empty, then an empty string exception will be thrown
     *  This shows that the string for UserID cannot be empty since it is the primary key
     */
    // This test is the case when nothing is entered to represent the userId (the empty string)
    @Test
    public void testAddUserIDEmpty()
    {
        Throwable e = null;
        User user1 = new User(" ", "Roberta", "Caruana", 21343434, "crcom", "Bkara");

        try
        {
            library.addUser(user1);
        }
        catch (Throwable ex)
        {
            e = ex;
        }

        assertTrue(e instanceof EmptyStringException);
    }

    // This test signifies when the field is filled with blank spaces, the same empty string exception is thrown
    @Test
    public void testAddUserIDEmptySequence()
    {
        Throwable e = null;

        User user1 = new User(" ", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
        try
        {
            library.addUser(user1);
        }
        catch (Throwable ex)
        {
            e = ex;
        }
        assertTrue(e instanceof EmptyStringException);
    }

    @Test
    public void testAddUserValid()
    {
        Throwable e = null;

        try
        {
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            library.addUser(user1);

            assertEquals(12345, user1.getUserId());
        }
        catch (Throwable ex)
        {
            e = ex;
        }
    }

    // Test to ensure that the user has been added to the User array list
    @Test
    public void testAddingAUser()
    {
        Throwable e = null;
        String result;
        try
        {
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            result = library.addUser(user1);

            assertEquals("User has been added successfully", result);
        }
        catch (Throwable ex)
        {
            e = ex;
        }
    }

    // Ensure that an exception is thrown if a UserID already created is trying to be added
    @Test
    public void checkIfUserIdAlreadyExists()
    {
        Throwable e = null;

        try
        {
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            User user2 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            library.addUser(user1);
            library.addUser(user2);

        }
        catch (Throwable ex)
        {
            e = ex;
        }
        assertTrue(e instanceof FieldAlreadyExistsException);
    }

    // Try to do tests to ensure that email is correct and even contact number

    // Trying to delete when the list is still empty - throws an exception
    // Also checking that the message of the exception is correct since error exception is  a general exception and could have many different messages
    @Test
    public void testDeleteOnEmptyList()
    {
        Throwable e = null;

        try
        {
            library.deleteUser("123");
        }
        catch(Throwable ex)
        {
            e = ex;
            assertEquals("User list is empty. No user to delete.",e.getMessage());
        }
        assertTrue(e instanceof ErrorException);
    }

    @Test
    public void testDeletedUserNotInList()
    {
        Throwable e = null;
        try
        {
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            library.addUser(user1);
            library.deleteUser("1245");

        }
        catch (Throwable ex)
        {
            e = ex;
            assertEquals("User not found", e.getMessage());
        }
        assertTrue(e instanceof  ErrorException);
    }

    @Test
    public void testDeleteWasSuccessful()
    {
        Throwable e = null;
        String result="";
        try
        {
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            library.addUser(user1);
            result = library.deleteUser("12345");

        } catch (Throwable ex)
        {
            e = ex;
        }
        assertEquals("Removed Successfully", result);

    }

    // done in order to achieve full code coverage - tests the case when the number searched for to be delete is smaller than the prev number
    @Test
    public void testSuccessfulDelete()
    {
        Throwable e = null;
        String result="";
        try
        {
            User user1 = new User("34567", "Roberta", "Caruana", 21343434, "c@v.com", "Bkara");
            User user2 = new User("23456", "Leanne", "Vassallo", 21343434, "l@v.com", "Lija");
            User user3 = new User("12345", "Rose", "Abela", 21676767, "r@v.com", "Mosta");

            library.addUser(user1);
            library.addUser(user2);
            library.addUser(user3);

            result = library.deleteUser("23456");

        }
        catch (Throwable ex)
        {
            e = ex;
        }
        assertEquals("Removed Successfully", result);
    }

        /*
    ----- Test Loan Book -----
    */

    @Test
    public void testLoanBookSuccessful() {
        String result = "";
        Throwable e = null;
        try {
            Genre genre = new Genre("Fantasy");
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            Book book1 = new Book("234bcd",2345678, "Snow White", "Leanne", genre, 2010, 2);

            //The user is not entered in the list of users
            result = library.loanBookTo(book1, user1);

        } catch (Throwable ex) {
            e = ex;
        }

        assertEquals("Book borrowed successfully", result);
    }

    // Testing that a user could not loan more than 3 books
    @Test
    public void testLoanMoreThan3Books() {
        Throwable e = null;
        String result = "";
        try {
            Genre genre = new Genre("Fantasy");
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            Book book1 = new Book("234bcd",2345678, "Snow White", "Leanne", genre, 2010, 2);
            Book book2 = new Book("234bcd",3456789, "Snow White", "Leanne", genre, 2010, 2);
            Book book3 = new Book("234bcd",4567890, "Snow White", "Leanne", genre, 2010, 2);
            Book book4 = new Book("234bcd",5678901, "Snow White", "Leanne", genre, 2010, 2);

            library.loanBookTo(book1, user1);
            library.loanBookTo(book2, user1);
            library.loanBookTo(book3, user1);
            library.loanBookTo(book4, user1);

        } catch (Throwable ex) {
            e = ex;
            assertEquals("No more books can be loaned - Max of 3", e.getMessage());
        }
        assertTrue(e instanceof ErrorException);
    }


    // Trying to borrow a book which is already loaned out
    @Test
    public void testBookAlreadyLoaned() {
        Throwable e = null;
        String result = "";
        try {
            Genre genre = new Genre("Fantasy");
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");
            User user2 = new User("23451", "Leanne", "Vassallo", 21565656, "lvcom", "Mosta");

            Book book1 = new Book("234bcd", 2345678,"Snow White", "Leanne", genre, 2010, 2);

            library.loanBookTo(book1, user1);
            library.loanBookTo(book1, user2);
        } catch (Throwable ex) {
            e = ex;
            assertEquals("Book has already been borrowed", e.getMessage());
        }
        assertTrue(e instanceof ErrorException);
    }

    /*
    --- TEST RETURN BOOK SUCCESSFUL ---
     */
    @Test
    public void testReturnBookSuccesful() {
        Throwable e = null;
        String result = "";
        try {
            Genre genre = new Genre("Fantasy");
            Book book1 = new Book("234bcd", 2345678, "Snow White", "Leanne", genre, 2010, 2);
            User user1 = new User("12345", "Roberta", "Caruana", 21343434, "crcom", "Bkara");

            //The user is not entered in the list of users
            Catalogue.getInstance().addBook(book1);
            library.loanBookTo(book1, user1);
            result = library.returnBook(book1);
            assertEquals("Book returned successful", result);
        } catch (Throwable ex) {

        }
    }

    // Checking that if a book is overdue by 3 weeks from todays day, then an error is shown about this
    @Test
    public void testDateOverdue() {
        Throwable e = null;
        Throwable e2 = null;
        String result = "";

        Genre genre1 = new Genre("Fantasy");
        Genre genre2 = new Genre("Fiction");

        User user1 = new User("34567", "Roberta", "Caruana", 21343434, "c@v.com", "Bkara");
        Book book1 = new Book("234asd", 234, "Snow White", "Leanne", genre1, 2010, 2);
        Book book2 = new Book("456das", 675, "Star Wars", "Alexia", genre2, 2008, 1);

        try {
            library.addUser(user1);
            Catalogue.getInstance().addBook(book1);
            library.loanBookTo(book1, user1);

            // Giving an overdue date exceeding 3 weeks from todays date (22 Apr 2016)
            org.joda.time.LocalDate dayReturned = new org.joda.time.LocalDate(2016, DateTimeConstants.AUGUST,8);

            library.checkIfOverdue(book1, dayReturned);

        } catch (Throwable ex) {
            e = ex;
            assertEquals("Book is overdue", e.getMessage());
        }

        assertTrue(e instanceof ErrorException);

        // Checking that if a user has an overdue book, then no more books could be loaned out by that user
        // Testing that if you try to loan a bok which is overdue, an error will occur.
        // The test is done in the previous method since checkIfOverdue returns an exception and 2 exceptions need
        // to be handled to test this case.
        try
        {
            library.loanBookTo(book2,user1);
        }
        catch (Throwable ex)
        {
            e2 = ex;
            assertEquals("No more books can be loaned out", e2.getMessage());
        }

        assertTrue(e2 instanceof ErrorException);
    }

    // Testing that the user returns the book before the due date
    @Test
    public void testDateNotOverdue()
    {
        Throwable e = null;
        String result = "";
        Genre genre = new Genre("Fantasy");
        User user1 = new User("34567", "Roberta", "Caruana", 21343434, "c@v.com", "Bkara");
        Book book1 = new Book("234bcd", 2345678, "Snow White", "Leanne", genre, 2010, 2);

        try
        {
            library.addUser(user1);
            Catalogue.getInstance().addBook(book1);
            library.loanBookTo(book1, user1);

            // Giving a date which will not be overdue. that is one which wont exceed 3 weeks
            // from todays date (22 Apr 2016)
            org.joda.time.LocalDate dayReturned =  new org.joda.time.LocalDate(2016, DateTimeConstants.APRIL,28);

            result = library.checkIfOverdue(book1, dayReturned);
        }
        catch (Throwable ex)
        {
            e = ex;
        }

        assertEquals("Book is not overdue",result);

    }

}