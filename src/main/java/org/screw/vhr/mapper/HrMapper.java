package org.screw.vhr.mapper;

import org.screw.vhr.model.Hr;
import org.screw.vhr.model.Role;

import java.util.List;

public interface HrMapper {

    Hr loadUserByUsername(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    List<Role> getHrRolesById(Integer id);
}