
package com.album.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controllers {

    @Autowired
    AlbumRepository albumRepository ;
    @Autowired
    SongRepository songRepository ;


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

    @GetMapping("/albums")
    public String albumsRoute(Model model) {
        List<Album> albums = new ArrayList<>();

        if(albumRepository.findAll().isEmpty()) {
            albums = saveAlbumsStatic() ;
            albumRepository.saveAll(albums);
        }
        albums = albumRepository.findAll();
        model.addAttribute("albums" , albums);
        model.addAttribute("albumObj", new Album());
        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@ModelAttribute Album album){
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}")
    public String showSongs(@PathVariable Long id , Model model){
        Album album = albumRepository.findById(id).orElseThrow();
        List<Song> songs = album.getSongs();
        model.addAttribute("songs" , songs);
        return "songs";
    }

    @PostMapping("/songs/{albumId}")
    public RedirectView addSong(@RequestParam String title , @RequestParam Long length
                                ,@RequestParam Long trackNumber , @PathVariable Long albumId){
        Song song = new Song(title , length , trackNumber );
        System.out.println("ALbum id " + albumId);
        Album album = albumRepository.findById(albumId).orElseThrow();
        song.setAlbum(album);
        songRepository.save(song);
        return new RedirectView("/albums/{albumId}");
    }

    @PostMapping("/albumstest")
    public ResponseEntity<Album> addNewAlbumForTest(@RequestBody Album album){
        Album savedAlbum = albumRepository.save(album);
        return new ResponseEntity<>(savedAlbum , HttpStatus.CREATED);
    }


    private List saveAlbumsStatic(){
        List<Album> albums = new ArrayList<>();
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
        return albums ;
    }


}

