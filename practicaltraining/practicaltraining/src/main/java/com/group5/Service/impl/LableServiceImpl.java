package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.LableMapper;
import com.group5.Service.LableService;
import com.group5.domain.Lable;
import org.springframework.stereotype.Service;


@Service
public class LableServiceImpl extends ServiceImpl<LableMapper, Lable> implements LableService {
}
