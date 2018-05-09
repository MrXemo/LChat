package com.zome.lchat.test;

import com.zome.lchat.entity.User;
import com.zome.lchat.entity.enumerate.Gender;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
    public static void main(String[] args) {
        //1、 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

        //2、 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        //3、 创建元素
        Element element = new Element("key1", "value1");

        //4、 将元素加到缓存
        cache.put(element);

        //5、 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        //6、 删除元素
        cache.remove("key1");

        User user = new User();
        user.setUsername("ehcache 測試");
        user.setPhone("12312341231");
        user.setGender(Gender.female);
        user.setPassword("1231231231");

        //3、 创建元素
        Element element2 = new Element("taidi", user);
        //4、 将元素加到缓存
        cache.put(element2);
        //5、 获取缓存
        Element value2 = cache.get("taidi");
        User user2 = (User) value2.getObjectValue();
        System.out.println(user2.getUsername());
        System.out.println(user2.getPhone());

        System.out.println(cache.getSize());

        //7、 刷新缓存
        cache.flush();

        //8、 关闭缓存管理器
        cacheManager.shutdown();
    }
}
