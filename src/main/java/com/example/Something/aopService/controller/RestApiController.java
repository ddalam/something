package com.example.Something.aopService.controller;

import com.example.Something.aopService.annotation.Decode;
import com.example.Something.aopService.annotation.Timer;
import com.example.Something.aopService.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        // AOP에서 출력하기 때문에 이제 controller에서 출력할 필요X
//        System.out.println("id = " + id);
//        System.out.println("name = " + name);

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        // AOP에서 출력하기 때문에 이제 controller에서 출력할 필요X
//        System.out.println("user = " + user);

        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logig

        Thread.sleep(1000 * 2);
    }

    @Decode
    @PutMapping("/put")
    public User post(@RequestBody User user) {

        return user;
    }
}
