package com.dgut.music_online;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wt
 * @Date: 2019/4/27 16:54
 */
@SpringBootApplication
@MapperScan("com.dgut.music_online.dao")
public class MusicOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicOnlineApplication.class, args);
    }
}
