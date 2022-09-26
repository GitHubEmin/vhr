package org.screw.vhr.service;

import java.util.List;
import org.screw.vhr.mapper.MenuMapper;
import org.screw.vhr.model.Hr;
import org.screw.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Emin
 * @date 2022/9/22 19:05
 */
@Service
public class MenuService {
  @Resource
  MenuMapper menuMapper;

  public List<Menu> getMenuByHrId() {
    return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
  }

  public List<Menu> getAllMenusWithRole(){
    return menuMapper.getAllMenusWithRole();
  }
}
