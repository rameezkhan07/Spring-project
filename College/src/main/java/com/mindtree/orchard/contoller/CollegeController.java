package com.mindtree.orchard.contoller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.orchard.entity.College;
import com.mindtree.orchard.entity.Response;
import com.mindtree.orchard.implementation.CollegeImplementation;




@Component
@RestController
@RequestMapping("/college")
public class CollegeController 
{
	@Autowired
	private CollegeImplementation collegeImpli;
	
	@GetMapping("/colleges/student")
	public List<Response> getCollegewithStudents()
	{
		return collegeImpli.getAllCollegeStudentInfo();
	}
	
	@GetMapping("/colleges/info")
	public List<College> getAllCollege()
	{
		return collegeImpli.getAllColleges();
	}
	
	@PostMapping("/colleges")
	public College saveCollege(@RequestBody College col)
	{
		return collegeImpli.addCollege(col);
	}
	
	@GetMapping("/colleges/{id}")
	public College findCollegeById(@PathVariable Integer id)
	{
		return collegeImpli.findCollegeById(id);
	}
}
