package com.group5.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group5.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
