
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.responseStruct.responseStruct;
import com.example.demo.service.StdService;

@RestController
@RequestMapping("/std")
@CrossOrigin(origins = "*")
public class StdController {

	@Autowired
	private StdService stdService;

	@PostMapping("/add")
	public ResponseEntity<?> addSerValue(@RequestBody Student std) {
		responseStruct<Student> s = stdService.addDaoValue(std);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@PostMapping("/adds")
	public ResponseEntity<?> addSerValues(@RequestBody List<Student> stds) {
		responseStruct<List<Student>> s = stdService.addDaoValues(stds);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/read/{name}")
	public ResponseEntity<?> getSerValue(@PathVariable String name) {
		responseStruct<Student> s = stdService.getDaoValue(name);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/reads")
	public ResponseEntity<?> getSerValues() {
		responseStruct<List<Student>> s = stdService.getDaoValues();
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateSerValue(@RequestParam int id, @RequestBody Student std) {
		responseStruct<Student> s = stdService.updateDaoValue(id, std);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/del")
	public ResponseEntity<?> delSerValue(@RequestParam int id) {
		responseStruct<String> s = stdService.delValue(id);
		return new ResponseEntity<>(s, HttpStatus.GONE);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> delSerValues() {
		responseStruct<String> s = stdService.delValues();
		return new ResponseEntity<>(s, HttpStatus.GONE);
	}

	@PostMapping("/check")
	public ResponseEntity<?> checkServiceMail(@RequestParam String email, @RequestBody Student std) {
		String daoCheck = stdService.checkDaoData(email, std);

		if (daoCheck != null) {
			return ResponseEntity.ok(daoCheck);
		} else {
			return ResponseEntity.status(404).build();
		}

	}

}
