package com.group5.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group5.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper  extends BaseMapper<Order> {
}
