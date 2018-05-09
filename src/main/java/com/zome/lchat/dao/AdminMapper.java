package com.zome.lchat.dao;

import com.zome.lchat.entity.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface AdminMapper {
    Admin loginVerify(Map map);
}
