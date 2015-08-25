package com.znznhome.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.znznhome.dao.BaseHibernateDAO;

@Component("baseManager")
public class BaseManager<E extends Serializable, PK extends Serializable> {
	private BaseHibernateDAO baseHibernateDAO;
	
	@Resource(name="baseHibernateDAO")
	public void setBaseHibernateDAO(BaseHibernateDAO baseHibernateDAO) {
		this.baseHibernateDAO = baseHibernateDAO;
	}
	
	public E get(PK id) {
		return (E) baseHibernateDAO.get(id);
		
	}

	public E get(PK id, LockMode lock) {
		return (E) baseHibernateDAO.get(id, lock);
	}

	public Integer getRowCount(DetachedCriteria criteria) {
		return baseHibernateDAO.getRowCount(criteria);
	}

	public E load(PK id) {
		return (E)baseHibernateDAO.load(id);
	}

	public E load(PK id, LockMode lock) {
		return (E)baseHibernateDAO.load(id, lock);
	}

	public List<E> loadAll() {
		return baseHibernateDAO.loadAll();
	}

	public List<E> find(String hql) {
		return baseHibernateDAO.find(hql);
	}

	public List<E> find(String hql, Object... values) {
		return baseHibernateDAO.find(hql, values);
	}

	public List<E> findByNamedQuery(String queryName, Object... values) {
		return baseHibernateDAO.findByNamedQuery(queryName, values);
	}

	public List<E> findByNamedQuery(String queryName) {
		return baseHibernateDAO.findByNamedQuery(queryName);
	}

	public List<E> findByNamedQueryAndNamedParam(String queryName, Map<String, Object> params) {
		return baseHibernateDAO.findByNamedQueryAndNamedParam(queryName, params);
	}

	public List<E> findByNamedParam(String queryName, Map<String, Object> params) {
		return baseHibernateDAO.findByNamedParam(queryName, params);
	}

	public List<E> findByCriteria(DetachedCriteria criteria) {
		return baseHibernateDAO.findByCriteria(criteria);
	}

	public void save(E entity) throws HibernateException {
		baseHibernateDAO.save(entity);
	}

	public void saveOrUpdate(E entity) throws HibernateException {
		baseHibernateDAO.saveOrUpdate(entity);
	}

	public void saveOrUpdate(Collection<E> entitys) throws HibernateException {
		baseHibernateDAO.saveOrUpdate(entitys);
	}

	public void delete(E entity) throws HibernateException {
		baseHibernateDAO.delete(entity);
	}

	public void delete(E entity, LockMode lock) throws HibernateException {
		baseHibernateDAO.delete(entity, lock);
		this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
	}

	public void delete(Collection<E> entitys) throws HibernateException {

		baseHibernateDAO.delete(entitys);
	}

	public void update(E entity) throws HibernateException {

		baseHibernateDAO.update(entity);
	}

	public void update(E entity, LockMode lock) throws HibernateException {

		baseHibernateDAO.update(entity, lock);
		this.flush();// 如果实体不为null,立即刷新,否则锁不会生效
	}

	public Integer bulkUpdate(String hql) {

		return baseHibernateDAO.bulkUpdate(hql);
	}

	public Integer bulkUpdate(String hql, Object... values) {

		return baseHibernateDAO.bulkUpdate(hql, values);
	}

	public void flush() throws HibernateException {
		baseHibernateDAO.flush();
	}

	public void lock(E entity, LockMode lock) throws HibernateException {
		baseHibernateDAO.lock(entity, lock);
	}

}
