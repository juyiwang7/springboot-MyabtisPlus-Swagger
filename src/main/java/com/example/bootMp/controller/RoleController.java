package com.example.bootMp.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bootMp.entity.Role;
import com.example.bootMp.service.IRoleService;
import com.example.bootMp.utils.HttpClientResult;
import com.example.bootMp.utils.HttpClientUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author weisan
 * @since 2020-04-17
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private IRoleService roleService;


    @ResponseBody
    @ApiOperation(value = "查找所有的角色类型",notes = "查找所有的角色类型")
    @RequestMapping(value = "/allList",method = RequestMethod.GET)
    private List<Role> RoleAllList(Role role){
        List<Role> roles = roleService.GetAllRoles(role);
        return roles;
    }

    @ResponseBody
    @ApiOperation(value = "测试HttpClient",notes = "测试HttpClient")
    @RequestMapping(value = "/testClient",method = RequestMethod.GET)
    private List<Role> TestHttpClient(Role role)throws Exception{

        //HttpClientResult result = HttpClientUtils.doGet("http://120.26.174.179:6991/role/allList");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.01:8080/role/allList");
        System.out.println(result.getContent());

        HttpClientResult result1 = HttpClientUtils.doGet("http://inner.imayuan.com:48068/getChainDomain");
        System.out.println(result1);

        List<Role> list = JSONObject.parseArray(result.getContent(),Role.class);
        System.out.println("这是str转List的返回结果:"+list);
        return list;
    }

}

