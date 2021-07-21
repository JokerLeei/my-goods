package com.joker.mygoods.feign.consumer.service;

import com.joker.mygoods.feign.constant.FeignClientConstant;
import com.joker.mygoods.feign.consumer.response.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lijiawei04
 * @date: 2021/5/11 8:01 下午
 */
@FeignClient(
    value = FeignClientConstant.USER_SERVICE
)
public interface UserFeignService {

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable("userId") Long userId);

}
