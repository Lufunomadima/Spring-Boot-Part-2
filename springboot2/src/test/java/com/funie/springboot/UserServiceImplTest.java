package com.funie.springboot;
import com.funie.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableAutoConfiguration
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableCaching
public class UserServiceImplTest {
    @Autowired
    private TestRestTemplate restTemplate;
    // user details
    private final String  name;
    private final String surname;

    @Autowired
    private UserService userService;
    UserServiceImplTest() throws Exception {
        name = "Lufuno";
        surname = "Madima";
    }
    @Test
    void addUser() {
        assertEquals("Lufuno", userService.addUser(1,name, surname));
    }
    @Test
    void remove() {
    }
    @Test
    public void getUser() {
        User user =  new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(1);
        assertEquals(user.getId(), userService.getUser(1));
    }
    //caching
    @Cacheable("name")
    @Test
    public void getUserFourTimes(){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(1);
        for (int i = 1; i <= 4; i++){
            assertEquals(user.getId(), userService.getUser(1));
        }
    }
}
