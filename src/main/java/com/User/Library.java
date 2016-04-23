    package com.User;

    import org.joda.*;
    import org.joda.time.LocalDate;
    import org.joda.time.LocalTime;

    import java.util.*;
    import java.io.*;

    public class Library
    {

        Catalogue catalogue = new Catalogue();
        BookLoans bkloans = new BookLoans();
        Book book = new Book();
        boolean isOverdue;

        int numberOfLoanedBooks = 0;

        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<BookLoans> bookLoansList = new ArrayList<BookLoans>();

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

        protected String deleteUser(String userId) throws ErrorException
        {
            String errMessage = "";
            if(userList.isEmpty())
            {
                throw new ErrorException("User list is empty. No user to delete.");
            }
            else
            {
                User toBeRemoved = getUserById(userId);
                if(toBeRemoved == null)
                {
                    throw new ErrorException("User not found");
                }
                else
                {
                    userList.remove(toBeRemoved);
                    errMessage = "Removed Successfully";
                }
            }
            return errMessage;
        }

        protected String loanBookTo(Book book, User user) throws ErrorException
        {
            String result = "";
            BookLoans bookLoans = new BookLoans();
            String userid = user.getUserId();

            int bookid = book.getBookId();

            if (book.isBorrowed())
            {
                throw new ErrorException("Book has already been borrowed");
            }
            else if (numberOfLoanedBooks >= 3)
            {
                throw new ErrorException("No more books can be loaned - Max of 3");
            }

            //else if(bookLoans.getIsOverdue() == true)
            else if(isOverdue == true)
            {
                throw new ErrorException("No more books can be loaned out");
            }
            else
            {
                bookLoans = new BookLoans(bookid, userid, org.joda.time.LocalDate.now(),false);
                bookLoans.setDateLoan(org.joda.time.LocalDate.now());
                bookLoansList.add(bookLoans);
                book.setBorrowed(true);
                numberOfLoanedBooks++;
                return "Book borrowed successfully";
            }
        }

        protected String checkIfOverdue(Book book, org.joda.time.LocalDate dayReturned) throws  ErrorException
        {
            BookLoans bookLoans = new BookLoans();

            String errMessage = "";
            long numberOfDaysBookHasBeenBorrowed;

            int bookid = book.getBookId();

            for(int i = 0; i < bookLoansList.size(); i++)
            {
                if(bookLoansList.get(i).getBookId() == (bookid))
                {
                    org.joda.time.LocalDate dayLoaned = bookLoansList.get(i).getDateLoan();

                    numberOfDaysBookHasBeenBorrowed = org.joda.time.Days.daysBetween(dayLoaned, dayReturned).getDays();
                    // 3 weeks = 21 days
                    if (numberOfDaysBookHasBeenBorrowed > 21)
                    {
                        bookLoansList.get(i).setIsOverdue(true);
                        isOverdue = true;
                        throw new ErrorException("Book is overdue");
                    }
                    else
                    {
                        bookLoansList.get(i).setIsOverdue(false);
                        isOverdue = false;
                        errMessage = "Book is not overdue";
                    }
                }
            }
            return  errMessage;
        }

        protected String returnBook(Book book)
        {
            String result = "";
            org.joda.time.LocalDate dayReturned;
            int bookid = book.getBookId();

            for(int i = 0; i < bookLoansList.size(); i++)
            {
                if(bookLoansList.get(i).getBookId() == (bookid))
                {
                    isOverdue = false;
                    bookLoansList.remove(i);
                    numberOfLoanedBooks--;
                    result = "Book returned successful";
                }
            }
            return result;
        }

    }