package com.kanchutech.eden.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.UploadedImage;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.media.MediaByteArraySource;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class PicasaImageUploadService implements IImageUploadService {

	private static final String PLACEHOLD_IMAGE_URL = "http://placehold.it/400x300";
	private static final String MEDIA_TYPE_IMAGE_JPEG = "image/jpeg";
	private static final String APP_NAME = "EdenLeathers";
	private static final String PICASA_USER_NAME = "kanchutechnologies@gmail.com";
	private static final String PICASA_PASSWORD = "Qudsia*90";
	private static final String PICASA_ALBUM_ID_EDEN = "5990977991000178753";
	private static final String PICASA_USER_ID_EDEN = "kanchutechnologies";
	private static final String PICASA_EDEN_ALBUM_FEED_URL = "https://picasaweb.google.com/data/feed/api/user/"+PICASA_USER_ID_EDEN+"/albumid/"+PICASA_ALBUM_ID_EDEN;
	
	@Override
	public String uploadPhoto(Product product, UploadedImage image) {
		// FIXME remove all the stack traces and replace with loggers
		String imageUrl = null;
		try {
			URL albumPostUrl = new URL(PICASA_EDEN_ALBUM_FEED_URL);
			PhotoEntry myPhoto = new PhotoEntry();
			myPhoto.setTitle(new PlainTextConstruct(product.getName()));
			myPhoto.setDescription(new PlainTextConstruct(product.getLongDescription()));
			MediaByteArraySource myMediaSource = new MediaByteArraySource(image.getData(), MEDIA_TYPE_IMAGE_JPEG);
			myPhoto.setMediaSource(myMediaSource);
			PhotoEntry returnedPhoto = getPicasaWebService().insert(albumPostUrl, myPhoto);
			imageUrl = returnedPhoto.getMediaThumbnails().get(2).getUrl();
		} catch (MalformedURLException e) {
			imageUrl = PLACEHOLD_IMAGE_URL;
			e.printStackTrace();
		} catch (AuthenticationException e) {
			imageUrl = PLACEHOLD_IMAGE_URL;
			e.printStackTrace();
		} catch (IOException e) {
			imageUrl = PLACEHOLD_IMAGE_URL;
			e.printStackTrace();
		} catch (ServiceException e) {
			imageUrl = PLACEHOLD_IMAGE_URL;
			e.printStackTrace();
		}
		return imageUrl;
	}
	
	public static PicasawebService getPicasaWebService() throws AuthenticationException{
		PicasawebService myService = new PicasawebService(APP_NAME);
		myService.setUserCredentials(PICASA_USER_NAME, PICASA_PASSWORD);
		return myService;
	}

}
