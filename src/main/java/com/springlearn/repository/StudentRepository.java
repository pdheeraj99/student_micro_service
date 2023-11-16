package com.springlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlearn.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
