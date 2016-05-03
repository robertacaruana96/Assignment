package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
public class searchByTitle implements Filter<String>
{
    Catalogue c;
    //@Override
    public Book search(String title)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if (c.bookList.get(i).getTitle().equalsIgnoreCase(title))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }
}
