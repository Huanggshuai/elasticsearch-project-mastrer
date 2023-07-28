package com.es.demo.esdemo.controller;

import com.es.demo.esdemo.domain.User;
import com.es.demo.esdemo.domain.result.R;
import com.es.demo.esdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Author: huangS
 * @ClassName: UserController
 * @Description: TODO
 * @DateTime: 2023/7/28-20:37
 * @Version: 1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public R add(@RequestBody User user){
        try{
            User user1 = userService.save(user);
        }catch (Exception e){
            if (!(e.getMessage().contains("200 OK"))){
                return R.fail("新增异常");
            }
            return R.ok();
        }
        return R.ok();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public R findById(@PathVariable Integer id){
        try{
            return R.ok(userService.findById(id));
        }catch (Exception e){
            return R.fail();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public R<List<User>> find(){
        return R.ok(StreamSupport.stream(userService.findAll().spliterator(),false).collect(Collectors.toList()));
    }
}
