package com.hccake.ballcat.admin.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hccake.ballcat.admin.modules.sys.model.dto.SysUserDTO;
import com.hccake.ballcat.admin.modules.sys.model.dto.SysUserScope;
import com.hccake.ballcat.admin.modules.sys.model.entity.SysUser;
import com.hccake.ballcat.admin.modules.sys.model.qo.SysUserQO;
import com.hccake.ballcat.admin.modules.sys.model.vo.UserInfo;

import java.util.List;

/**
 * 系统用户表
 *
 * @author ballcat code generator
 * @date 2019-09-12 20:39:31
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询系统用户列表
     * @param page 分页对象
     * @param qo 查询参数
     * @return
     */
    IPage<SysUser> getUserPage(IPage<SysUser> page, SysUserQO qo);


    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser getByUsername(String username);

    /**
     * 获取用户详情信息
     * @param user
     * @return
     */
    UserInfo findUserInfo(SysUser user);


    /**
     * 新增系统用户
     * @param sysUserDto
     * @return
     */
    boolean addSysUser(SysUserDTO sysUserDto);


    /**
     * 更新系统用户信息
     * @param sysUserDTO
     * @return
     */
    boolean updateSysUser(SysUserDTO sysUserDTO);


    /**
     * 更新用户权限信息
     *
     * @param userId
     * @param sysUserScope
     * @return
     */
    boolean updateUserScope(Integer userId, SysUserScope sysUserScope);


    /**
     * 根据userId删除 用户
     * @param userId
     * @return
     */
    boolean deleteByUserId(Integer userId);


    /**
     * 修改用户密码
     * @param userId
     * @param pass
     * @return
     */
    boolean updateUserPass(Integer userId, String pass);

    /**
     * 批量修改用户状态
     * @param userIds
     * @param status
     * @return
     */
    boolean updateUserStatus(List<Integer> userIds, Integer status);
}
