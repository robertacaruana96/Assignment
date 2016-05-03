package com.User;

/**
 * Created by Bobby on 03-May-16.
 */
public class SearchByGenre implements Filter<Genre> {
    Catalogue c;

    public Book search(Genre genre)
    {
        Book result = null;
        for (int i = 0; i < c.bookList.size(); i++)
        {
            if (c.bookList.get(i).getGenre().getGenreType().equals(genre.getGenreType()))
            {
                result = c.bookList.get(i);
            }
        }
        return result;
    }

}
