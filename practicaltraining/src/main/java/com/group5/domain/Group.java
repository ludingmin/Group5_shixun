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
@TableName("t_group")
public class Group {

    @TableId
    private Integer fGid;
    private Integer fPnum;
    private String fGcreateMethod;
    private Long fGcreatePreson;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fGcreateTime;

}
