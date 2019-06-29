package com.dgut.music_online.controller;

import com.dgut.music_online.domain.Detail;
import com.dgut.music_online.domain.User;
import com.dgut.music_online.service.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Api(tags = "对用户操作的相关接口")
public class UserManagerController {

    @Autowired
    private User user;

    @Autowired
    private Detail detail;

    @Autowired
    private UserManagerService userManagerService;

    @ApiOperation("用户登陆管理（后台）")
    @PostMapping("/userManage/login")
    public Detail loginManager(@RequestParam("username")Integer username, @RequestParam("password")String password, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        user.setId(username);
        user.setPassword(password);
        detail.setCode(userManagerService.loginManager(user));
        if (detail.getCode() == 200){
            user = userManagerService.getUserById(username);
            Map map = new HashMap<>();
            map.put("user", user);
            detail.setDetail(map);
            httpSession.setAttribute("user", user);
        }else {
            detail.setMessage("密码错误!");
        }
        return detail;
    }

    @ApiOperation("用户注册管理（后台）")
    @PostMapping("/userManage/register")
    public Detail registerManager(@RequestParam("tel")String tel, @RequestParam("IDNumber")String IDNumber){
        return null;
    }

    @ApiOperation("用户添加管理（后台）")
    @PostMapping("/userManage/insertUser")
    public Detail insertUserManager(@RequestParam("nickname")String nickname, @RequestParam("password")String password){
        return null;
    }

    @ApiOperation("用户删除管理（后台）")
    @PostMapping("/userManage/deleteUser")
    public Detail deleteUserManager(@RequestParam("id")Integer id){
        userManagerService.deleteUserById(id);
        return detail;
    }

    @ApiOperation("用户数据分页获取管理（后台）")
    @GetMapping("/userManage/getUsersByPages")
    public Detail getUsersByPagesManager(@RequestParam("pages") int pages){
        List<User> users = userManagerService.getUsersByPages(pages);
        Map map = new HashMap<>();
        map.put("users", users);

        detail.setDetail(map);
        return detail;
    }

    @ApiOperation("根据用户ID获取用户信息")
    @GetMapping("/userManage/{id}")
    public Detail getUserById(@PathVariable("id")Integer id){
        User user = userManagerService.getUserById(id);
        Map map = new HashMap<>();
        map.put("user", user);
        detail.setDetail(map);
        return detail;
    }
}
