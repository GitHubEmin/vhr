package org.screw.vhr.controller.config;

import java.util.List;
import org.screw.vhr.model.Menu;
import org.screw.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Emin
 * @date 2022/9/22 19:03
 */
@RestController
@RequestMapping("/system/config")
public class   SystemConfigController {

  @Resource
  MenuService menuService;

  @GetMapping("/menu")
  public List<Menu> getMenuByHrId() {
    return menuService.getMenuByHrId();
  }
}
