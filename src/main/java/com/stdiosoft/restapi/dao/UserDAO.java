package com.stdiosoft.restapi.dao;

import com.stdiosoft.restapi.model.Student;
import com.stdiosoft.restapi.model.User;
import com.stdiosoft.restapi.response.ResultResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> get(){
		Session sf = sessionFactory.openSession();
		List<User> list = sf.createCriteria(User.class).list();
		sf.close();
		return list;
	}

	public User get(Integer _id){
		Session sf = sessionFactory.openSession();
		List<User> list = sf.createCriteria(User.class).add(Restrictions.eq("id", _id)).list();
		sf.close();
		return list.size() != 0 ? list.get(0) : null;
	}

	public ResultResponse post(User _user){
		Session sf = sessionFactory.openSession();
		sf.save(_user);
		sf.flush();
		sf.close();
		return new ResultResponse();
	}

	public ResultResponse put(Integer _id, User _user){
		Session sf = sessionFactory.openSession();
		User user = sf.get(User.class,_id);
		user.setId(_user.getId());
		user.setAge(_user.getAge());
		user.setName(_user.getName());
		user.setSalary(_user.getSalary());
		sf.update(user);
		sf.flush();
		sf.close();
		return new ResultResponse(true,"New Record Saved");
	}

}
