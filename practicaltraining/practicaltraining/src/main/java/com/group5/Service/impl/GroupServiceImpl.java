package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.GroupMapper;
import com.group5.Service.GroupService;
import com.group5.domain.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
}
