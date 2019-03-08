package xin.cymall.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2016年9月18日 上午9:31:36
 */
@SuppressWarnings("ALL")
public interface BaseDao<T> {

	/**
	 * 保存
	 * @param t
	 */
	void save(T t);
	
	void save(Map<String, Object> map);
	
	void saveBatch(List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);
	
	int updateBatch(Object[] id,Object value);

	T queryObject(Object id);

	T get(Object id);
	
	List<T> queryList(Map<String, Object> map);

	List<T> getList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int getCount(Map<String, Object> map);

	int queryTotal();
}
