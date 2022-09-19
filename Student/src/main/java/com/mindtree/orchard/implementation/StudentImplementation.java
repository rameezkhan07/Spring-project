package com.mindtree.orchard.implementation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindtree.orchard.entity.CollectionOfStudents;
import com.mindtree.orchard.entity.Student;
import com.mindtree.orchard.interfaces.StudentInterface;
import com.mindtree.orchard.repository.StudentRepository;


@Component
@Service
public class StudentImplementation implements StudentInterface 
{
	@Autowired
	private StudentRepository studentrepo;
	
//	@Override
	public List<Student> getAllStudents() 
	{
		return studentrepo.findAll();
	}

	public Student getStudent(Integer studentid) 
	{
		studentrepo.findById(studentid);
		return studentrepo.findById(studentid).get();
	}

	public Student addStudent(Student stu) 
	{
		return studentrepo.save(stu);
	}

	public CollectionOfStudents getStudentByCollege(Integer collegeid) {
		// TODO Auto-generated method stub
		List<Student> lists=studentrepo.findByCollegeid(collegeid);
		Comparator<Student> com=new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.getAge()>o2.getAge()) {
					return -1;
				}
				else {
				return 0;
				}
			}
		};
		Collections.sort(lists, com);
		CollectionOfStudents c=new CollectionOfStudents(lists);
		return c;
	}

}
