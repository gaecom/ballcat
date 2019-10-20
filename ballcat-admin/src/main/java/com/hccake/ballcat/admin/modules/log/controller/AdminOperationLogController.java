package com.hccake.ballcat.admin.modules.log.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hccake.ballcat.admin.modules.log.model.entity.AdminOperationLog;
import com.hccake.ballcat.admin.modules.log.service.OperationLogAdminService;
import com.hccake.ballcat.common.core.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 操作日志
 *
 * @author hccake
 * @date 2019-10-15 20:42:32
 */
@RestController
@AllArgsConstructor
@RequestMapping("/log/adminoperationlog")
@Api(value = "adminoperationlog", tags = "操作日志管理")
public class AdminOperationLogController {

    private final OperationLogAdminService operationLogAdminService;

    /**
     * 分页查询
     *
     * @param page              分页对象
     * @param adminOperationLog 操作日志
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R<IPage<AdminOperationLog>> getOperationLogAdminPage(
            Page<AdminOperationLog> page, AdminOperationLog adminOperationLog) {
        return R.ok(operationLogAdminService.page(page, Wrappers.query(adminOperationLog)));
    }


    /**
     * 通过id查询操作日志
     *
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R<AdminOperationLog> getById(@PathVariable("id") Long id) {
        return R.ok(operationLogAdminService.getById(id));
    }

}
