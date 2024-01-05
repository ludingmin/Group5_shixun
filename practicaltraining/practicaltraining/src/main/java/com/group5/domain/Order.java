package com.group5.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("t_order")
public class Order {
    @TableId
    private Long fOid;
    private Float fOprice;
    private Integer fOstate;
    private Integer fOaction;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fOtime;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fOfinishTime;
    @TableField(exist = false)
    private double totalScore;


}
