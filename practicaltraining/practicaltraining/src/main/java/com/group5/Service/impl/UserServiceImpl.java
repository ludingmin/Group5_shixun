package com.group5.Service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.LogMapper;
import com.group5.Mapper.UserMapper;
import com.group5.Service.UserService;
import com.group5.VO.Result;
import com.group5.domain.Log;
import com.group5.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;


    //新增用户
    @Override
    public Integer active(Date date) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.like("f_createtime",date);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //活跃的老用户
    @Override
    public Integer olduser(Date date) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        //创建时间小于当前日期并且登陆时间等于当前日期
        uqw.lt("f_createtime",date).like("f_updatetime",date);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //累计活跃的用户数
    @Override
    public Integer accrued(Date date) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.like("f_updatetime",date);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //七日活跃用户
    @Override
    public Integer seven(Date date1, Date date2) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.between("f_updatetime",date1,date2);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //月活跃用户
    @Override
    public Integer month(Date date1, Date date2) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.between("f_updatetime",date1, date2);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //日小时新增
    @Override
    public int[] hour(Date date) {
        int[] n =new int[7];
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.like("f_createtime",date);
        List<User> users = userMapper.selectList(uqw);

        //
        SimpleDateFormat hh = new SimpleDateFormat("HH");
//        int format = Integer.parseInt(hh.format(aTime));


        for(int i = 0; i < users.size(); i++) {
            Timestamp fCreatetime = users.get(i).getFCreatetime();
            int format = Integer.parseInt(hh.format(fCreatetime));
            //判断
            if (format>=8&&format<10){
                n[0]++;
            } else if (format>=10&&format<12) {
                n[1]++;
            }
            else if (format>=12&&format<14){
                n[2]++;
            } else if (format>=14&&format<16) {
                n[3]++;
            } else if (format>=16&&format<18) {
                n[4]++;
            }else if (format>=18&&format<20){
                n[5]++;
            }
            else {
                n[6]++;
            }
        }
            return n;
    }


    //老用户小时活跃数
    @Override
    public int[] old(Date date) {
        int[] n =new int[7];
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.lt("f_createtime", date).eq("f_updatetime", date);
        List<User> users = userMapper.selectList(uqw);

        SimpleDateFormat hh = new SimpleDateFormat("HH");

        for(int i = 0; i < users.size(); i++) {
            Timestamp fCreatetime = users.get(i).getFCreatetime();
            int format = Integer.parseInt(hh.format(fCreatetime));
            //判断
            if (format>=8&&format<10){
                n[0]++;
            } else if (format>=10&&format<12) {
                n[1]++;
            }
            else if (format>=12&&format<14){
                n[2]++;
            } else if (format>=14&&format<16) {
                n[3]++;
            } else if (format>=16&&format<18) {
                n[4]++;
            }else if (format>=18&&format<20){
                n[5]++;
            }
            else {
                n[6]++;
            }
        }
        return n;
    }


    //累计日小时活跃用户数
    @Override
    public int[] accrued1(Date date) {
        int[] n=new int[7];
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.like("f_updatetime",date);
        List<User> users = userMapper.selectList(uqw);
    //设置日期格式
        SimpleDateFormat hh = new SimpleDateFormat("HH");
        for(int i = 0; i < users.size(); i++) {
            Timestamp fCreatetime = users.get(i).getFCreatetime();
            int format = Integer.parseInt(hh.format(fCreatetime));
            //判断
            if (format>=8&&format<10){
                n[0]++;
            } else if (format>=10&&format<12) {
                n[1]++;
            }
            else if (format>=12&&format<14){
                n[2]++;
            } else if (format>=14&&format<16) {
                n[3]++;
            } else if (format>=16&&format<18) {
                n[4]++;
            }else if (format>=18&&format<20){
                n[5]++;
            }
            else {
                n[6]++;
            }
        }
        return n;

    }

    @Override
    public Integer seven1(Date date1 ,Date date2) {
        QueryWrapper<User> uqw = new QueryWrapper<>();
        uqw.between("f_createtime",date1,date2);
        Integer count = userMapper.selectCount(uqw);
        return count;
    }


    //月累计新增用户数
    @Override
    public Integer moth1(Date date1, Date datet2) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.between("f_createtime",date1,datet2);
        Integer count = userMapper.selectCount(userQueryWrapper);
        return count;
    }




    //查询这个月的活跃用户
    public Result getActUserByMonth(){
        //获得日期
        //获取今天
        LocalDate today = LocalDate.now();
        //获取这个月第一天
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth()); // 获取当前月的第一天
        LocalDate day = firstDay;
       //图表的x坐标（日期）
        ArrayList<String> x = new ArrayList<>();
        //y坐标次数
        ArrayList<Integer> y = new ArrayList<>();
        //从本月第一天循环到最后一天
        while (day.isBefore(today) || day.isEqual(today)){
            QueryWrapper<Log> logQueryWrapper = new QueryWrapper<>();
            //查询出本月的登录记录
            logQueryWrapper.select("DISTINCT f_uname").
                    eq("f_atype",1).between("f_atime",day,day.minusDays(-1)).orderByDesc("f_atime");
            Integer count = logMapper.selectCount(logQueryWrapper);
            x.add(day.toString());
            y.add(count);
            //切换下一天
            day = day.minusDays(-1);
            System.out.println(x);
            System.out.println(y);
        }
        return Result.ok(null);
    }

    public Result getActNewUserByMonth(){
        //获得日期
        //获取今天
        LocalDate today = LocalDate.now();
        //获取这个月第一天
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth()); // 获取当前月的第一天
        LocalDate day = firstDay;
        //图表的x坐标（日期）
        ArrayList<String> x = new ArrayList<>();
        //y坐标次数
        ArrayList<Integer> y = new ArrayList<>();
        //从本月第一天循环到最后一天
        while (day.isBefore(today) || day.isEqual(today)){
            Integer count = logMapper.selectCountActNewUser(day,day.minusDays(-1),day.minusDays(7));
            x.add(day.toString());
            y.add(count);
            //切换下一天
            day = day.minusDays(-1);
            System.out.println(x);
            System.out.println(y);
        }
        return Result.ok(null);
    }


}
