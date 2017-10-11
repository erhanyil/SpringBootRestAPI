package com.stdiosoft.restapi.dao;

import com.stdiosoft.restapi.model.Student;
import com.stdiosoft.restapi.response.ResultResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Student> get(){
		Session sf = sessionFactory.openSession();
		List<Student> list = sf.createCriteria(Student.class).list();
		sf.close();
		return list;
	}

	public Student get(Integer _id){
		Session sf = sessionFactory.openSession();
		List<Student> list = sf.createCriteria(Student.class).add(Restrictions.eq("id", _id)).list();
		sf.close();
		return list.size() != 0 ? list.get(0) : null;
	}

	public ResultResponse post(Student _student){
		Session sf = sessionFactory.openSession();
		sf.save(_student);
		sf.flush();
		sf.close();
		return new ResultResponse();
	}

	public ResultResponse put(Integer _id, Student _student){
		Session sf = sessionFactory.openSession();
		Student student = sf.get(Student.class,_id);
		student.setAddr(_student.getAddr());
		student.setCity(_student.getCity());
		student.setName(_student.getName());
		student.setPin(_student.getPin());
		sf.update(student);
		sf.flush();
		sf.close();
		return new ResultResponse(true,"New Record Saved");
	}

}
