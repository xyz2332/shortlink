package com.jinyawen.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jinyawen.shortlink.admin.dao.entity.UserDO;
import com.jinyawen.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.jinyawen.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserRespDTO getUserByUsername(String username);
    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    Boolean hasUsername(String username);

    /**
     * 用户注册
     *
     * @param requestParam 注册参数
     */
    void register(UserRegisterReqDTO requestParam);

}

