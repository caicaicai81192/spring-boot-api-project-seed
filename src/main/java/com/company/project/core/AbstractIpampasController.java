package com.company.project.core;


import com.ipampas.panshi.system.dto.UserDto;
import com.ipampas.panshi.system.service.UserService;
import com.ipampas.panshi.ucenter.user.TenantUserContext;

import javax.annotation.Resource;

/**
 * @author caizj
 * @description: Controller层公共方法
 * @date 2019/7/1 10:23 AM
 * @since 1.0.0
 */
public abstract class AbstractIpampasController {

    @Resource
    private UserService userService;

    /**
     * 根据guid获取机构用户
     *
     * @return
     */
    protected UserDto getUserByGuid() {
        //
        return userService.findByGuid(TenantUserContext.get().getUserGuid());
    }


}
