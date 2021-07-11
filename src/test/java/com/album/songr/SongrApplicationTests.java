package com.album.songr;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@DisplayName("Test Album Class")
	@Test
	public void testAlbum(){
		Album albumTest = new Album("Sonic youth" , "stephan");
		Assertions.assertEquals("Sonic youth" , albumTest.getTitle() , "it should return Sonic youth");
		Assertions.assertEquals("stephan" , albumTest.getArtist() , "it should return stephan");
		albumTest.setSongCount(5);
		Assertions.assertEquals(5 , albumTest.getSongCount() , "it should return 5");
		albumTest.setLengthSecs(180);
		Assertions.assertEquals(180 , albumTest.getLengthSecs() , "it should return 180");
		albumTest.setImageUrl("image Url");
		Assertions.assertEquals("image Url" , albumTest.getImageUrl() , "it should return image Url");
	}

}
