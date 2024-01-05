package com.group5.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group5.domain.User;

import java.sql.Date;

public interface UserService extends IService<User> {

    //新增用户
    public Integer active(Date date);

    //日活跃老用户
    public Integer olduser(Date date);

    //累计活跃的用户数
    public Integer accrued(Date date);

//    七天累计活跃用户
    public Integer seven(Date date1,Date date2);

    //月活跃用户
    public Integer month(Date date1,Date date2);


    //日小时新增用户
    public int[] hour(Date date);

    //日小时老用户活动数
    public int[] old(Date date);

    //累计活跃日用户数
    public int[] accrued1(Date date);

    //七日累计新增用户数
    public Integer seven1(Date date1,Date date2);

    //月累计新增的用户数
    public  Integer moth1(Date date1,Date datet2);

    //30日活跃用户

}
