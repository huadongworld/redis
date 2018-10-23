package com.ys.redis.dao.jedis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author HD
 * @date 2018/10/23 16:47
 *
 * Jedis操作redis数据库
 */
@Component
public class JedisDao {

    /**
     * 连接redis服务
     *
     * @return
     */
    public Jedis connectRedis() {

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");

        //查看服务是否运行，输出PONG表示redis服务正在运行
        System.out.println("服务正在运行: " + jedis.ping());

        return jedis;
    }

    /**
     * 插入String类型的数据
     *
     * @param jedis
     */
    public void insertStr(Jedis jedis) {

        jedis.set("name", "huadong");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("name"));
    }

    /**
     * 插入List类型的数据
     *
     * @param jedis
     */
    public void insertList(Jedis jedis) {

        //存储数据到列表中
        jedis.lpush("name1", "Runoob");
        jedis.lpush("name1", "Google");
        jedis.lpush("name1", "Taobao");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("name1", 0, 2);

        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }

    /**
     * 查询redis中所有的key
     *
     * @param jedis
     */
    public void findAllKeys(Jedis jedis) {

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();

        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }



}
