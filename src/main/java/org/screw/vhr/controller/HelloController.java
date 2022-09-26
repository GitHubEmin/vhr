package org.screw.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Emin
 * @date 2022/9/21 15:16
 */

@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

  @GetMapping("/employee/basic/hello")
  public String hello2(){
    return "/employee/basic/hello";
  }

  @GetMapping("/employee/advanced/hello")
  public String hello3(){
    return "/employee/advanced/hello";
  }
}
