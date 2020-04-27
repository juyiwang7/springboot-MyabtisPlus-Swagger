package com.example.bootMp.common.component;

import java.util.Map;

/**
 * @Usage: Token操作
 * @Author: gjq
 * @Date: 2019/3/19 5:00 PM
 */
public interface TokenComponent {
    /**
     * Token签发
     *
     * @param id
     * @param claims 封装信息
     * @return
     */
    String generateToken(String id, Map claims);

    /**
     * 获取Token中信息，null为Token不合法
     *
     * @param token
     * @return
     */
    Map getClaimsFromToken(String token);

    /**
     * 从过期Token获取信息，null为Token不合法
     *
     * @param token
     * @return
     */
    Map<String, Object> getClaimsFromOldToken(String token);
}
