package com.elearning.coursemanagement.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column
	@SequenceGenerator(name = "mysequence" ,initialValue = 2020, allocationSize = 1, sequenceName = "EL_STUDENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
	private int id;
	@NotEmpty(message="name should not be empty")
	@Column
	private String name;
	@Column
	@Email(message="invalid email")
	@NotEmpty(message="enter valid mail")
	private String email;
	@Column
	//@Pattern(regexp="?([6789][0-9]{10})",message="Invalid Mobile")
	private String mobile;
	@Column
	private Date datecreated;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "STUDENT_COURSE",joinColumns = {@JoinColumn(name="st_No",referencedColumnName = "Id")},inverseJoinColumns =
    {@JoinColumn(name="courseid", referencedColumnName ="courseid" )}  )
    List<Course>  courseList;
 @Column
     @NotEmpty(message ="Password  should not empty")
	private String password;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public  void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Course> getCourseList() {
        return courseList;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id="+id+",name=" + name + ", email=" + email + ", mobile=" + mobile + ", datecreated="
				+ datecreated + ", password=" + password + "]";
	}
	
	

}
