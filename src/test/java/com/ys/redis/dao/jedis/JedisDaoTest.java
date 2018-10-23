package com.ys.redis.dao.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author HD
 * @date 2018/10/23 16:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisDaoTest {

    @Autowired
    private JedisDao jedisDao;

    @Test
    public void connectRedis() {
        jedisDao.connectRedis();
    }

    @Test
    public void insertStr() {
        jedisDao.insertStr(jedisDao.connectRedis());
    }

    @Test
    public void insertList() {
        jedisDao.insertList(jedisDao.connectRedis());
    }

    @Test
    public void findAllKeys() {
        jedisDao.findAllKeys(jedisDao.connectRedis());
    }
}