    package com.User;

    import java.util.*;
    import java.io.*;

    public class Library
    {

        //Catalogue catalogue = new Catalogue();
        //BookLoans bkloans = new BookLoans();
        Book book = new Book();

        int numberOfLoanedBooks = 0;

        ArrayList<User> userList = new ArrayList<User>();
        //ArrayList<BookLoans> bookLoansList = new ArrayList<BookLoans>();

        protected String addUser(User user)throws EmptyStringException, FieldAlreadyExistsException
        {
             String UserId = user.getUserId();

             // if the userid is empty (or consists only of blank white spaces, then an error is thron since this field cannot be left empty
             if (UserId.trim().isEmpty())
             {
                   throw new EmptyStringException("UserID Cannot be empty");
             }
             else
             {
                 User temp = getUserById(UserId);

                 if (temp != null)
                 {
                     throw new FieldAlreadyExistsException("User ID already Exists");
                 }
                 else
                 {
                     userList.add(user);
                     return "User has been added successfully";
                 }
             }
        }


        // Method to search user by user id (binary search)
        public User getUserById(String userId)
        {
             int left = 0;
             int right = userList.size() - 1;
             int middle;
             User temp;

             while(left <= right)
             {
                 middle = (left + right)/2;

                 temp = userList.get(middle);
                 String tempUserId = temp.getUserId();

                 if(tempUserId.equals(userId))
                 {
                     return temp;
                 }
                 else if(tempUserId.compareToIgnoreCase(userId) > 0)
                 {
                     right = middle - 1;
                 }
                 else
                 {
                     left = middle + 1;
                 }
             }

             return null;
        }

    }