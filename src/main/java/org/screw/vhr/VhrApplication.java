package org.screw.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.screw.vhr.mapper")
public class VhrApplication {

  public static void main(String[] args) {
    SpringApplication.run(VhrApplication.class, args);
  }

}
