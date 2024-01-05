package com.group5.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_lable")
public class Lable {

    @TableId
    private Integer fLid;
    private String fLname;
    private Integer fType;
    private String fShowLname;
    private String fLvalue;
    private String fRemark;


}
