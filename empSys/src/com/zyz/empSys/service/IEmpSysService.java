package com.zyz.empSys.service;
/**
 *Emp对象的服务接口
 */

import java.util.List;

import com.zyz.empSys.domain.Emp;

public interface IEmpSysService {
	/**
	 * 登录验证，通过名称和密码来查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassworld(String name,String password);

	List<Emp> findEmpAll();

	Emp findempByid(Integer id);

	void updateEmpp(Emp emp);

	Emp deleteEmpbyid(Integer id);

	List<Emp> findEmpEditAll();

	void returnEditbyid(int id);

	void deleteemp2byid(int id);

	List<Emp> findEmpEditAll2();

	void insertregiter(Emp emp);

	//void deleteEmpbyid(int parseInt);




}
