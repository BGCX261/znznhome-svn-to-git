package com.znznhome.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.znznhome.dao.BaseHibernateDAO;

@Component("baseHibernateDAO")
public class BaseHibernateDAOImpl<E extends Serializable, PK extends Serializable> implements
		BaseHibernateDAO<E, PK> {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 为E对应的实例类型
	 */
	private Class<?> entityClass;

	/**
	 * 获取E实例类的类型
	 */
/*	public BaseHibernateDAOImpl() {
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			this.entityClass = (Class<?>) ((ParameterizedType) t).getActualTypeArguments()[0];
		}
	}*/

	public E get(PK id) {

		return (E) hibernateTemplate.get(this.entityClass, id);
		
	}

	public E get(PK id, LockMode lock) {

		E entity = (E) hibernateTemplate.get(this.entityClass, id, lock);
		if (entity != null) {
			this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
		}
		return entity;
	}

	public Object getStackValue(DetachedCriteria criteria, String propertyName, Stack value) {
		switch (value) {
		case MAX:
			criteria.setProjection(Projections.max(propertyName));
			break;
		case MIN:
			criteria.setProjection(Projections.min(propertyName));
			break;
		case AVG:
			criteria.setProjection(Projections.avg(propertyName));
			break;
		default:
			criteria.setProjection(Projections.sum(propertyName));
			break;
		}
		return this.findByCriteria(criteria, 0, 1).get(0);
	}

	public Integer getRowCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		return (Integer) this.findByCriteria(criteria, 0, 1).get(0);
	}

	public E load(PK id) {
		return (E) hibernateTemplate.load(this.entityClass, id);
	}

	public E load(PK id, LockMode lock) {

		E entity = (E) hibernateTemplate.load(this.entityClass, id, lock);
		if (entity != null) {
			this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
		}
		return entity;
	}

	public List<E> loadAll() {

		return hibernateTemplate.loadAll(entityClass);
	}

	public List<E> find(String hql) {

		return hibernateTemplate.find(hql);
	}

	public List<E> find(String hql, Object... values) {

		return hibernateTemplate.find(hql, values);
	}

	public List<E> findByNamedQuery(String queryName, Object... values) {

		return hibernateTemplate.findByNamedQuery(queryName, values);
	}

	public List<E> findByNamedQuery(String queryName) {

		return hibernateTemplate.findByNamedQuery(queryName);
	}

	public List<E> findByNamedQueryAndNamedParam(String queryName, Map<String, Object> params) {

		return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, (String[]) params
				.keySet().toArray(), params.values().toArray());
	}

	public List<E> findByNamedParam(String queryName, Map<String, Object> params) {

		return hibernateTemplate.findByNamedParam(queryName, (String[]) params.keySet().toArray(),
				params.values().toArray());
	}

	public List<E> findByCriteria(DetachedCriteria criteria) {

		return hibernateTemplate.findByCriteria(criteria);
	}

	public List<E> findByCriteria(DetachedCriteria criteria, Integer firstResult, Integer maxResults) {

		return hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
	}

	public void save(E entity) throws HibernateException {

		hibernateTemplate.save(entity);
	}

	public void saveOrUpdate(E entity) throws HibernateException {

		hibernateTemplate.saveOrUpdate(entity);
	}

	public void saveOrUpdate(Collection<E> entitys) throws HibernateException {

		hibernateTemplate.saveOrUpdateAll(entitys);
	}

	public void delete(E entity) throws HibernateException {

		hibernateTemplate.delete(entity);
	}

	public void delete(E entity, LockMode lock) throws HibernateException {

		hibernateTemplate.delete(entity, lock);
		this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
	}

	public void delete(Collection<E> entitys) throws HibernateException {

		hibernateTemplate.deleteAll(entitys);
	}

	public void update(E entity) throws HibernateException {

		hibernateTemplate.update(entity);
	}

	public void update(E entity, LockMode lock) throws HibernateException {

		hibernateTemplate.update(entity, lock);
		this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
	}

	public Integer bulkUpdate(String hql) {

		return hibernateTemplate.bulkUpdate(hql);
	}

	public Integer bulkUpdate(String hql, Object... values) {

		return hibernateTemplate.bulkUpdate(hql, values);
	}

	public void flush() throws HibernateException {

		hibernateTemplate.flush();
	}

	public void lock(E entity, LockMode lock) throws HibernateException {

		this.getHibernateTemplate().lock(entity, lock);
	}

	public DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(this.entityClass);
	}

	public DetachedCriteria createDetachedCriteria(Class<? extends Serializable> c) {
		return DetachedCriteria.forClass(c);
	}

	public Criteria createCriteria() {
		return this.createDetachedCriteria().getExecutableCriteria(
				this.sessionFactory.getCurrentSession());
	}

	public Object getStackValue(DetachedCriteria criteria, String propertyName, String stackName) {
		// TODO Auto-generated method stub
		return null;
	}

}
