package com.example.songapplication.network;


import com.google.gson.annotations.SerializedName;

public class Songs {

    @SerializedName("song")
    private String title;
    @SerializedName("artists")
    private String artists;
    @SerializedName("cover_image")
    private String songCoverImage;
    @SerializedName("url")
    private String songUrl;

    public Songs(){}

    public Songs(String title, String artists, String songCoverImage, String songUrl) {
        this.title = title;
        this.artists = artists;
        this.songCoverImage = songCoverImage;
        this.songUrl = songUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getSongCoverImage() {
        return songCoverImage;
    }

    public void setSongCoverImage(String songCoverImage) {
        this.songCoverImage = songCoverImage;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
