package org.screw.vhr.service;

import java.util.List;
import org.screw.vhr.mapper.MenuMapper;
import org.screw.vhr.mapper.MenuRoleMapper;
import org.screw.vhr.model.Hr;
import org.screw.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Emin
 * @Date 2022/9/22 19:05
 */
@Service
public class MenuService {
  @Resource
  MenuMapper menuMapper;
  @Resource
  MenuRoleMapper menuRoleMapper;

  public List<Menu> getMenuByHrId() {
    return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
  }

  public List<Menu> getAllMenusWithRole(){
    return menuMapper.getAllMenusWithRole();
  }

  public List<Menu> getAllMenus() {
    return menuMapper.getAllMenus();
  }

  public List<Integer> getMidsByRid(Integer rid) {
    return menuMapper.getMidsByRid(rid);
  }

  @Transactional
  public Boolean updateMenuRole(Integer rid, Integer[] mids) {
    menuRoleMapper.deleteByRid(rid);
    Integer result = menuRoleMapper.insertRecord(rid,mids);
    return result==mids.length;
  }
}
