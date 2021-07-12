package com.album.songr;

import javax.persistence.*;

@Entity
public class TestModelDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="test" , length=100 , nullable = false , unique = true)
    private String text ;
    public TestModelDB(){

    }

    public Long getId(){
        return id ;
    }

    public String getText(){
        return text ;
    }

    public void setText(String text){
        this.text = text ;
    }
}
