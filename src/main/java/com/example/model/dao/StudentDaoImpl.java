package com.example.model.dao;

import com.example.core.dao.BaseDaoImpl;
import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDAO {
    private final SessionFactory factory;

    public StudentDaoImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    protected String getEntityName() {
        return "students";
    }
    @Override
    public ArrayList getNotInTehran() {
        Session session = factory.openSession();
        ArrayList<Student> list = new ArrayList<>();
        session.beginTransaction();
        Query query = session.createQuery(
                "select s from Student s join Address a on s.address.id = a.id where a.city!='tehran'");
        list.addAll(query.getResultList());
        session.getTransaction().commit();

        session.close();
        return list;
    }
    @Override
    public List search(String string) {
        Session session = factory.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "from Student t where t.firstName like '%"+string+"%'")
                .getResultList();
        list.addAll(session.createQuery(
                "from Student t where t.lastName like '%"+string+"%'")
                .getResultList());
        return list;

    }
}
