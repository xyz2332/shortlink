package com.jinyawen.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.jinyawen.shortlink.admin.common.convention.result.Result;
import com.jinyawen.shortlink.admin.common.convention.result.Results;
import com.jinyawen.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.jinyawen.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.jinyawen.shortlink.admin.dto.resp.UserActualRespDTO;
import com.jinyawen.shortlink.admin.dto.resp.UserRespDTO;
import com.jinyawen.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制层
 */

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username){
        UserRespDTO result = userService.getUserByUsername(username);

        return Results.success(result);
    }
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username){
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }
    /**
     * 判断用户名是否存在
     */
    @GetMapping("/api/short-link/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username){
        return Results.success(userService.hasUsername(username));
    }

    @PostMapping("/api/short-link/v1/user")
    public Result<Void>register(@RequestBody UserRegisterReqDTO requestParam){
        userService.register(requestParam);
        return Results.success();
    }
}
