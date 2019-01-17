package com.zyz.empSys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.utils.MyDBUtils;

public class Empdao implements IEmpDao {

	@Override
	public Emp findEmpByNameAndPassworld(String name, String password) {
		//获取数据
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());

		try {
			//new BeanHandler<Emp>(Emp.class), name,password)
			return runner.query("select * from emp where name=? and password=?",new BeanHandler<Emp>(Emp.class),name,password) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Emp> findEmpAll() {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
		return	runner.query("select * from Emp", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Emp findempByid(Integer id) {
	QueryRunner runner = new	QueryRunner(MyDBUtils.getDataSource());
	try {
		return runner.query("select * from emp where id=?", new BeanHandler<Emp>(Emp.class),id);
		// runner.update("update emp set name=?,password=?,dender=?,age=?,heridate=?,salary=?,phone=?,email=? where id="+id);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public void updateEmpp(Emp emp) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.update("update emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where id=?", emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),
					  			emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail(),emp.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emp deleteEmpbyid(Integer id) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			//获取到要删除的数据
			Emp emp = runner.query("select * from emp where id=?", new BeanHandler<Emp>(Emp.class),id);
			//先将这条数据添加新的表中
			runner.update("insert into emp2 values(?,?,?,?,?,?,?,?,?)", emp.getId(),emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			//执行删除
		 runner.update("delete from emp where id=?", id);
		//数据查询，返回这条数据
	return	runner.query("select * from emp where id=?", new BeanHandler<Emp>(Emp.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findEmpEditAll() {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
		return	runner.query("select * from Emp2", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void retuenEditbyid(int id) {
			
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			Emp emp = runner.query("select * from emp2 where id=?", new BeanHandler<Emp>(Emp.class),id);
			runner.update("insert into emp values(?,?,?,?,?,?,?,?,?)", emp.getId(),emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			runner.update("delete from emp2 where id=?", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteemp2byid(int id) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		 try {
			runner.update("delete from emp2 where id=?", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Emp> findEmpAll2() {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
		return	runner.query("select * from emp2",new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertregister(Emp emp) {
			QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
			try {
				runner.update("insert into emp values(?,?,?,?,?,?,?,?,?)", emp.getId(),emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

/*	@Override
	public void deleteEmpbyid(int parseInt) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
		runner.update("delete  from emp where id=?",parseInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/

	

/*	@Override
	public int deleteEmpbyid(Integer eid) {
		QueryRunner runner = new QueryRunner();
		try {
	return	runner.update("delete  from emp where id=?", new BeanHandler<Emp>(Emp.class),eid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}*/

/*	@Override
	public void updateEmp() {
			QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
			try {
				runner.update("update emp set name=?,password=?,dender=?,age=?,heridate=?,salary=?,phone=?,email=? where id=?", new BeanHandler<Emp>(Emp.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}*/

	

}
