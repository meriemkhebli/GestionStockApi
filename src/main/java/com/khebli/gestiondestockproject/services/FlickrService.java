package com.khebli.gestiondestockproject.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrService  {

    String savePhoto(InputStream photo, String Titre) throws FlickrException;
}
