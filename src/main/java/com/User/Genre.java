package com.User;

/**
 * Created by Bobby on 22-Apr-16.
 */
public class Genre {
    String genreType;

    public Genre()
    {
        genreType = null;
    }

    public Genre(String genreType)
    {
        this.genreType = genreType;
    }

    public String getGenreType()
    {
        return genreType;
    }

    public void setGenreType(String genreType)
    {
        this.genreType = genreType;
    }
}
