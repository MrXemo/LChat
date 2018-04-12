package com.zome.lchat.dao;


import com.zome.lchat.entity.User;

import java.util.Map;

public interface UserMapper {
    User login(Map map);
}
