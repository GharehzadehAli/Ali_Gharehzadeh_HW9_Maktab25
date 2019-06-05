package com.example.model.dao;



import com.example.core.dao.BaseDAO;
import com.example.model.Teacher;

import java.util.ArrayList;


public interface TeacherDAO extends BaseDAO<Teacher> {
    void deleteByCode(String code);
    Teacher getAge();
    ArrayList getExtremumSalary();
    ArrayList getExtremumAge();
    ArrayList findByCity();
    ArrayList getByNumber();
    ArrayList getByCityAndNumber();

    void deleteByCode(long code);


}
