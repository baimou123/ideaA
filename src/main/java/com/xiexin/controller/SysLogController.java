package com.xiexin.controller;

import com.xiexin.bean.SysLog;
import com.xiexin.respcode.Result;
import com.xiexin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/selectAll") // /syslog/selectAll
    public Result selectAll(){
        List<SysLog> sysLogs = sysLogService.selectByExample(null);
        Result result = new Result(sysLogs);
        return result;
    }
}

