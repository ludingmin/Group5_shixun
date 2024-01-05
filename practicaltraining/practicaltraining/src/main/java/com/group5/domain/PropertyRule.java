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
@TableName("t_properthy_rule")
public class PropertyRule {
    @TableId
    private Integer fPid;
    private Integer fLcode;
    private Integer fProperty;
    private Integer fPtype;
    private Integer fJudge;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fPvalue;

}
