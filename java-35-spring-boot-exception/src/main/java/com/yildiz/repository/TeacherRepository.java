package com.yildiz.repository;


import com.yildiz.model.Student;
import com.yildiz.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {


}
