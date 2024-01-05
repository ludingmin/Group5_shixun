package com.group5.Controller;

import com.group5.Service.impl.UserServiceImpl;
import com.group5.VO.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;

@RestController
@RequestMapping("/user")
public class UserContorller {
    @Autowired
    private UserServiceImpl userService;

//    新增用户数
    @GetMapping("/active")
    public  Integer active(){
//        获取当前日期
        Date time = new java.sql.Date(new java.util.Date().getTime());
//        调用方法
        int active = userService.active(time);
        return active;
    }




//    今日老用户活跃数量
    @GetMapping("/olduser")
    public Integer olduser(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        int olduser = userService.olduser(time);
        return olduser;
    }

    //日活跃的用户数
    @GetMapping("/accrued")
    public Integer accrued(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer accrued = userService.accrued(time);
        return accrued;
    }


    //七日活跃用户数
    @GetMapping("/Seven")
    public Integer seven(){
        //获取当前日期
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(time);
    //        七天前日期
        c.add(Calendar.DATE,-7);
        java.util.Date time1 = c.getTime();
        Date time2 = new java.sql.Date(time1.getTime());
        //调用方法
        Integer seven = userService.seven(time2, time);
        return seven;
    }

    //月活跃用户
    @GetMapping("/month")
    public Integer month(){
        //获取当前日期
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        //        七天前日期
        c.add(Calendar.MONTH,-7);
        java.util.Date time1 = c.getTime();
        Date time2 = new java.sql.Date(time1.getTime());
        Integer month = userService.month(time2, time);
        return month;
    }



    @GetMapping("/hour")
    //每日小时新增的用户
    public int[] hour(){
        //获取当前日期
        Date time = new java.sql.Date(new java.util.Date().getTime());
        int[] hour = userService.hour(time);
        return hour;
    }


    @GetMapping("/old")
    //今日每小时老用户活跃数
    public int[] old(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        int[] old = userService.old(time);
        return old;
    }


    //今日累计活跃用户数
    @GetMapping("/accrued1")
    public int[] accrued1(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        int[] ints = userService.accrued1(time);
        return ints;
    }

    //七日累计新增用户数
    @GetMapping("/seven1")
    public Integer seven1(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        //        七天前日期
        c.add(Calendar.DATE,-7);
        java.util.Date time1 = c.getTime();
        Date time2 = new java.sql.Date(time1.getTime());

        Integer integer = userService.seven1(time2, time);
        return integer;

    }

    //月新增用户数
    @GetMapping("/moth1")
    public Integer moth1(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        //       一个月前
        c.add(Calendar.MONTH,-1);
        java.util.Date time1 = c.getTime();
        Date time2 = new java.sql.Date(time1.getTime());
        Integer integer = userService.moth1(time2, time);
        return integer;
    }


  //  30日活动用户趋势
    @GetMapping("/moth2")
    public Result moth2(){
         return userService.getActUserByMonth();
    }

    @GetMapping("/newactive")
    public Result newActiveUser(){
        return userService.getActNewUserByMonth();
    }





}
