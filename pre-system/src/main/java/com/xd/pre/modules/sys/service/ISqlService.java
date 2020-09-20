package com.xd.pre.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.pre.modules.sys.domain.SysDept;
import com.xd.pre.modules.sys.dto.SqlDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface ISqlService{



    public List<Map<String,Object>> SqlQuery(String sql);

    public int insertsql(String sql);


}
