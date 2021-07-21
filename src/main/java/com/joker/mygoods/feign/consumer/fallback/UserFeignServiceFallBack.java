package com.joker.mygoods.feign.consumer.fallback;

import com.alibaba.fastjson.JSONObject;
import com.joker.mygoods.feign.consumer.response.User;
import com.joker.mygoods.feign.consumer.service.UserFeignService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: lijiawei04
 * @date: 2021/5/11 8:07 下午
 */
@Slf4j
@Component
@Accessors(chain = true)
public class UserFeignServiceFallBack implements UserFeignService, FallbackFactory<UserFeignService> {

    @Setter
    private Throwable cause;

    public User getUserById(Long userId) {
        commonFallback(userId);
        return null;
    }

    public UserFeignService create(Throwable throwable) {
        return new UserFeignServiceFallBack().setCause(cause);
    }

    private void commonFallback(Object... params) {
        String errMsg = cause == null ? StringUtils.EMPTY : cause.toString();
        log.error("ApiFeignServiceFallback fallback... params is:[{}], cause is:[{}]", JSONObject.toJSONString(params), errMsg);
    }

}
