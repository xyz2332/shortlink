package com.jinyawen.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinyawen.shortlink.admin.common.convention.exception.ClientException;
import com.jinyawen.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.jinyawen.shortlink.admin.dao.entity.UserDO;
import com.jinyawen.shortlink.admin.dao.mapper.UserMapper;
import com.jinyawen.shortlink.admin.dto.resp.UserRespDTO;
import com.jinyawen.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    @Override
    public UserRespDTO getUserByUsername(String username) {

        LambdaQueryWrapper<UserDO>queryWrapper= Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO != null) {
            UserRespDTO result = new UserRespDTO();
            BeanUtils.copyProperties(userDO, result);
            return result;
        }else {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
    }
}
