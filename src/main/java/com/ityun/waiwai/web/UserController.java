package com.ityun.waiwai.web;
import com.ityun.waiwai.api.impl.EasemobIMUsers;
import com.ityun.waiwai.comm.OrgInfo;
import com.ityun.waiwai.core.Result;
import com.ityun.waiwai.core.ResultGenerator;
import com.ityun.waiwai.model.User;
import com.ityun.waiwai.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.client.model.RegisterUsers;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
* Created by CodeGenerator on 2017/09/26.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    EasemobIMUsers users1=new EasemobIMUsers();
//    @PostMapping("/add")
    @GetMapping("/add")
    public Result add(User user) {
        RegisterUsers users = new RegisterUsers();
        io.swagger.client.model.User user1 = new io.swagger.client.model.User();
        user1.setUsername("17601550157");
        user1.setPassword("123456");
        users.add(user1);
        Object object=  users1.createNewIMUserSingle(users);
        logger.error(object.toString());
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }
    @RequestMapping("/login")
    public Result login(@RequestParam String name,@RequestParam String password)
    {
      User user=  userService.findBy("username",name);
      if(user==null)
      {
          return  ResultGenerator.genFailResult("用户名不对");
      }
      else
      {
         if( user.getPassword().equalsIgnoreCase(password))
             return  ResultGenerator.genSuccessResult(user);
         else
             return  ResultGenerator.genSuccessResult("密码不对");
      }

    }

//    @PostMapping("/list")
//    @GetMapping("/list")
    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {

        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
