package com.walye.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;

/**
 * 泛型DAO实现
 * 
 * @author tojsp.com
 *
 * @date 2014年6月19日上午9:04:43
 */
@SuppressWarnings("unchecked")
public class BaseDao4Hibernate<E, PK extends Serializable> extends
		AbstractPageDao<E, PK> implements BaseDao<E, PK> {

	public BaseDao4Hibernate() {
		super.clazz = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<E> findAll() {
		return getSession().createQuery(from()).list();
	}

	@Override
	public long save(E e) {
		return (Long) getSession().save(e);
	}

	@Override
	public void delete(E e) {
		getSession().delete(e);
	}

	@Override
	public void deleteByProperty(String propertyName, Object value) {
		List<E> es = findByProperty(propertyName, value);
		for (E e : es) {
			delete(e);
		}
	}

	@Override
	public List<E> findByProperty(String propertyName, Object value) {
		String[] propertyNames = { propertyName };
		Object[] values = { value };
		return findByPropertys(propertyNames, values);
	}

	@Override
	public List<E> findByPropertys(String[] propertyNames, Object[] values) {
		return getSession().createQuery(from() + where(propertyNames, values))
				.list();
	}

	@Override
	public long countAll() {
		return (long) getSession().createQuery(count()).uniqueResult();
	}

	@Override
	public long countByProperty(String propertyName, Object value) {
		String[] propertyNames = { propertyName };
		Object[] values = { value };
		return countByPropertys(propertyNames, values);
	}

	@Override
	public long countByPropertys(String[] propertyNames, Object[] values) {
		Query query = getSession().createQuery(
				count() + where(propertyNames, values));
		return (long) query.uniqueResult();
	}

	@Override
	public void saveOrUpdate(E e) {
		getSession().saveOrUpdate(e);
	}

	@Override
	public E findById(PK id) {
		return (E) getSession().get(getClazz(), id);
	}

	@Override
	public void update(E e) {
		getSession().update(e);
	}

	@Override
	public List<E> findAndOrderByProperty(int firstResult, int fetchSize,
			String propertyName, boolean isSequence) {
		String hql = from() + getOrder(propertyName, isSequence);
		Query query = getSession().createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(fetchSize);
		return query.list();
	}

	@Override
	public List<E> findAllAndOrderByProperty(String propertyName,
			boolean isSequence) {
		String hql = from() + getOrder(propertyName, isSequence);
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	private String getOrder(String propertyName, boolean isSequence) {
		StringBuilder accum = new StringBuilder(" ");
		accum.append("order by ");
		accum.append(propertyName);
		accum.append(" ");
		accum.append(isSequence ? "asc" : "desc");
		return accum.toString();
	}

	@Override
	public List<E> pageByPropertysAndOrder(String[] propertyNames,
			Object[] values, int page, int pageSize, String propertyName,
			boolean isSequence) {
		Query query = getSession().createQuery(
				from() + where(propertyNames, values)
						+ getOrder(propertyName, isSequence));
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public List<E> pageByPropertyAndOrder(String propertyName, Object value,
			int page, int pageSize, String orderPropertyName, boolean isSequence) {
		String[] propertyNames = { propertyName };
		Object[] values = { value };
		Query query = getSession().createQuery(
				from() + where(propertyNames, values)
						+ getOrder(orderPropertyName, isSequence));
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public List<E> pageAndOrder(int page, int pageSize, String propertyName,
			boolean isSequence) {
		Query query = getSession().createQuery(
				from() + getOrder(propertyName, isSequence));
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public List<E> findByHql(String hql, String... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	public List<E> pageByHql(String hql, int page, int pageSize,
			String... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List countByHql(String hql, String... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	@Override
	public List<E> findBySql(String sql, String... params) {
		Query query = getSession().createQuery(sql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	public void excuteSql(String sql, String... params) {
		Query query = getSession().createQuery(sql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.executeUpdate();
	}

}