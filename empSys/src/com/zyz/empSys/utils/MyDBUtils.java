package com.zyz.empSys.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * c3p0数据库连接池
 */
public class MyDBUtils {
	private static ComboPooledDataSource source = null;
	private static Connection connection = null;

	/**
	 * 私有构造
	 */
	private MyDBUtils() {
	}

	/**
	 * 获取到数据源
	 * 
	 * @return
	 * @throws PropertyVetoException
	 */
	public static DataSource getDataSource() {
		source = new ComboPooledDataSource();
		return source;
	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		connection = getDataSource().getConnection();
		if (connection != null) {
			return connection;
		} else {
			connection = getDataSource().getConnection();
		}
		return connection;
	}

	/**
	 * 关闭连接对象
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
