package org.screw.vhr.service;

import org.screw.vhr.mapper.PositionMapper;
import org.screw.vhr.model.Position;
import org.screw.vhr.model.RespBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PositionService
 * @Description 职位管理
 * @Author Emin
 * @Date 2022/9/27 15:48
 * @Version 1.0
 **/

@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
