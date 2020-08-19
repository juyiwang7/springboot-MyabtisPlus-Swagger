package com.example.bootMp.service;

import java.util.Map;

/**
 * Create By weisan on 2020/8/19.
 */
public interface SendSms {
    public boolean send(String phone, String templateCode, Map<String,Object> code);
}
