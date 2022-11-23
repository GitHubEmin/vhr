package org.screw.vhr.service;

import java.util.List;
import javax.annotation.Resource;
import org.screw.vhr.mapper.RoleMapper;
import org.screw.vhr.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Resource
  RoleMapper roleMapper;

  public List<Role> getAllRoles() {
    return roleMapper.getAllRoles();
  }

  public Integer addRole(Role role) {
    if (!role.getName().startsWith("ROlE_")) {
      role.setName("ROlE_"+ role.getName());
    }
    return roleMapper.insert(role);
  }

  public Integer deleteRoleById(Integer rid) {
    return roleMapper.deleteByPrimaryKey(rid);
  }
}
