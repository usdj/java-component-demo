package com.usdj.dao;

import com.usdj.domain.Student;

import java.util.List;

/**
 * @author gerrydeng
 * @date 2019-07-25 10:22
 * @Description:
 */
public interface StudentDao {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> query();

    /**
     * 添加学生信息
     * @param student
     */
    void save(Student student);
}
