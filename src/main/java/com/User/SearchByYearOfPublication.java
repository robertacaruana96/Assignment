package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
public class SearchByYearOfPublication implements Filter<Integer>{
    Catalogue c;

    public Book search(Integer year)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++){
            if (c.bookList.get(i).getYearOfPublication() == year)
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }
}
