package com.mindtree.orchard.interfaces;

import java.util.List;

import com.mindtree.orchard.entity.College;

public interface CollegeInterface 
{
	public College addCollege(College col) ;
	public College findCollegeById(Integer id) ;
	public List<College> getAllColleges() ;

}
