package com.User;

import java.util.ArrayList;

/**
 * Created by Bobby on 05-May-16.
 */

public class ConcreteObserver implements Observer
{
    String userId;
    Subject subject;
    ConcreteSubject cs = new ConcreteSubject();

    public ConcreteObserver(String userId)
    {
        userId = null;
    }


    @Override
    public void update(Book book, User user)
    {
        // When a book is returned then the following is done:
        loanBookToNextUser(book,user);
    }

    @Override
    /// / loaning the book to the next user in the list
    public void loanBookToNextUser(Book book, User user)
    {
        Library library = new Library();

        try {
            library.loanBookTo(book, user);
        }
        catch(Throwable e)
        {
        }
    }
}