package com.zome.lchat.service;

public interface VerificationCodeServier {
    Integer findCode(String phone);

    void updataCode(String phone);

    void addCode(String phone);
}
