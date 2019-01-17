package com.zyz.empSys.dao;

import java.util.List;

import com.zyz.empSys.domain.Emp;

/**
 *Dao接口
 */
public interface IEmpDao {
		
	/**
	 * 通过名字和密码来查找
	 */
	Emp findEmpByNameAndPassworld(String name, String password);
	/**
	 * 查找整张Emp表
	 */
	List<Emp> findEmpAll();
	/**
	 * 通过ID来查找EMP表
	 * @param id
	 * @return
	 */
	Emp findempByid(Integer id);
	/**
	 * 数据回显操作及修改
	 * @param emp
	 */
	void updateEmpp(Emp emp);
//	void deleteEmpbyid(int parseInt);
	/**
	 * 通过id来删除emp的行
	 * @param id
	 * @return
	 */
	Emp deleteEmpbyid(Integer id);
	/**
	 * 查询emp表所删除的数据
	 * @return
	 */
	List<Emp> findEmpEditAll();
	/**
	 * 通过ID来获取每一条被删除的数据
	 * @param id
	 */
	void retuenEditbyid(int id);
	/**
	 * 通过id来删除emp2表中的数据
	 * @param id
	 */
	void deleteemp2byid(int id);
	/**
	 * 查找emp2表中的数据
	 * @return
	 */
	List<Emp> findEmpAll2();
	/**
	 * 注册
	 * @param emp
	 */
	void insertregister(Emp emp);

	
}
