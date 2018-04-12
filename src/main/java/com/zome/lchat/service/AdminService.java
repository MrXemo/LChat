package com.zome.lchat.service;

import com.zome.lchat.entity.Admin;

public interface AdminService {

    Admin loginAdmin(String userName, String password);

    void loginSuccess(Admin admin);
}
