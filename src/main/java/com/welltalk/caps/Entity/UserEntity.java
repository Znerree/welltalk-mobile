	package com.welltalk.caps.Entity;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "tbl_user")
	public class UserEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userid;
	
	    @Column(name = "student_id", nullable = false, unique = true)
	    private String studentID;
	
	    private String firstName;
	    private String lastName;
	    private String course;
	    private String email;
	    private Long phoneNumber;
	    private String password;
	
	    public UserEntity() {
	
	    }
	
	    public UserEntity(Long userid, String studentID, String firstName, String lastName, String course, String email,
	            Long phoneNumber, String password) {
	        super();
	        this.userid = userid;
	        this.studentID = studentID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.course = course;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.password = password;
	    }
	
	    public Long getUserid() {
	        return userid;
	    }
	
	    public void setUserid(Long userid) {
	        this.userid = userid;
	    }
	
	    public String getStudentID() {
	        return studentID;
	    }
	
	    public void setStudentID(String studentID) {
	        this.studentID = studentID;
	    }
	
	    public String getFirstName() {
	        return firstName;
	    }
	
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	
	    public String getLastName() {
	        return lastName;
	    }
	
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	
	    public String getCourse() {
	        return course;
	    }
	
	    public void setCourse(String course) {
	        this.course = course;
	    }
	
	    public String getEmail() {
	        return email;
	    }
	
	    public void setEmail(String email) {
	        this.email = email;
	    }
	
	    public Long getPhoneNumber() {
	        return phoneNumber;
	    }
	
	    public void setPhoneNumber(Long phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	
	    public String getPassword() {
	        return password;
	    }
	
	    public void setPassword(String password) {
	        this.password = password;
	    }
	}
