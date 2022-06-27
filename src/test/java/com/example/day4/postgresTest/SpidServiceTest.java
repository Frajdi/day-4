package com.example.day4.postgresTest;


import com.example.day4.Day4Application;
import com.example.day4.entities.Spid;
import com.example.day4.entities.User;
import com.example.day4.entities.enums.Status;
import com.example.day4.entities.enums.Type;
import com.example.day4.service.SpidService;
import com.example.day4.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpidApplication.class})
public class SpidServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    SpidService spidService;

    //creates a new spid connected to the user with id=1
    @Test
    public void createSpidTest() throws Exception {
        User firstUser = userService.getUser(1L);
        Spid newSpid = spidService.createSpid(new Spid(Status.PENDING, Type.LEVEL_1, firstUser));
    }

    //test the list of all spids
    @Test
    public void retrieveAllSpidsTest() throws Exception {
        System.out.println(spidService.retrieveAllSpids());
    }


}