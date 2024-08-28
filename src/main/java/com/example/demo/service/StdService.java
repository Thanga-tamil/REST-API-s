
package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StdDao;
import com.example.demo.model.Student;
import com.example.demo.responseStruct.responseStruct;

@Service
public class StdService {

	@Autowired
	private StdDao stdDao;

	public responseStruct<Student> addDaoValue(Student std) {
		Student val = stdDao.addValue(std);
		responseStruct<Student> structure = new responseStruct<>();
		structure.setData(val);
		structure.setMsg("data added successfully :)");
		structure.setTime(LocalDateTime.now());
		structure.setStatus(HttpStatus.ACCEPTED);
		structure.setStatusCode(201);
		return structure;
	}

	public responseStruct<List<Student>> addDaoValues(List<Student> std) {
		List<Student> val = stdDao.addValues(std);
		responseStruct<List<Student>> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("List of data added successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.ACCEPTED);
		s.setStatusCode(201);
		return s;
	}

	public responseStruct<Student> getDaoValue(String name) {
		Student val = stdDao.getValue(name);
		responseStruct<Student> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("Retrieved successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.FOUND);
		s.setStatusCode(201);
		return s;
	}

	public responseStruct<List<Student>> getDaoValues() {
		List<Student> val = stdDao.getValues();
		responseStruct<List<Student>> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("List of data Retrieved successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.FOUND);
		s.setStatusCode(201);
		return s;
	}

	public responseStruct<Student> updateDaoValue(int id, Student std) {
		Student val = stdDao.updateValue(id, std);
		responseStruct<Student> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("Updated successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.ACCEPTED);
		s.setStatusCode(201);
		return s;
	}

	public responseStruct<String> delValue(int id) {
		String val = stdDao.delValue(id);
		responseStruct<String> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("deleted successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.GONE);
		s.setStatusCode(301);
		return s;
	}

	public responseStruct<String> delValues() {
		String val = stdDao.delValues();
		responseStruct<String> s = new responseStruct<>();
		s.setData(val);
		s.setMsg("nothing here successfully :)");
		s.setTime(LocalDateTime.now());
		s.setStatus(HttpStatus.GONE);
		s.setStatusCode(301);
		return s;

	}

	public String checkDaoData(String mail, Student std) {
		Student byEmail = stdDao.checkValue(mail);

		if (mail.equals(byEmail.getEmail()) && std.getPasswd().equals(byEmail.getPasswd())) {
			return "login Success";
		}

		return null;
	}
}
