package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;

import java.util.List;


@TableName(value = "t_role", autoResultMap = true)
public class Role extends Model<Role> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String description;

    //在mybatisplus 中 该注解是 把数据库中的数组 变成json
    //[{"id":26,"name":"项目管理","path":"/page/end/item.html","description":"单个美容项目的管理与操作","flag":"item"},{"id":27,"name":"项目组管理","path":"/page/end/itemGroup.html","description":"一组同类的项目的分组","flag":"itemGroup"}]
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Permission> permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

}
