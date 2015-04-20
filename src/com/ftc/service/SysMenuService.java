package com.ftc.service;

import java.util.List;

import com.ftc.vo.SysMenuVO;
import com.ftc.vo.User;


public interface SysMenuService {
	
	public List<SysMenuVO> selectAssessSysMenu(String userCde) throws Exception;
    
    public List<User> checkLogin(User user) throws Exception; 
	
	public User toView(String empCde) throws Exception;
	
	public int doUpdate(User vo) throws Exception;
}
