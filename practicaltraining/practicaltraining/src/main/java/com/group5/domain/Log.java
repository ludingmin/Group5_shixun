package com.group5.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_log")
public class Log {
    @TableId
    private  Long fLogId;
    private  Long fUname;
    private  Integer fAtype;
    private String fIp;
    private Date fAtime;
    private String fDesc;
}
