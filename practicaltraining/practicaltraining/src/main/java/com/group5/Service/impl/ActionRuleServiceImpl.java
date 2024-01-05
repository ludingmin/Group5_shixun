package com.group5.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group5.Mapper.ActionRuleMapper;
import com.group5.Service.ActionRuleService;
import com.group5.domain.ActionRule;
import org.springframework.stereotype.Service;

@Service
public class ActionRuleServiceImpl extends ServiceImpl<ActionRuleMapper, ActionRule> implements ActionRuleService {
}
