package com.album.songr;

import javax.persistence.*;

@Entity
public class TestPostModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    @Column(name="names" , length=100 , nullable = false , unique = true)
    private String name ;
    private int age ;

    @ManyToOne
    @JoinColumn(name="schoold_id")
    private School school ;

    public TestPostModel(){

    }

    public TestPostModel(String name , int age){
        this.name = name ;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
