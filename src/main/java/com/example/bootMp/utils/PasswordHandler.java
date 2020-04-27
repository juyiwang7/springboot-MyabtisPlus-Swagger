package com.example.bootMp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @Usage: 旧系统Md5加密方式
 * @Author: gjq
 * @Date: 2019/4/10 3:28 PM
 */
public class PasswordHandler {

    private static Logger log = LoggerFactory.getLogger(PasswordHandler.class);

    /**
     * MD5加密,结果为大写
     *
     * @param string
     * @return
     */
    public static String convertToMD5(String string) {
        if (string == null || "".equals(string)) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.warn("MD5加密失败：" + string, e);
            return null;
        }
    }

    public static String generatePassWord() {
        String newPass = new String();
        String Base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new SecureRandom();
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7,12}$";
        boolean matche = false;
        while (!matche) {
            newPass = "";
            for (int i = 0; i < 7; i++) {
                int number = random.nextInt(Base.length());
                newPass += Base.charAt(number);
                matche = newPass.matches(regex);
            }
        }
        return newPass;
    }

    public static void main(String[] args) {
        System.out.println(convertToMD5("123456").toLowerCase());
    }
}
