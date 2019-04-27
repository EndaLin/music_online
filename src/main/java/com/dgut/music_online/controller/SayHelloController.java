package com.dgut.music_online.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wt
 * @Date: 2019/4/27 16:55
 */
@RestController
public class SayHelloController {
    @GetMapping("say")
    public String say() {
        return "hello world";
    }
}
