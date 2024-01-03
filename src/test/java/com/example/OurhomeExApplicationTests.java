package com.example;

import com.example.domain.dto.SiteUser;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OurhomeExApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testJpa1() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user1 = new SiteUser();
        user1.setUsername("ourhome1");
        user1.setPassword(passwordEncoder.encode("password1"));
        user1.setEmail("ourhome1@ourhome.com");
        user1.setNumber("010-1111-1111");
        this.userRepository.save(user1);
    }

    @Test
    void testJpa2() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user2 = new SiteUser();
        user2.setUsername("ourhome2");
        user2.setPassword(passwordEncoder.encode("password2"));
        user2.setEmail("ourhome2@ourhome.com");
        user2.setNumber("010-2222-2222");
        this.userRepository.save(user2);
    }

    @Test
    void testJpa3() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user3 = new SiteUser();
        user3.setUsername("ourhome3");
        user3.setPassword(passwordEncoder.encode("password3"));
        user3.setEmail("ourhome3@ourhome.com");
        user3.setNumber("010-3333-3333");
        this.userRepository.save(user3);
    }

    @Test
    void testJpa4() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user4 = new SiteUser();
        user4.setUsername("ourhome4");
        user4.setPassword(passwordEncoder.encode("password4"));
        user4.setEmail("ourhome4@ourhome.com");
        user4.setNumber("010-4444-4444");
        this.userRepository.save(user4);
    }

    @Test
    void testJpa5() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user5 = new SiteUser();
        user5.setUsername("ourhome5");
        user5.setPassword(passwordEncoder.encode("password5"));
        user5.setEmail("ourhome5@ourhome.com");
        user5.setNumber("010-5555-5555");
        this.userRepository.save(user5);
    }

}
