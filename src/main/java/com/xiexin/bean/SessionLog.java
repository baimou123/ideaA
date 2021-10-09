package com.xiexin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * session_log
 * @author 
 */
public class SessionLog implements Serializable {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Gmt+8")
    private Date actionTime;

    private Integer userid;

    private Integer pageid;

    private String sessionid;

    private static final long serialVersionUID = 1L;

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }
}