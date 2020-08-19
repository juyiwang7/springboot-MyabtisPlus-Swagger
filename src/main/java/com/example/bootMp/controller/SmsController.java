package com.example.bootMp.controller;

import com.example.bootMp.service.SendSms;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Create By weisan on 2020/8/19.
 */
@CrossOrigin
@RestController
public class SmsController {
    @Autowired
    private SendSms sendSms;

    @Resource(name = "stringRedisKeyDatabase")
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/send/{phone}")
    public String code(@PathVariable("phone") String phone){
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)){
            return phone+":"+code+"已存在，还没过期！";
        }
        // 生成验证码并存储到redis中
        code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<String,Object> param = new HashMap<>();
        param.put("code",code);
        boolean success = sendSms.send(phone, "SMS_200185042", param);
        if (success){
            redisTemplate.opsForValue().set(phone,code,5,TimeUnit.MINUTES);
            return phone+":"+code+"发送成功!";
        }else {
            return phone+":"+code+"发送失败!";
        }
    }
}
