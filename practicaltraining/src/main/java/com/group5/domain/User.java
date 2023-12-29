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
@TableName("t_user")
public class User {
    @TableId("f_number")
    private Long fNumber;
    private String fUsercode;
    private String fPassword;
    private String fName;
    private String fSex;
    private Integer fAge;
    private String fOrigin;
    private String fLiveaddress;
    private Integer fState;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fCreatetime;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fUpdatetime;
    @JsonFormat(pattern = "MM-dd HH:mm",timezone="GMT+8")
    private Date fLastLoginTime;
    private Integer fMemberTires;
    private String fMemo;
}
