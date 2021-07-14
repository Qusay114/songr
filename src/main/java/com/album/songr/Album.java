package com.album.songr;

import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;

    @Column(name="titles", length=50, nullable=false, unique=true)
    private String title ;
    private String artist ;
    private int songCount ;
    private int lengthSecs ;
    private String imageUrl ;

    public Album(){

    }

    public Album(String title , String artist){
        this.title = title ;
        this.artist = artist ;
    }


    public Album(String title , String artist , int songCount , int lengthInSeconds , String imageUrl){
        this.title = title ;
        this.artist = artist ;
        this.songCount = songCount ;
        this.lengthSecs = lengthInSeconds ;
        this.imageUrl = imageUrl ;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist(){
        return artist ;
    }
    public int getSongCount(){
        return songCount ;
    }

    public int getLengthSecs() {
        return lengthSecs;
    }
    public String getImageUrl(){
        return imageUrl ;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setSongCount(int songCount){
        this.songCount = songCount ;
    }
    public void setLengthSecs(int lengthInSeconds){
        this.lengthSecs = lengthInSeconds ;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
