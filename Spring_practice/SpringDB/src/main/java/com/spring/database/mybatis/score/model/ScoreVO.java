package com.spring.database.mybatis.score.model;

public class ScoreVO {
/*
	CREATE SEQUENCE stu_id
    START WITH 1 
    INCREMENT BY 1
    NOCYCLE 
    NOCACHE;

CREATE TABLE scores(
    stu_id INTEGER PRIMARY KEY ,
    stu_name VARCHAR2(60) NOT NULL,
    kor NUMBER,
    eng NUMBER,
    math NUMBER,
    total NUMBER,
    average NUMBER(5,2)
    )
    
    */
	
	private Integer stuId;
	private String stuName;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer total;
	private Double average;
	
	
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	
	//총점 평균구하는 메서드

	public void calData() {
		this.total = this.kor + this.eng + this.math;
		this.average = Math.round((this.total / 3.0)*100)/100.0 ;
	}
		
	
	
}
