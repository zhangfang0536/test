package com.wkcto.springcloud.controller;

import com.wkcto.springcloud.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //等价于@Controller+@ResponseBody，方法上就不需要加@ResponseBody
public class HelloController {

    @RequestMapping(value = "/service/hello", method = RequestMethod.GET)//默认支持get、post
    public String hello() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("服务提供者1。。。");

        //进行业务处理
        return "Hello, SpringCloud， Provider1";
    }

    @RequestMapping("/service/user")
    public User User() {
        System.out.println("服务提供者1。。。");

        User user = new User();
        user.setId(108);
        user.setName("张三");
        user.setPhone("138 XXXX XXXX");

        return user;
    }

    @RequestMapping("/service/getUser")
    public User getUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {
        System.out.println("服务提供者1。。。");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        return user;
    }

    @RequestMapping("/service/getUsers")
    public List<User> getUsers() {
        System.out.println("服务提供者1。。。");

        User user = new User();
        user.setId(1);
        user.setName("王五");
        user.setPhone("12231");

        User user1 = new User();
        user1.setId(1);
        user1.setName("李四");
        user1.setPhone("323");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user);
        list.add(user);
        list.add(user);

        return list;
    }

//    @RequestMapping(value = "/service/addUser", method = RequestMethod.POST) 一样
    @PostMapping("/service/addUser")
    public User addUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {
        System.out.println("服务提供者1。。。addUser");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        return user;
    }

    @PostMapping("/service/addAUser")
    public User addUser1(@RequestBody User user1) {
        System.out.println("服务提供者1。。。addUser");

        User user = new User();
        user.setId(user1.getId());
        user.setName(user1.getName());
        user.setPhone(user1.getPhone());

        return user;
    }

    @PostMapping(value = "/service/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        System.out.println("服务提供者1。。。addUser");
        List<User> uss = new ArrayList<>();
        for (User u : users) {
            User user = new User();
            user.setId(u.getId());
            user.setName(u.getName());
            user.setPhone(u.getPhone());
            uss.add(u);
        }

        return uss;
    }
}
