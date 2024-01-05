package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.LogMapper;
import com.group5.Service.LogService;
import com.group5.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
}
