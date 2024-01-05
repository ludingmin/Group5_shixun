package com.group5.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_manger_role")
public class ManagerRole {
    @TableId
    private String fRole;
    private Integer f_number;
    private Integer f_privilege;
    private Integer f_type;
}
