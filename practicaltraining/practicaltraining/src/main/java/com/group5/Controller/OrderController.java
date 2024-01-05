package com.group5.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group5.Service.impl.OrderServiceImpl;
import com.group5.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping("/total")
    //交易总金额
    public double total(){
        //总收益
        Order order = new Order();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        //获取当前日期
        Date time = new java.sql.Date(new java.util.Date().getTime());
        //条件求和
        queryWrapper.select("sum(f_oprice) as totalScore")
                .eq("f_ostate",2)
                .like("f_otime",time);
        Order ord = orderService.getOne(queryWrapper);
        //注意，空指针问题
        if (ord== null){
            order.setTotalScore(Integer.valueOf(0)); ;
        }else{
            order.setTotalScore(ord.getTotalScore());
        }
        double totalScore = order.getTotalScore();
        return totalScore;
    }

    @GetMapping("/number ")
    //总订单数
    public  Integer number(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer number = orderService.number(time);
        return number;
    }


    @GetMapping("/people ")
    //下单人数
    public Integer people(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer people = orderService.people(time);
        return people;
    }


    //客单量(即商场或超市平均每个客户购买货品的数量)
    @GetMapping("/volume")
    public double volume(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        //获取总订单数
        Integer number = orderService.number(time);

        //获取下单人数
        Integer people = orderService.people(time);

        double i=(double)(number/people);
        return i;
    }


    @GetMapping("/Cancel")
    //取消订单数
    public  Integer Cancel(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer cancel = orderService.Cancel(time);
        return cancel;
    }

    //取消订单的用户数
    @GetMapping("/canuser")
    public Integer canuser(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer canuser = orderService.canuser(time);
        return canuser;
    }

    //退货次数
    @GetMapping("/refund")
    public Integer refund(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer refund = orderService.refund(time);
        return refund;
    }

    //退货用户数
    @GetMapping("/goods")
    public Integer goods(){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        Integer goods = orderService.goods(time);
        return goods;
    }

}
