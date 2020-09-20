package com.xd.pre.modules.sys.service.impl;

import com.xd.pre.modules.sys.dto.SqlDTO;
import com.xd.pre.modules.sys.service.ISqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SqlserviceImpl implements ISqlService{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> SqlQuery(String sql) {
        List<Map<String,Object>> list= jdbcTemplate.queryForList(sql);;
        return  list;
    }

    @Override
    public int insertsql(String sql){
        jdbcTemplate.execute(sql);
        return 1;
    }

}
