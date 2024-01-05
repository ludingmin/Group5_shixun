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
@TableName("t_manager")
public class Manager {
    @TableId("f_numbre")
    private Long fNumber;
    private String fUsercode;
    private String fPassword;
    private String fName;
    private String fRealname;
    private String fRole;
    private String fSex;
    private Integer fAge;
    private String fQq;
    private String fPhone1;
    private Integer fEmail;
    private String fState;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fUpdatetime;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fCreatetime;
    private String fMemo;
}
