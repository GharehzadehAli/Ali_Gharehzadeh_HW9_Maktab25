package com.example.core.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

abstract public class BaseDaoImpl<E extends Serializable> implements BaseDAO<E> {

    private final SessionFactory factory;

    public BaseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    abstract protected String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public E update(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();
        return e;
    }

    @Override
    public E read(Serializable id) {


        Session session = factory.openSession();

        session.beginTransaction();

        E e = (E) session.get(getEntityName(), id);
        session.getTransaction().commit();

        session.close();
        return e;
    }

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(read(id));
        //session.createSQLQuery("delete from " + getEntityName() + " where " + getEntityName() + ".id = " + id + "");

        session.getTransaction().commit();
        session.close();
    }

    public List searchByName(String string) {
        Session session = factory.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "from '" + getEntityName() + "' where '" + getEntityName() + "'.first_name like '" + string + "' or '" + getEntityName() + "'.last_name like '" + string +"'")
                .getResultList();
        return list;
    }
}
