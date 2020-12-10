package com.coteded.JspDemo.bo;

public class UserInfo {
	String name,number,email,desc,imagePath,videoPath;
	AccountType accountType;
	
	public UserInfo(String name, String number, String email, String desc, String imagePath, String videoPath,
			AccountType accountType) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
		this.desc = desc;
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.accountType = accountType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
