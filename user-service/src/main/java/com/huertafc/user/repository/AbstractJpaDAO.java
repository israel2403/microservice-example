package com.huertafc.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@EnableTransactionManagement
public abstract class AbstractJpaDAO<T extends Serializable> {

    @PersistenceContext
    private EntityManager entityManager;
    
    private final Class<T> entityClass;
    
    public AbstractJpaDAO(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

    public T findOne(final Long id) {
        return entityManager.find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + entityClass.getName()).getResultList();
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
}
