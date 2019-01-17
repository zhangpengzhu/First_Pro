package com.zyz.empSys.service.impl;

import java.util.List;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.dao.impl.Empdao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpSysService;

public class EmpSysService implements IEmpSysService {
	IEmpDao dao=new Empdao();

	@Override
	public Emp findEmpByNameAndPassworld(String name, String password) {
		
		return dao.findEmpByNameAndPassworld(name,password);
	}

	@Override
	public List<Emp> findEmpAll() {
		return dao.findEmpAll();
		
	}

	@Override
	public Emp findempByid(Integer id) {
		return dao.findempByid(id);
	}

	@Override
	public void updateEmpp(Emp emp) {
		dao.updateEmpp(emp);
	}

	@Override
	public Emp deleteEmpbyid(Integer id) {
		return dao.deleteEmpbyid(id);
	}

	@Override
	public List<Emp> findEmpEditAll() {
		return dao.findEmpEditAll();
	}

	@Override
	public void returnEditbyid(int id) {
			dao.retuenEditbyid(id);
	}

	@Override
	public void deleteemp2byid(int id) {
			dao.deleteemp2byid(id);
	}

	@Override
	public List<Emp> findEmpEditAll2() {
		return dao.findEmpAll2();
	}

	@Override
	public void insertregiter(Emp emp) {
			dao.insertregister(emp);
	}

	/*@Override
	public void deleteEmpbyid(int parseInt) {
			dao.deleteEmpbyid(parseInt);
	}*/



	

	


	
	

}
