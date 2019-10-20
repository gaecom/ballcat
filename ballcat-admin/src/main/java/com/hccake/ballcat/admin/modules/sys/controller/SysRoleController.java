package com.hccake.ballcat.admin.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hccake.ballcat.admin.modules.sys.model.entity.SysRole;
import com.hccake.ballcat.admin.modules.sys.model.vo.PermissionVO;
import com.hccake.ballcat.admin.modules.sys.service.SysPermissionService;
import com.hccake.ballcat.admin.modules.sys.service.SysRolePermissionService;
import com.hccake.ballcat.admin.modules.sys.service.SysRoleService;
import com.hccake.ballcat.commom.log.operation.annotation.OperationLogging;
import com.hccake.ballcat.common.core.result.R;
import com.hccake.ballcat.common.core.vo.SelectData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hccake
 */
@RestController
@RequestMapping("/sysrole")
@Api(value = "sysrole", tags = "角色管理模块")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 分页查询角色信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public R getRolePage(Page page) {
        return R.ok(sysRoleService.page(page, Wrappers.emptyWrapper()));
    }

    /**
     * 通过ID查询角色信息
     *
     * @param id ID
     * @return 角色信息
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return R.ok(sysRoleService.getById(id));
    }

    /**
     * 新增系统角色表
     *
     * @param sysRole 系统角色表
     * @return R
     */
    @ApiOperation(value = "新增系统角色", notes = "新增系统角色")
    @OperationLogging("新增系统角色")
    @PostMapping
    @PreAuthorize("@per.hasPermission('sys_sysrole_add')")
    public R save(@Valid @RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.save(sysRole));
    }

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return success/false
     */
    @ApiOperation(value = "修改系统角色", notes = "修改系统角色")
    @OperationLogging("修改系统角色")
    @PutMapping
    @PreAuthorize("@per.hasPermission('sys_sysrole_edit')")
    public R update(@Valid @RequestBody SysRole role) {
        return R.ok(sysRoleService.updateById(role));
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过id删除系统角色", notes = "通过id删除系统角色")
    @OperationLogging("通过id删除系统角色")
    @PreAuthorize("@per.hasPermission('sys_sysrole_del')")
    public R removeById(@PathVariable Integer id) {
        return R.ok(sysRoleService.removeRoleById(id));
    }

    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    @GetMapping("/list")
    public R listRoles() {
        return R.ok(sysRoleService.list(Wrappers.emptyWrapper()));
    }


    /**
     * 更新角色权限
     *
     * @param roleId        角色ID
     * @param permissionIds 权限ID数组
     * @return success、false
     */
    @PutMapping("/permission/ids/{roleId}")
    @ApiOperation(value = "更新角色权限", notes = "更新角色权限")
    @OperationLogging("更新角色权限")
    @PreAuthorize("@per.hasPermission('sys_sysrole_grant')")
    public R savePermissionIds(@PathVariable Integer roleId, @RequestBody Integer[] permissionIds) {
        return R.ok(sysRolePermissionService.saveRolePermissions(roleId, permissionIds));
    }


    /**
     * 返回角色的菜单集合
     *
     * @param roleId 角色ID
     * @return 属性集合
     */
    @GetMapping("/permission/ids/{roleId}")
    public R getPermissionIds(@PathVariable Integer roleId) {
        return R.ok(sysPermissionService.findPermissionVOByRoleId(roleId)
                .stream()
                .map(PermissionVO::getId)
                .collect(Collectors.toList()));
    }


    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    @GetMapping("/select")
    public R<List<SelectData>> getSelectData() {
        return R.ok(sysRoleService.getSelectData());
    }
}
