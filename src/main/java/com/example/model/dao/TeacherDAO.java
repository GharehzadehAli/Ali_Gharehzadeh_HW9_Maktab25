package com.example.model.dao;



import com.example.core.dao.BaseDAO;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {
    void deleteByCode(String code);
    Teacher getAge();
    ArrayList getExtremumSalary();
    ArrayList getExtremumAge();
    List<Teacher> findByCity();
    void deleteByCode(long code);


}
