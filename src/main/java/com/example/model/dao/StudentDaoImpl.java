package com.example.model.dao;

import com.example.core.dao.BaseDaoImpl;
import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
