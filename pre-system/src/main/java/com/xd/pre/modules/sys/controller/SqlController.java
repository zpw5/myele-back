package com.xd.pre.modules.sys.controller;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.xd.pre.common.utils.R;
import com.xd.pre.log.annotation.SysOperaLog;
import com.xd.pre.modules.sys.dto.DeptDTO;
import com.xd.pre.modules.sys.dto.SqlDTO;
import com.xd.pre.modules.sys.service.impl.SqlserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sql")
public class SqlController {

    @Autowired
    private SqlserviceImpl sqlserviceimpl;

    @SysOperaLog(descrption = "查询Sql语句")
    @GetMapping
    @PreAuthorize("hasAuthority('sys:dept:view')")
    public R Sql(@RequestParam String sql) {
        System.out.print(sql);
        return R.ok(sqlserviceimpl.SqlQuery(sql));
    }

    @SysOperaLog(descrption = "Sql语句")
    @GetMapping("/insert")
    @PreAuthorize("hasAuthority('sys:sql:view')")
    public R insertSql(@RequestParam String sql) {
        System.out.print(sql);
        return R.ok(sqlserviceimpl.insertsql(sql));
    }
}
