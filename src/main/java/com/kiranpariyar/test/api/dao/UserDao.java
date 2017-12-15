package com.kiranpariyar.test.api.dao;

import com.kiranpariyar.test.api.entity.User;

import java.util.UUID;

public interface UserDao extends CrudDao<User, UUID> {
}
