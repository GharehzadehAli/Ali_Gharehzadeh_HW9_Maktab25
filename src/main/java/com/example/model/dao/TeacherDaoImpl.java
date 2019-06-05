package com.example.model.dao;


import com.example.core.dao.BaseDaoImpl;
import com.example.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDAO {
    private final SessionFactory factory;

    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    protected String getEntityName() {
        return "teachers";

    }

    @Override
    public void deleteByCode(String code) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery(
                "delete from '" + getEntityName() + "' where '" + getEntityName() + "'.teacher_code='" + code + "'");


        session.getTransaction().commit();

        session.close();
    }

    @Override
    public Teacher getAge() {

        Session session = factory.openSession();

        session.beginTransaction();
        session.createQuery("");

        session.getTransaction().commit();

        session.close();
        return null;
    }

    @Override
    public ArrayList getExtremumSalary() {
        Session session = factory.openSession();
        List list;
        session.beginTransaction();
        list = session.createQuery(
                "from Teacher t where salary=(select max(salary) from t)")
                .getResultList();
        list.addAll(session.createQuery(
                "from Teacher t where salary=(select min (salary) from t)")
                .getResultList());

        session.getTransaction().commit();

        session.close();
        return (ArrayList) list;
    }

    @Override
    public ArrayList getExtremumAge() {
        Session session = factory.openSession();
        ArrayList<Teacher> list = new ArrayList();
        session.beginTransaction();
        list.add((Teacher) session.createQuery("from Teacher t where date=(select max(date) from t)")
                .getSingleResult());
        list.add((Teacher) session.createQuery("from Teacher t where date=(select min(date) from t)")
                .getSingleResult());

        session.getTransaction().commit();

        session.close();
        return list;
    }

    @Override
    public ArrayList findByCity() {
        Session session = factory.openSession();
        ArrayList<Teacher> list = new ArrayList<>();
        session.beginTransaction();
        Query query = session.createQuery(
                "select t from Teacher t join Address a on t.address.id = a.id where a.city='tehran'");
        list.addAll(query.getResultList());
        session.getTransaction().commit();

        session.close();
        return list;
    }

    @Override
    public ArrayList getByNumber() {
        Session session = factory.openSession();
        ArrayList<Teacher> list = new ArrayList<>();
        session.beginTransaction();
        Query query = session.createQuery(
                "select t from Teacher t join Address a on t.address.id = a.id where a.number like '0912%'");
        list.addAll(query.getResultList());
        session.getTransaction().commit();

        session.close();
        return list;
    }
    @Override
    public ArrayList getByCityAndNumber() {
        Session session = factory.openSession();
        ArrayList<Teacher> list = new ArrayList<>();
        session.beginTransaction();
        Query query = session.createQuery(
                "select t from Teacher t join Address a on t.address.id = a.id where a.number like '0912%' and a.city='tehran'");
        list.addAll(query.getResultList());
        session.getTransaction().commit();

        session.close();
        return list;
    }


    @Override
    public void deleteByCode(long code) {
        Session session = factory.openSession();

        session.beginTransaction();

        Teacher teacher = (Teacher) session.createQuery(
                "select t from Teacher t where teacherCode=" + code + "")
                .getSingleResult();

        session.getTransaction().commit();

        session.close();
        delete(teacher.getId());
    }


}
