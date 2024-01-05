package com.group5.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group5.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

@Mapper
public interface LogMapper  extends BaseMapper<Log> {
    @Select("select count(distinct l.f_uname) from t_log as l,t_user as u where l.f_atime > #{today} and  l.f_atime < #{tom}" +
            " and l.f_uname = u.f_usercode  and u.f_createtime > #{line}  ")
    public Integer selectCountActNewUser(@Param("today") LocalDate today, @Param("tom")LocalDate tom, @Param("line")LocalDate line) ;

}
