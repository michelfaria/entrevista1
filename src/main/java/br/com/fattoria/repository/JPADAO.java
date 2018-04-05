package br.com.fattoria.repository;

import org.jetbrains.annotations.Nullable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class JPADAO<T extends Serializable> implements DAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> klazz;

    public JPADAO(Class<T> klazz) {
        this.klazz = klazz;
    }

    @Override
    public @Nullable
    T findOne(int id) {
        return entityManager.find(klazz, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(klazz);

        cq.select(cq.from(klazz));

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public boolean oneExists() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(klazz);

        cq.select(cq.from(klazz));

        TypedQuery<T> q = getEntityManager().createQuery(cq);
        return q.setMaxResults(1).getResultList().size() > 0;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}