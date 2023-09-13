package com.suresec.uias.vo;

import java.io.Serializable;

/**
 * user_info(用户信息表)
 * @author WanCC
 * @Date 2022-09-07 11:29:20
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	//主键
	private String id;
	//用户名称
	private String userName;
	//登录名
	private String loginName;
	//登录密码
	private String loginPasswd;
	//组织机构ID
	private Integer orgId;
	//身份证号
	private String userCard;
	//邮箱
	private String userEmail;
	//手机号
	private String userPhone;
	//用户所在城市
	private String userCityId;
	//用户类型
	private Integer userType;
	//用户签章图片
	private String userEsmsImg;
	//同步状态
	private Integer sendFlag;
	//用户状态
	private Integer userStatus;
	//添加时间
	private String addTime;
	//备注
	private String remark;
	// ADD-WCC: 列表显示组织结构名称   [WanCC 2021/11/26  15:54]
	private String orgIdName;
	// ADD-WCC: 用户类型--辅助字段   [WanCC 2022/10/24  14:46]
	private String userTypeCheckBox;

	public String getUserTypeCheckBox()
	{
		return userTypeCheckBox;
	}

	public void setUserTypeCheckBox(String userTypeCheckBox)
	{
		this.userTypeCheckBox = userTypeCheckBox;
	}

	public String getOrgIdName()
	{
		return orgIdName;
	}

	public void setOrgIdName(String orgIdName)
	{
		this.orgIdName = orgIdName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName =  userName;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName =  loginName;
	}
	public String getLoginPasswd() {
		return loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd =  loginPasswd;
	}
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId =  orgId;
	}
	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard =  userCard;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail =  userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone =  userPhone;
	}
	public String getUserCityId() {
		return userCityId;
	}

	public void setUserCityId(String userCityId) {
		this.userCityId =  userCityId;
	}
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType =  userType;
	}
	public String getUserEsmsImg() {
		return userEsmsImg;
	}

	public void setUserEsmsImg(String userEsmsImg) {
		this.userEsmsImg =  userEsmsImg;
	}
	public Integer getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(Integer sendFlag) {
		this.sendFlag =  sendFlag;
	}
	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus =  userStatus;
	}
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime =  addTime;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark =  remark;
	}

}