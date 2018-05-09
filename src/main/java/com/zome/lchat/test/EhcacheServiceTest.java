package com.zome.lchat.test;

import com.zome.lchat.service.EhcacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EhcacheServiceTest extends SpringTestCase {

    @Autowired
    private EhcacheService ehcacheService;

    // 有效时间是5秒，第一次和第二次获取的值是一样的，因第三次是5秒之后所以会获取新的值
    @Test
    public void testTimestamp() throws InterruptedException{
        System.out.println("第一次调用： " + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("第二次调用： " + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("第三次调用： " + ehcacheService.getTimestamp("param"));
    }

    @Test
    public void testCache(){
        String key = "zhangsna";
        String value = ehcacheService.getDataFromDB(key);
        System.out.println(value);
        ehcacheService.getDataFromDB(key);  // 从缓存中获取数据，所以不执行该方法体
        System.out.println(value);
        ehcacheService.removeDataAtDB(key); // 从数据库中删除数据
        ehcacheService.getDataFromDB(key); // 从数据库中获取数据...（缓存数据删除了，所以要重新获取，执行方法体）
        System.out.println(value);
    }

    @Test
    public void testPut(){
        String key = "mengdee";
        ehcacheService.refreshData(key);  // 模拟从数据库中加载数据
        String data = ehcacheService.getDataFromDB(key);
        System.out.println("data:" + data); // data:mengdee::103385

        ehcacheService.refreshData(key);  // 模拟从数据库中加载数据
        String data2 = ehcacheService.getDataFromDB(key);
        System.out.println("data2:" + data2);   // data2:mengdee::180538
    }
}
