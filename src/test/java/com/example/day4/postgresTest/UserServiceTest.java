package com.example.day4.postgresTest;


import com.example.day4.Day4Application;
import com.example.day4.entities.User;
import com.example.day4.repositories.UserRepository;
import com.example.day4.service.SpidService;
import com.example.day4.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = {SpidApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SpidService spidService;
    @Autowired
    UserRepository userRepository;

    //creates a new user
    @Test
    public void createUserTest() {
        System.out.println(userService.createUser(new User(
                "name", "surname", "no1", "username", "pass", "email@yahoo.com")
        ));
    }

    @Test
    //finds user with id 1
    public void getUserTest() throws Exception {
        System.out.println(userService.getUser(1L));
    }

    //edits user with id 1, from surname=example to surname=updated
    @Test
    public void editUserTest() throws Exception {
        User user = new User("example", "example", "example", "example", "example", "example");
        userService.editUser(1, user);
        user.setSurname("updated");
        System.out.println(user);
    }
}
