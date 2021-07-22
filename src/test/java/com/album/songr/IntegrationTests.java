package com.album.songr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc ;
    @Autowired
    private ObjectMapper objectMapper ;
    @Autowired
    private AlbumRepository albumRepository ;
    @Autowired
    private SongRepository songRepository ;

    @DisplayName("test create a new album")
    @Test
    public void testAddNewAlbum() throws Exception {
//        Long albumsNum = albumRepository.count();
        Album album = new Album("Moon2","Jack",20 , 3800 , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7BDDFBi4o81prjknTwTjKrUHs_A0Z5XdUpg&usqp=CAU");
        mockMvc.perform(post("/albumstest")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(album)))
                .andExpect(status().isCreated());
        Long albumsNum = albumRepository.count();
        Album foundAlbum = albumRepository.findById(albumsNum).orElseThrow();
        Assertions.assertEquals(album.getTitle() , foundAlbum.getTitle() , "The Title should be Moon");
        Assertions.assertEquals(album.getArtist() , foundAlbum.getArtist() , "The Artist should be Jack");
        Assertions.assertEquals(album.getSongCount() , foundAlbum.getSongCount() , "The Song Count should be 20");
        Assertions.assertEquals(album.getLengthSecs() , foundAlbum.getLengthSecs() , "The Length in seconds should be 3800");
    }

    @DisplayName("test create a new song")
    @Test
    public void testAddNewSong() throws Exception {
        Long songsNum = songRepository.count();
        String url = "/songs/1?title=rap&length=240&trackNumber=5";
        mockMvc.perform(post(url));
        Song foundSong = songRepository.findById(songsNum+1).orElseThrow();
        Assertions.assertEquals("rap" , foundSong.getTitle() , "the title should be rap");
        Assertions.assertEquals(240 , foundSong.getLength() , "the length should be 240");
        Assertions.assertEquals(5 , foundSong.getTrackNumber() , "the track number should be 5");
    }
}
