package jpa.practice.service;

import jpa.practice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        userService.put();

//        System.out.println(">>> " + userRepository.findByEmail("spammy7147@gmail.com"));

        userRepository.findAll().forEach(System.out::println);
    }


}