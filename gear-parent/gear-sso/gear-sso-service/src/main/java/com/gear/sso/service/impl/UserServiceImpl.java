package com.gear.sso.service.impl;

import com.gear.common.pojo.GearResult;
import com.gear.common.utils.JsonUtils;
import com.gear.mapper.TbUserMapper;
import com.gear.pojo.TbUser;
import com.gear.pojo.TbUserExample;
import com.gear.pojo.TbUserExample.Criteria;
import com.gear.sso.jedis.JedisClient;
import com.gear.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * 用户模块Service
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${USER_SESSION}")
    private String USER_SESSION;//redis中key的前缀
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;//session的过期时间

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return GearResult
     */
    @Override
    public GearResult login(String username, String password,boolean isRemember) {
        //1.判断用户名密码是否正确
        //检查用户名是否正确
        TbUserExample userExample = new TbUserExample();
        Criteria userExampleCriteria = userExample.createCriteria();
        //设置用户名相等条件
        userExampleCriteria.andUsernameEqualTo(username);
        //进行用户名查询，返回查询结果集合
        List<TbUser> list = userMapper.selectByExample(userExample);
        //如果没有查询到用户
        if (list.size() == 0 || list == null){
            //返回登陆失败
            return GearResult.build(400,"用户名或密码不正确");
        }

        //查询到了用户，进行密码验证查询
        TbUser user = list.get(0);
        //如果密码不匹配
        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            //返回登陆失败
            return GearResult.build(400,"用户名或密码不正确");
        }

        //2.校验成功，判断是否需要写入redis
        //判断是否需要记住用户名
        //记住用户名
        String token = UUID.randomUUID().toString();
        //把用户信息保存到redis，key就是token，value就是用户信息，注入jedisClient
        //能走到这一步，说明账号和密码都通过了，为了安全，将密码给清楚掉
        user.setPassword(null);
        //设置redis的key和value
        jedisClient.set(USER_SESSION + ":" + token, JsonUtils.objectToJson(user));
        //设置过期时间
        if (isRemember){
            jedisClient.expire(USER_SESSION + ":" + token, SESSION_EXPIRE);
        }else{
            jedisClient.expire(USER_SESSION + ":" + token, 30);
        }
        //3.返回登陆成功
        return GearResult.ok(token);
    }

    /**
     * 通过token查询用户
     * @param token sessionID
     * @return
     */
    @Override
    public GearResult getUserByToken(String token) {
        //1.根据token查询redis
        String userJson = jedisClient.get(USER_SESSION + ":" + token);
        if (StringUtils.isBlank(userJson)){
            //没有查询到用户
            return GearResult.build(400,"用户登陆已经过期，请重新登录");
        }
        //查询到了用户，将json转换为user对象
        TbUser user = JsonUtils.jsonToPojo(userJson, TbUser.class);
        //重新设置用户SessionID的过期时间
        //jedisClient.expire(USER_SESSION+":"+token,SESSION_EXPIRE);
        //将用户信息返回
        return GearResult.ok(user);
    }
}
