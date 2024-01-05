package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.PropertyRuleMapper;
import com.group5.Service.PropertyRuleService;
import com.group5.domain.PropertyRule;
import org.springframework.stereotype.Service;

@Service
public class PropertyRuleServiceImpl extends ServiceImpl<PropertyRuleMapper, PropertyRule> implements PropertyRuleService {
}
