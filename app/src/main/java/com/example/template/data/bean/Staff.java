package com.example.template.data.bean;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {

    private int id;
    private String name;
    private String gender;
    private Integer age;
    private String idNumber;
    private String phoneNumber;
    private String email;
    // 家庭住址
    private String address;
    // 部门名称
    private String departmentName;
    // 职位名称
    private String positionName;
    // 工号
    private String jobNumber;
    // 入职日期
    private Date hireDate;
    // 离职日期
    private Date leaveDate;
    // 工作状态（在职/离职）
    private boolean workingStatus;
    // 工作地点
    private String workLocation;
    // 工作时间（每周工作小时数）
    private int weeklyWorkingHours;
    // 薪资（每月/年）
    private double salary;
    // 假期天数（每年）
    private int annualLeaveDays;
    // 健康状况
    private String healthStatus;
    // 紧急联系人姓名
    private String emergencyContactName;
    // 紧急联系人电话号码
    private String emergencyContactPhoneNumber;
    // 备注
    private String remark;

    public Staff() {}

    public Staff(int id, String name, String gender, Integer age, String idNumber, String phoneNumber,
                 String email, String address, String departmentName, String positionName,
                 String jobNumber, Date hireDate, Date leaveDate, boolean workingStatus,
                 String workLocation, int weeklyWorkingHours, double salary,
                 int annualLeaveDays, String healthStatus, String emergencyContactName,
                 String emergencyContactPhoneNumber, String remark) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.departmentName = departmentName;
        this.positionName = positionName;
        this.jobNumber = jobNumber;
        this.hireDate = hireDate;
        this.leaveDate = leaveDate;
        this.workingStatus = workingStatus;
        this.workLocation = workLocation;
        this.weeklyWorkingHours = weeklyWorkingHours;
        this.salary = salary;
        this.annualLeaveDays = annualLeaveDays;
        this.healthStatus = healthStatus;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
        this.remark = remark;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public boolean isWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public int getWeeklyWorkingHours() {
        return weeklyWorkingHours;
    }

    public void setWeeklyWorkingHours(int weeklyWorkingHours) {
        this.weeklyWorkingHours = weeklyWorkingHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAnnualLeaveDays() {
        return annualLeaveDays;
    }

    public void setAnnualLeaveDays(int annualLeaveDays) {
        this.annualLeaveDays = annualLeaveDays;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
