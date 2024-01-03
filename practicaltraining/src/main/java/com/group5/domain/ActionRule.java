package com.group5.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_action_rule")
public class ActionRule {

    @TableId
    private Integer fAid;
    private Integer fLcode;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date f_atime;
    private Integer fAtype;
    private Integer fValueValue;
    private Integer fAjudge;
    private Integer fValueType;

}
