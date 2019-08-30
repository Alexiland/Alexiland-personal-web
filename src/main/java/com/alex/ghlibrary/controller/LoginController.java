package com.alex.ghlibrary.controller;


import com.alex.ghlibrary.pojo.User;
import com.alex.ghlibrary.result.Result;
import com.alex.ghlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;


import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if(user == null){
            return new Result(400);
        }else{
            session.setAttribute("user", user);
            return new Result(200);
        }

    }
}

