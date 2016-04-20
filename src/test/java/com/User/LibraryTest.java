package com.User;

import java.lang.*;
import java.io.*;
import java.util.*;
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
    Catalogue catalogue;

    @Before
    public void setUp() throws Exception
    {
        user = new User();
        library = new Library();
        catalogue = new Catalogue();
    }

    @After
    public void tearDown() throws Exception
    {
        user = null;
        library = null;
        catalogue = null;
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

            assertEquals(12345, user1.getContactNumber());
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

}