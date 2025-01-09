package com.feiniaojin.ddd.live.ui.web.controller;

import com.feiniaojin.gracefulresponse.api.ExcludeFromGracefulResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("login")
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", UUID.randomUUID().toString());
        return map;
    }

    @RequestMapping("info")
    public Map<String, Object> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", Collections.singletonList("admin"));
        map.put("name", "Super Admin");
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return map;
    }
}
