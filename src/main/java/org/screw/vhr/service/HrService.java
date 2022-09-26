package org.screw.vhr.service;

import javax.annotation.Resource;
import org.screw.vhr.mapper.HrMapper;
import org.screw.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Emin
 * @date 2022/9/21 14:49
 */

@Service
public class HrService implements UserDetailsService {
  @Resource
  HrMapper hrMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Hr hr = hrMapper.loadUserByUsername(username);
    if (hr ==null){
      throw new UsernameNotFoundException("用户不存在");
    }
    hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
    return hr;
  }
}
