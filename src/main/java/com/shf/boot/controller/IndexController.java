package com.shf.boot.controller;

import com.shf.boot.bean.City;
import com.shf.boot.bean.MovieSimilar;
import com.shf.boot.bean.User;
import com.shf.boot.service.CityService;
import com.shf.boot.service.MovieSimilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author:Su HangFei
 * @Date:2022-11-14 20 40
 * @Project:boot-05-web-admin
 */

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    MovieSimilarService movieSimilarService;
    @Autowired
    CityService cityService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") long id) {
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/mid")
    public MovieSimilar getByMid(@RequestParam("id") int id) {
        return movieSimilarService.getByMid(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    //TODO:去登陆页
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "000000".equals(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            //TODO:登陆成功重定向到main.html,重定向防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

//        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
//        String s = stringStringValueOperations.get("/main.html");
//        String s1 = stringStringValueOperations.get("/sql");
//
//        model.addAttribute("mainCount",s);
//        model.addAttribute("sqlCount",s1);

        return "main";
    }
}
