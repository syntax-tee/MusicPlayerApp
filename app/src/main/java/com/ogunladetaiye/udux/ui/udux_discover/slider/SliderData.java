package com.ogunladetaiye.udux.ui.udux_discover.slider;

public class SliderData {

    private String imageUrl;
    private String artistName;
    private String albumTitle;

    public SliderData(String imageUrl, String artistName, String albumTitle) {
        this.imageUrl = imageUrl;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}