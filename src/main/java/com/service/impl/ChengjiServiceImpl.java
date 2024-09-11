package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChengjiDao;
import com.entity.ChengjiEntity;
import com.service.ChengjiService;
import com.entity.view.ChengjiView;

/**
 * 成绩 服务实现类
 * @author 
 * @since 2021-03-23
 */
@Service("chengjiService")
@Transactional
public class ChengjiServiceImpl extends ServiceImpl<ChengjiDao, ChengjiEntity> implements ChengjiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChengjiView> page =new Query<ChengjiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}