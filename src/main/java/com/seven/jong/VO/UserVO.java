package com.seven.jong.VO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Getter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {

	
    private Integer userId;
    private String email;
    private String password;
    private String name;
    private LocalDate birth;
    private Integer phone;
    private LocalDateTime regDate;

    public UserVO() {}
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}


	
	
    

}