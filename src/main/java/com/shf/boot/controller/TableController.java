package com.shf.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shf.boot.bean.User;
import com.shf.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.net.idn.Punycode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:Su HangFei
 * @Date:2022-11-14 21 33
 * @Project:boot-05-web-admin
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, @RequestParam(value = "pn", defaultValue = "1") Integer pn, RedirectAttributes redirectAttributes) {

        userService.removeById(id);

        redirectAttributes.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("张三", "123456"), new User("李四", "1234444"), new User("王五", "wangwu"));
//        model.addAttribute("users",users);

        //从数据库的User表中查出
        List<User> list = userService.list();
        model.addAttribute("users", list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page", page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

}
