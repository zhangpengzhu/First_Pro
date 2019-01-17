package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.utils.MyDBUtils;

/**
 * 测试连接数据库
 *
 */
public class TestConnections {
	
	private static DataSource source = MyDBUtils.getDataSource();
	private static QueryRunner runner=new QueryRunner(source);
	@Test
		public void testconnection() throws SQLException {
				Connection connection = MyDBUtils.getConnection();
							System.out.println(connection);
				
				connection.close();
		}
	@Test
	public void testdata() {
		try {
			List<Emp> list = runner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
			for (Emp emp : list) {
				System.out.println(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		List<Emp> list;
		try {
			list = runner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
			for (Emp emp : list) {
				System.out.println(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int i = runner.update("update emp set age=? where name=?", "15","siri");
		//	int j = runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)", new Object[] {"cat","123","男","3","2019-02-08","1000","13982587329","761041124@qq.com"});
			System.out.println(i);
	//		System.out.println(j);
			String sql="select count(*) from emp";
			Object query = runner.query(sql, new ScalarHandler());
			System.out.println(query);
			String sql1="select * from emp";
			Map<Object, Map<String, Object>> map = runner.query(sql1, new KeyedHandler());
			System.out.println(map);
			List<Map<String,Object>> list2 = runner.query(sql1, new MapListHandler());
			System.out.println(list2);
			Map<String, Object> map2 = runner.query(sql1, new MapHandler());
			System.out.println(map2);
			List<Object> list3 = runner.query(sql1, new ColumnListHandler("age"));
			System.out.println(list3);
			List<Emp> list4 = runner.query(sql1, new BeanListHandler<Emp>(Emp.class));
			for (Emp emp : list4) {
				System.out.println(emp);
			}
			String sql2="select * from emp where name=?";
			Emp emp = runner.query(sql2, new BeanHandler<Emp>(Emp.class),"tom");
			System.out.println(emp);
			List<Object[]> list5 = runner.query(sql1, new ArrayListHandler());
			for (Object[] objects : list5) {
				System.out.println(Arrays.toString(objects));
			}
			Object[] objects = runner.query(sql1, new ArrayHandler());
			System.out.println(Arrays.toString(objects));
			String sq="delete from emp where id=?";
			runner.update(sq,4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
