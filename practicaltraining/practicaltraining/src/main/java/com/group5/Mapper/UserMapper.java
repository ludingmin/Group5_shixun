package com.group5.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group5.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

@Mapper
public interface UserMapper extends BaseMapper<User> {


}
