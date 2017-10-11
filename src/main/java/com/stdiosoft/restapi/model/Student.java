package com.stdiosoft.restapi.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students")
public class Student implements Serializable{

    //region COLUMNS
    @Id
    @Column(name="student_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="city", nullable=false)
    private String city;

    @Column(name="addr", nullable=false)
    private String addr;

    @Column(name="pin", nullable=false)
    private String pin;
    //endregion

	//region GET - SET METHODS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	//endregion

}
