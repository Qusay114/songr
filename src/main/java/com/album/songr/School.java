package com.album.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;

    @OneToMany(mappedBy="school")
    private List<TestPostModel> posts ;

    private String name ;
    public School(){

    }
    public School(String name){
        this.name = name ;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
