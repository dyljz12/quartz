package com.clic.cloudops.scheduler.model;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2018-12-17
*/
@Table(name="stsmanage.area")
public class Area   {
	
	private String nameTeacher ;
	private Integer priceCourse ;
	private String nameCourse ;
	private String nameSchool ;
	
	public Area() {
	}
	
	public String getNameTeacher(){
		return  nameTeacher;
	}
	public void setNameTeacher(String nameTeacher ){
		this.nameTeacher = nameTeacher;
	}
	
	public Integer getPriceCourse(){
		return  priceCourse;
	}
	public void setPriceCourse(Integer priceCourse ){
		this.priceCourse = priceCourse;
	}
	
	public String getNameCourse(){
		return  nameCourse;
	}
	public void setNameCourse(String nameCourse ){
		this.nameCourse = nameCourse;
	}
	
	public String getNameSchool(){
		return  nameSchool;
	}
	public void setNameSchool(String nameSchool ){
		this.nameSchool = nameSchool;
	}
	

}
