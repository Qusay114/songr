package com.album.songr;

import javax.persistence.*;

@Entity(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long songId ;

    private String title ;
    private Long length ;
    private Long trackNumber ;

    @ManyToOne
    @JoinColumn(name="album_Id")
    private Album album ;

    public Song(){

    }
    public Song(String title , Long length , Long trackNumber){
        this.title = title ;
        this.length = length ;
        this.trackNumber = trackNumber;
    }

    public Long getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public Long getLength() {
        return length;
    }

    public Long getTrackNumber() {
        return trackNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public void setTrackNumber(Long trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}

