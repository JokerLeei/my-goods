package com.joker.mygoods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lijiawei04
 * @date: 2021/5/10 8:35 下午
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    private String index() {
        return "my-goods 服务运行中···";
    }

}
