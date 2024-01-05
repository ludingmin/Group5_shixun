package com.group5.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group5.domain.Order;

import java.sql.Date;

public interface OrderService extends IService<Order> {
    //订单数量
    public Integer number(Date date);

    //下单人数
    public Integer people(Date date);

    //取消订单数
    public Integer Cancel(Date date);

    //取消订单的用户数
    public Integer canuser(Date date);

    //退货次数
    public Integer refund(Date date);

    //退货用户数
    public Integer goods(Date date);

    //交易总金额
    
}
