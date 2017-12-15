package com.kiranpariyar.test.api.dao.impl;

import com.kiranpariyar.test.api.dao.UserDao;
import com.kiranpariyar.test.api.entity.User;

import java.util.UUID;

public class UserDaoImpl extends BaseDao<User, UUID> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

}
