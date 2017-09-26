package com.ityun.waiwai.service.impl;

import com.ityun.waiwai.dao.UserMapper;
import com.ityun.waiwai.model.User;
import com.ityun.waiwai.service.UserService;
import com.ityun.waiwai.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/09/26.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
