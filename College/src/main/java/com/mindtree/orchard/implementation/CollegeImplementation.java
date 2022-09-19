package com.mindtree.orchard.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.orchard.entity.CollectionOfStudents;
import com.mindtree.orchard.entity.College;
import com.mindtree.orchard.entity.Response;
import com.mindtree.orchard.interfaces.CollegeInterface;
import com.mindtree.orchard.repository.CollegeRepository;

@Component
@Service
public class CollegeImplementation implements CollegeInterface
{
	@Autowired
	private CollegeRepository collegerepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public College findCollegeById(Integer id) 
	{
		return collegerepo.findById(id).get();
	}
	
	public College addCollege(College col) 
	{
		return collegerepo.save(col);
	}
	
	public List<College> getAllColleges() 
	{
		return collegerepo.findAll();
	}
	
	public List<Response> getAllCollegeStudentInfo()
	{
		List<Response> res=new ArrayList<>();
		List<College> collegelist=collegerepo.findAll();
		
		for(int i=0; i<collegelist.size(); i++)
		{
			College col=collegelist.get(i);
			CollectionOfStudents sts=restTemplate.getForObject("http://student/college/" + col.getCollegeid() , CollectionOfStudents.class);
			res.add(new Response(col, sts.getStudent()));
		}
		return res;
	}
}

//restTemplate.getForObject("http://student/college/" + col.getCollegeid() , CollectionOfStudents.class);
//List<College> collegelist=colleges.getCol();
//List<CollegeStudent> res=new ArrayList<>();
//List<College> colleges=new ArrayList<>();
//colleges.add(new College(1,"A",10));
//colleges.add(new College(2,"B",20));
//colleges.add(new College(3,"C",30));
//
//for(int i=0;i<college.size(); i++)
//{
//	College col=colleges.get(i);
//	List<Student> sts=new ArrayList<>();
//	sts.add(new Student)(100,"Ant",120,130);
//	sts.add(new Student)(123,"Ant",111,450);
//	sts.add(new Student)(156,"Ant",133,780);
//	res.add(new CollegeStudent(col, sts));
//}