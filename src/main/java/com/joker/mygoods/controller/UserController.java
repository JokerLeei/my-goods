package com.joker.mygoods.controller;

import com.joker.mygoods.feign.consumer.response.User;
import com.joker.mygoods.feign.consumer.service.UserFeignService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: lijiawei04
 * @date: 2021/5/27 7:14 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFeignService userFeignService;

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userFeignService.getUserById(userId);
    }

}
