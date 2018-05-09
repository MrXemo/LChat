package com.zome.lchat.service;

import com.zome.lchat.entity.User;

public interface EhcacheService {
    // 测试失效情况，有效期为5秒
    String getTimestamp(String param);

    String getDataFromDB(String key);

    void removeDataAtDB(String key);

    String refreshData(String key);

    User findById(String userId);

    boolean isReserved(String userId);

    void removeUser(String userId);

    void removeAllUser();
}
