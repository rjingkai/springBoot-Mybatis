package com.example.controller.contr;

import com.example.model.User;
import com.example.service.UserService;
import com.example.util.Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Util util1;


    @ResponseBody
    @RequestMapping(value = "/add")
    public int addUser(User user){
        return userService.addUser(user);
    }


    @RequestMapping(value = "/getAll")
    public String getAll(int pageNum, int pageSize){
        List<User> list = userService.getAll(pageNum,pageSize);
//        map.put("list",list);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/server")
    public String getServer(){
        return util1.getPort();
    }

    @RequestMapping(value = "/getAll1")
    @ResponseBody
    public String getAll1(){
        List<User> list = userService.getAll(1,2);
        int count = userService.count();
        JSONArray json = new JSONArray();
        //将集合变为json
        for (User u: list) {
            JSONObject jo = new JSONObject();
            jo.put("userId",u.getUserid());
            jo.put("userName",u.getUsername());
            jo.put("password",u.getPassword());
            jo.put("phone",u.getPassword());
            json.put(jo);
        }
        //将数据准备好layUI的格式
        JSONObject jobj = new JSONObject();
        jobj.put("code",0);
        jobj.put("msg","");
        jobj.put("count",count);
        jobj.put("data",json);
        System.out.println(jobj.toString());
        return jobj.toString();
    }

}
