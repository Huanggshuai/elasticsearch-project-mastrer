package com.es.demo.esdemo.service;

import com.es.demo.esdemo.domain.User;
import com.es.demo.esdemo.esresposity.Esresposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Author: huangS
 * @ClassName: UserService
 * @Description: TODO
 * @DateTime: 2023/7/28-20:11
 * @Version: 1.0
 **/
@Service
public class UserService {
    @Autowired
    private Esresposity esresposity;

    public User findById(Integer id){
        return esresposity.findById(id).orElse(null);

    }

    public User save(User user) {
           return esresposity.save(user);

    }

    public Iterable<User> findAll(){
        return esresposity.findAll();
    }

    public void del(Integer id){
        esresposity.deleteById(id);
    }
}
