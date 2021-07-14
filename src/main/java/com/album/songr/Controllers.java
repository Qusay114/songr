
package com.album.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class Controllers {

    @Autowired
    AlbumRepository albumRepository ;


    @GetMapping("/")
    String splahRoute() {
        return "splash";
    }

    @GetMapping("/hello")
    String helloRoute(@RequestParam(name = "name", required = false, defaultValue = "There") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/capitalize/{sentence}")
    String capitalizeRoute(@PathVariable String sentence, Model model) {
        System.out.println("this is the " + sentence);
        model.addAttribute("sentence", sentence.toUpperCase());
        return "capitalize";
    }

    //    @ResponseBody
    @GetMapping("/albums")
    public String albumsRoute(Model model) {
        ArrayList<Album> albums = new ArrayList<>();
        Album album1 = new Album("Somain", "stephan");
        album1.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ72DjWi8QdncosDxEuDykFl3gWWHGhiQq2qg&usqp=CAU");
        album1.setLengthSecs(180);
        album1.setSongCount(8);

        Album album2 = new Album("Fine", "Roy");
        album2.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7-S1aAUicZuBzpu3PHrKCWBke5IW5RCuyGA&usqp=CAU");
        album2.setLengthSecs(210);
        album2.setSongCount(10);

        Album album3 = new Album("Night", "John");
        album3.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMyVxPV-RMoG9W0lU1InvdKqc0CTpZ-o3rLQ&usqp=CAU");
        album3.setLengthSecs(240);
        album3.setSongCount(14);

        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        model.addAttribute("album1", album1);
        model.addAttribute("album2", album2);
        model.addAttribute("album3", album3);
        model.addAttribute("albumObj", new Album());
        return "albums";
    }

    @PostMapping("/albums")
    public String addAlbum(@ModelAttribute Album album , Model model){
        Album savedAlbum = albumRepository.save(album);
        System.out.println("The title is "+savedAlbum.getTitle());
        model.addAttribute("AddedAlbum" , savedAlbum);
        return "addedAlbum";
    }



}

