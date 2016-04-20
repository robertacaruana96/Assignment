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

}