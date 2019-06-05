package com.example.model;


import com.example.model.dao.StudentDAO;
import com.example.model.dao.StudentDaoImpl;
import com.example.model.dao.TeacherDAO;
import com.example.model.dao.TeacherDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        TeacherDAO teacherDao = new TeacherDaoImpl(factory);
        StudentDAO studentDao = new StudentDaoImpl(factory);

        Teacher teacher = new Teacher(
                "john",
                "Jefferson",
                11111111,
                LocalDate.of(1990, 12, 21), 500);
        Teacher teacher1 = new Teacher(
                "jack",
                "jackson",
                2222222,
                LocalDate.of(1993, 7, 8), 523);
        Teacher teacher2 = new Teacher(
                "jason",
                "Julian",
                33333,
                LocalDate.of(1986, 3, 2), 550);
        Address address = new Address("tehran", "tehran", "0912123","PA1","pC1");
        Address address1 = new Address("tehran", "tehran", "0936564","PA2","pC2");
        Address address2 = new Address("Tabriz", "Tabriz", "0912432","PA3","pC3");
        teacher.setAddress(address);
        teacherDao.create(teacher);
        teacher1.setAddress(address1);
        teacherDao.create(teacher1);
        teacher2.setAddress(address2);
        teacherDao.create(teacher2);
        Student student = new Student("Ali", "Gharehzadeh");
        student.setAddress(address);
        studentDao.create(student);
        Student student1 = new Student("Hosein", "Hamidi");

        student1.setAddress(address2);
        studentDao.create(student1);
        Student student2 = new Student("Ahmad", "Ahmadi");
        student2.setAddress(address1);
        studentDao.create(student2);
        Session session = factory.openSession();

        session.beginTransaction();
        //System.out.println(teacherDao.findByCity());
        System.out.println(studentDao.getNotInTehran());
        //System.out.println(teacherDao.getByNumber());
        //System.out.println(teacherDao.getByCityAndNumber());
        //System.out.println(studentDao.search("j"));
        //System.out.println(teacherDao.getExtremumSalary());
        // System.out.println(teacherDao.getExtremumAge());
        //System.out.println(studentDao.search("li"));
        session.getTransaction().commit();

        session.close();

        factory.close();

    }
}
