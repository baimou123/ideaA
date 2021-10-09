package com.xiexin.controller;

import com.xiexin.bean.SessionLog;
import com.xiexin.respcode.Result;
import com.xiexin.service.SessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessionlog")
public class SessionLogController {  // /sessionlog/selectAll
    @Autowired
    private SessionLogService sessionLogService;
    @RequestMapping("/selectAll")
    public Result selectAll(){
        List<SessionLog> sessionLogs = sessionLogService.selectByExample(null);
        Result result = new Result(sessionLogs);
        return result;
    }
}

