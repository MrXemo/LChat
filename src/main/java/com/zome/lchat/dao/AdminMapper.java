package com.zome.lchat.dao;

import com.zome.lchat.entity.Admin;

import java.util.Map;

public interface AdminMapper {
    Admin loginVerify(Map map);
}
