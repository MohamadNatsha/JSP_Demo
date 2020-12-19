package com.coteded.JspDemo.bo;

import java.io.IOException;

import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.service.aws.S3Link;

public class UserBean {
	private String name;
	private String phone;
	private String email;
	private String desc;
	private String image;
	private String video;
	private UserAccounttype accountType;

	public UserBean() {

	}

	public UserBean(String name, String phone, String email, String desc, String image, String video,
			UserAccounttype accountType) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.desc = desc;
		this.image = image;
		this.video = video;
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public UserAccounttype getAccountType() {
		return accountType;
	}

	public void setAccountType(UserAccounttype accountType) {
		this.accountType = accountType;
	}

	public String getImageLink() {
		S3Link s3link = new S3Link();
		return s3link.getLink(image);
	}

	public String getVideoLink() {
		S3Link s3link = new S3Link();
		return s3link.getLink(video);
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", number=" + phone + ", email=" + email + ", desc=" + desc + ", image="
				+ image + ", video=" + video + ", accountType=" + accountType + "]";
	}

}
