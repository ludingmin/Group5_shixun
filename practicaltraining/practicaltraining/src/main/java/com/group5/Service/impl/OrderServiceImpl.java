package com.group5.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.OrderMapper;
import com.group5.Service.OrderService;
import com.group5.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    //总订单数
    @Override
    public Integer number(Date date) {
        QueryWrapper<Order> quw = new QueryWrapper<>();
        quw.like("f_otime",date);
        Integer count = orderMapper.selectCount(quw);
        return count;
    }


    //下单人数(没测试)
    @Override
    public Integer people(Date date) {
        QueryWrapper<Order> uqw = new QueryWrapper<>();
        uqw.select("count(*)")
                .like("f_otime",date)
                .groupBy("f_number");
        List<Map<String, Object>> maps = orderMapper.selectMaps(uqw);
        int size = maps.size();
        return size;
    }


    //取消订单数
    @Override
    public Integer Cancel(Date date) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.like("f_otime",date).eq("f_ostate",-1);
        Integer count = orderMapper.selectCount(orderQueryWrapper);
        return count;
    }


    //取消订单的用户数(不知道对不对)
    @Override
    public Integer canuser(Date date) {
        QueryWrapper<Order> uqw = new QueryWrapper<>();
        uqw.select("count(*)")
                .like("f_otime",date)
                .eq("f_ostate",-1)
                .groupBy("f_number");
        List<Map<String, Object>> maps = orderMapper.selectMaps(uqw);
        int size = maps.size();
        return size;
    }

    //退货次数
    @Override
    public Integer refund(Date date) {
        QueryWrapper<Order> uqw = new QueryWrapper<>();
        uqw.like("f_otime",date).eq("f_ostate",-2);
        Integer count = orderMapper.selectCount(uqw);
        return count;
    }


    //取消订单用户数
    @Override
    public Integer goods(Date date) {
        QueryWrapper<Order> uqw = new QueryWrapper<>();
        uqw.select("count(*)")
                .like("f_otime",date)
                .eq("f_ostate",-2)
                .groupBy("f_number");
        List<Map<String, Object>> maps = orderMapper.selectMaps(uqw);
        int size = maps.size();
        return size;
    }

}
