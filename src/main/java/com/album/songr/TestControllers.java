package com.album.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestControllers {

    @Autowired
    private SchoolRepo schoolRepo ;
    @Autowired
    private TestPostModelRepository testPostModelRepository ;
    @Autowired
    private TestModelDBRepository testModelDBRepository ;

    @GetMapping("/test")
    public String testForm(Model model){
        model.addAttribute("testObj" , new TestModelDB());
        return "test" ;
    }

    @PostMapping("/test")
    public String testSubmit(@ModelAttribute TestModelDB testModelDB , Model model ){
        TestModelDB testModelDB1 = testModelDBRepository.save(testModelDB);
        System.out.println("The text is "+ testModelDB1.getText());
        model.addAttribute("testObj" , testModelDB1);
        return "testResults" ;
    }

    @PostMapping("/postdata")
    public ResponseEntity<TestPostModel> testPostData(@RequestBody TestPostModel testPostModel){
        TestPostModel savedata = testPostModelRepository.save(testPostModel);
        System.out.println("The name in body " + testPostModel.getName());
        System.out.println("The age in body "+testPostModel.getAge());
        return new ResponseEntity<>(savedata , HttpStatus.CREATED);
    }

    @PostMapping("/school")
    public ResponseEntity<School> testSchool(@RequestBody School school){
        School savedSchool = schoolRepo.save(school);
        return new ResponseEntity<>(savedSchool , HttpStatus.CREATED);
    }
    @PostMapping("/schooltest/{id}/post/{postId}")
    public ResponseEntity<TestPostModel> testRealtionship(@PathVariable Long id , @PathVariable Long postId){
        System.out.println("First Id "+id);
        System.out.println("Second Id " + postId);
        School school = schoolRepo.findById(id).orElseThrow();
        TestPostModel testPostModel = testPostModelRepository.findById(postId).orElseThrow();
        testPostModel.setSchool(school);
        testPostModelRepository.save(testPostModel);
        return new ResponseEntity<>(testPostModelRepository.save(testPostModel) , HttpStatus.CREATED);
    }

}
