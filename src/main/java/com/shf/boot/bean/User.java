package com.shf.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Su HangFei
 * @Date:2022-11-14 21 17
 * @Project:boot-05-web-admin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
