package org.screw.vhr.controller.system.basic;

import java.util.List;
import javax.annotation.Resource;
import org.screw.vhr.model.Menu;
import org.screw.vhr.model.RespBean;
import org.screw.vhr.model.Role;
import org.screw.vhr.service.MenuService;
import org.screw.vhr.service.RoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
  @Resource
  RoleService roleService;

  @Resource
  MenuService menuService;

  @GetMapping("/")
  public List<Role> getAllRoles(){
    return roleService.getAllRoles();
  }

  @GetMapping("/menus")
  public List<Menu> getAllMenus(){
    return menuService.getAllMenus();
  }

  @GetMapping("/mids/{rid}")
  public List<Integer> getMidsByRid(@PathVariable Integer rid){
    return menuService.getMidsByRid(rid);
  }

  @PutMapping("/")
  public RespBean updateMenuRole(Integer rid,Integer[] mids){
    if (Boolean.TRUE.equals(menuService.updateMenuRole(rid,mids))){
      return RespBean.ok("更新成功");
    }
      return RespBean.ok("更新失败");
  }

  @PostMapping("/role")
  public RespBean addRole(@RequestBody Role role){
    if(roleService.addRole(role)==1){
      return RespBean.ok("添加成功");
    }
    return RespBean.error("添加失败");
  }

  @DeleteMapping("/role/{rid}")
  public RespBean deleteRoleById(@PathVariable Integer rid){
    if (roleService.deleteRoleById(rid)==1){
      return RespBean.ok("删除成功");
    }
    return RespBean.error("删除失败");
  }
}
