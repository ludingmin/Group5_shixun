package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.ManagerRoleMapper;
import com.group5.Service.ManagerRoleService;
import com.group5.domain.ManagerRole;
import org.springframework.stereotype.Service;

@Service
public class ManagerRoleServiceImpl extends ServiceImpl<ManagerRoleMapper, ManagerRole> implements ManagerRoleService {
}
