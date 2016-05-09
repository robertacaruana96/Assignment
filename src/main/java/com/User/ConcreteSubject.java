package com.User;

import java.util.*;
import java.util.Observer;
/**
 * Created by Bobby on 06-May-16.
 */

public class ConcreteSubject implements Subject {

    // The list of users who want to borrow the book
    protected ArrayList<com.User.Observer> pendingUsers = new ArrayList<com.User.Observer>();

    @Override
    public void addObserver(com.User.Observer observer)
    {
        // add users to the pending user list
        pendingUsers.add(observer);
        System.out.println("Size after add: " + pendingUsers.size());
    }

    @Override
    public void removeObserver(com.User.Observer observer)
    {
        // remove users from the pending users list
        pendingUsers.remove(observer);
        //setPendingUsers(pendingUsers.remove(observer));
    }

    @Override
    public String notifyObserver(Book book, User user)
    {
        // Storing user with respective index in 2 seperate array list
        ArrayList<com.User.Observer> userInList = new ArrayList<com.User.Observer>();
        ArrayList<Integer> positionsInList = new ArrayList<Integer>();

        int position = 0;

        // inform the users about a change in the list
        // Iterate over the list of users who showd interet in the book and call their update method

        for(com.User.Observer user1: pendingUsers)
        {
            user1.update(book, user);

            // traversing pending user list and storing position and user at position
            for(int k = 0; k<pendingUsers.size(); k++)
            {
                position++;
                userInList.add(pendingUsers.get(k));
                positionsInList.add(k);
            }
        }
        return "Next user in queue has loaned the book";
    }
}
