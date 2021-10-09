package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TestController {
    @RequestMapping("/sessionList") // /api/sessionList
    public String studentList(){
        return "sessionlist";
    }

    @RequestMapping("/sysList") // /api/sysList
    public String sysList(){
        return "syslist";
    }
}
