package com.funie.user;

import com.funie.springboot.SpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@EnableAutoConfiguration
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {
        // user details to test with
        private final String  name;
        private final String surname;

        @Autowired
        private UserService userService;

        UserServiceImplTest() {
            name = "Lufuno";
            surname = "Madima";
        }
        @Test
        void addUser() {
            assertEquals("Lufuno", userService.addUser(1,name, surname));
        }
        @Test
        void remove() {
            //no return type
        }
        @Test
        void getUser() {
            User user =  new User();
            user.setName(name);
            user.setSurname(surname);
            user.setId(1);
            assertEquals(user.getId(), userService.getUser(1));  // same user id ==> same user
        }
}
