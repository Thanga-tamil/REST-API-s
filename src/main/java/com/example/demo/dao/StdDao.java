
package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Repo.StdRepo;
import com.example.demo.model.Student;

@Repository
public class StdDao {

	@Autowired
	private StdRepo stdRepo;

	public Student addValue(Student std) {
		return stdRepo.save(std);
	}

	public List<Student> addValues(List<Student> std) {
		return stdRepo.saveAll(std);
	}

	public Student getValue(String name) {
		return stdRepo.show(name);
	}

	public List<Student> getValues() {
		return stdRepo.findAll();
	}

	public Student updateValue(int id, Student std) {
		stdRepo.findById(id).orElse(null);
		return stdRepo.save(std);
	}

	public String delValue(int id) {
		stdRepo.deleteById(id);
		return id + " get deleted";
	}

	public String delValues() {
		stdRepo.deleteAll();
		return "Nothing here get deleted";
	}

	public Student checkValue(String email) {
		return stdRepo.findByEmail(email);

	}

}
