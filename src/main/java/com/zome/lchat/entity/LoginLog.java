package com.zome.lchat.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class LoginLog implements Serializable {
    private int id;
    private int userId;
    private String ip;
    private Data loginDatae;
}
