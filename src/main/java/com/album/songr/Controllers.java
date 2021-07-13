//package com.album.songr;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@Controller
//public class Controllers {
//    @Autowired
//    private TestModelDBRepository testModelDBRepository ;
//    @Autowired
//    private TestPostModelRepository testPostModelRepository;
//
//    @GetMapping("/")
//    String splahRoute(){
//        return "splash";
//    }
//    @GetMapping("/hello")
//    String helloRoute(@RequestParam (name = "name", required = false , defaultValue = "There") String name , Model model){
//        model.addAttribute("name" , name);
//        return "hello";
//    }
//
//    @GetMapping("/capitalize/{sentence}")
//    String capitalizeRoute(@PathVariable String sentence , Model model){
//        System.out.println("this is the " + sentence);
//        model.addAttribute("sentence" , sentence.toUpperCase());
//        return "capitalize" ;
//    }
//
////    @ResponseBody
//    @GetMapping("/albums")
//    String albumsRoute(Model model){
//        ArrayList<Album> albums = new ArrayList<>();
//        Album album1 = new Album("Somain" , "stephan");
//        album1.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ72DjWi8QdncosDxEuDykFl3gWWHGhiQq2qg&usqp=CAU");
//        album1.setLengthSecs(180);
//        album1.setSongCount(8);
//
//        Album album2 = new Album("Fine" , "Roy");
//        album2.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7-S1aAUicZuBzpu3PHrKCWBke5IW5RCuyGA&usqp=CAU");
//        album2.setLengthSecs(210);
//        album2.setSongCount(10);
//
//        Album album3 = new Album("Night" , "John");
//        album3.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMyVxPV-RMoG9W0lU1InvdKqc0CTpZ-o3rLQ&usqp=CAU");
//        album3.setLengthSecs(240);
//        album3.setSongCount(14);
//
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        model.addAttribute("album1" , album1);
//        model.addAttribute("album2" , album2);
//        model.addAttribute("album3" , album3);
//        return "splash" ;
//    }
//
//
//    @GetMapping("/test")
//    public String testForm(Model model){
//        model.addAttribute("testObj" , new TestModelDB());
//        return "test" ;
//    }
//
//    @PostMapping("/test")
//    public String testSubmit(@ModelAttribute TestModelDB testModelDB , Model model ){
//        TestModelDB testModelDB1 = testModelDBRepository.save(testModelDB);
//        System.out.println("The text is "+ testModelDB1.getText());
//        model.addAttribute("testObj" , testModelDB1);
//        return "testResults" ;
//    }
//
//    @PostMapping("/postdata")
//    public ResponseEntity<TestPostModel> testPostData(@RequestBody TestPostModel testPostModel){
//        TestPostModel savedata = testPostModelRepository.save(testPostModel);
//        System.out.println("The name in body " + testPostModel.getName());
//        System.out.println("The age in body "+testPostModel.getAge());
//        return new ResponseEntity<>(savedata , HttpStatus.CREATED);
//    }
//
//}
