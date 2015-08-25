package com.znznhome.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Component;

@Component("baseJdbcDAO")
public class BaseJdbcDAO {
	
	QueryRunner qr = new QueryRunner();

	public Connection getConnection(){
		Driver driver;
		Connection conn = null;
		try {
			driver = (Driver)Class.forName("org.logicalcobwebs.proxool.ProxoolDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("proxool.znzn");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 批量执行指定的SQL语句
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */

	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			int[] num = qr.batch(conn, sql, params);
			conn.commit();
			return num;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	public int[] batch(Connection conn, List<String> sqls) throws SQLException {
		Statement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.createStatement();
			for (int i = 0; i < sqls.size(); i++) {
				st.addBatch(sqls.get(i));
			}
			int[] num = st.executeBatch();
			conn.commit();
			st.close();
			return num;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}
	}

	/**
	 * 
	 * 执行INSERT/UPDATE/DELETE语句
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int update(String sql, Object... params) throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			int n = qr.update(conn, sql, params);
			conn.commit();
			return n;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	/**
	 * 
	 * 执行INSERT/UPDATE/DELETE语句
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int update(String sql, Connection conn, Object... params)
			throws SQLException {
		try {
			conn.setAutoCommit(false);
			int n = qr.update(conn, sql, params);
			conn.commit();
			return n;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		}
	}

	/**
	 * 
	 * 读取某个对象
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */

	public <T> T queryForBean(Class<T> beanClass, String sql, Object... params)
			throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			T t = (T) qr.query(conn, sql, new BeanHandler(beanClass), params);
			conn.commit();
			return t;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	/**
	 * 对象查询
	 * 
	 * @param <T>
	 * 
	 * @param beanClass
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */

	public <T> List<T> queryForBeanList(Class<T> beanClass, String sql,
			Object... params) throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			List<T> list = (List<T>) qr.query(conn, sql, new BeanListHandler(
					beanClass), params);
			conn.commit();
			return list;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	/**
	 * 分页查询
	 * 
	 * @Description
	 * @author jiuyin.wei
	 * @param <T>
	 * @param beanClass
	 * @param sql
	 * @param page
	 * @param pageSize
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public <T> List<T> querySlice(Class<T> beanClass, String sql, int page,
			int pageSize, Object[] params) throws SQLException {
		if (page < 0 || pageSize < 0)
			throw new IllegalArgumentException(
					"Illegal parameter of 'page' or 'count'.");
		int from = (page - 1) * pageSize;
		pageSize = (pageSize > 0) ? pageSize : Integer.MAX_VALUE;
		int size = 0;
		if (params != null)
			size = params.length;
		Object[] obj = new Object[size + 2];
		for (int i = 0; i < size; i++)
			obj[i] = params[i];
		obj[obj.length - 2] = pageSize;
		obj[obj.length - 1] = from;
		return queryForBeanList(beanClass, sql + " LIMIT ? OFFSET ?", obj);
	}

	/**
	 * 查询数据集
	 * 
	 * @param whereSql
	 * @param colums
	 *            待查询字段名
	 * @return List中存放的是Map<colum, value>
	 * @throws DaoException
	 */
	public List<HashMap<String, Object>> queryForMapList(String sql,
			Object... params) throws SQLException {
		Connection conn = null;
		ResultSetHandler rsh = new MapListHandler();
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) qr
					.query(conn, sql, rsh, params);
			conn.commit();
			return list;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	/**
	 * 查询数据集
	 * 
	 * @Description
	 * @author jiuyin.wei
	 * @param sql
	 *            标准的sql
	 * @return list对应每条记录
	 * @throws DaoException
	 */
	public List<Object[]> queryForArrayList(String sql, Object... params)
			throws SQLException {
		List<Object[]> result = null;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			result = (List<Object[]>) qr.query(conn, sql,
					new ArrayListHandler(), params);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
		return result;
	}

	/**
	 * 查询一条数据(多条默认取第一行)
	 * 
	 * @Description
	 * @author jiuyin.wei
	 * @param sql
	 *            标准的sql
	 * @return 对应一条数据
	 * @throws SQLException
	 */
	public <K, V> HashMap<K, V> queryForMap(String sql, Object... params)
			throws SQLException {
		HashMap<K, V> result = null;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			result = (HashMap<K, V>) qr.query(conn, sql, new MapHandler());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	/**
	 * 查询一条数据(多条默认取第一行)
	 * 
	 * @Description
	 * @author jiuyin.wei
	 * @param sql
	 *            标准的sql
	 * @return 对应一条数据
	 * @throws SQLException
	 */
	public Object[] queryForArray(String sql, Object... params)
			throws SQLException {
		Object[] result = null;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			result = (Object[]) qr.query(conn, sql, new ArrayHandler(), params);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
		return result;
	}

	/**
	 * 
	 * 执行统计查询语句，语句的执行结果必须只返回一个数值
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */

	public long stat(String sql, Object... params) throws SQLException {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			Number num = (Number) qr.query(conn, sql, new ScalarHandler(),
					params);
			conn.commit();
			return (num != null) ? num.longValue() : -1;
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

}
