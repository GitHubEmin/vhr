package org.screw.vhr.controller.system.basic;

import org.screw.vhr.model.JobLevel;
import org.screw.vhr.model.RespBean;
import org.screw.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Resource
    JobLevelService jobLevelService;

    @GetMapping("/")
     public List<JobLevel> getAllJobLevels(){
         return jobLevelService.getAllJobLevels();
     }

     @PostMapping("/")
     public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
     }

     @PutMapping("/")
     public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel){
       if (jobLevelService.updateJobLevelById(jobLevel)==1){
         return RespBean.ok("更新成功");
       }
       return RespBean.error("更新失败");
     }

     @DeleteMapping("/{id}")
     public RespBean deleteJobLevelById(@PathVariable Integer id){
       if (jobLevelService.deleteJobLevelById(id)==1){
         return RespBean.ok("删除成功");
       }
       return RespBean.error("删除失败");
     }

  @DeleteMapping("/")
  public RespBean deletePositionsByIds(Integer[] ids) {
    if (jobLevelService.deletePositionByIds(ids) == ids.length) {
      return RespBean.ok("批量删除成功");
    }
    return RespBean.error("批量删除失败");
  }
}
