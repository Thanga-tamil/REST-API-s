package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Student;

public interface StdRepo extends JpaRepository<Student, Integer> {

	@Query(value = "select * from student where name = :name", nativeQuery = true)
	Student show(@Param("name") String name);

	Student findByEmail(String email);

}
