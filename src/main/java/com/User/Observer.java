package com.User;

/**
 * Created by Bobby on 05-May-16.
 */
public interface Observer
{
    public void update(Book book, User user);
    public void loanBookToNextUser(Book book, User user);
}
