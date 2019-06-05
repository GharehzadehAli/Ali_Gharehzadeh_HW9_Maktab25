package com.example.model.dao;

import com.example.core.dao.BaseDAO;
import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;


public interface StudentDAO extends BaseDAO<Student> {
    List search(String string);

    ArrayList getNotInTehran();
}
