package org.screw.vhr.controller.system.basic;

import org.screw.vhr.model.Position;
import org.screw.vhr.model.RespBean;
import org.screw.vhr.service.PositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PositionController
 * @Description TODO
 * @Author Emin
 * @Date 2022/9/27 15:42
 * @Version 1.0
 **/

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Resource
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
         return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败");
    }
}
