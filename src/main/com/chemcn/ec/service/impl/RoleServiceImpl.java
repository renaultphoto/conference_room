package main.com.chemcn.ec.service.impl;

import main.com.chemcn.ec.dao.RoleMapper;
import main.com.chemcn.ec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String findNameById(Integer roleId) throws Exception {
        return roleMapper.findNameById(roleId);
    }
}
