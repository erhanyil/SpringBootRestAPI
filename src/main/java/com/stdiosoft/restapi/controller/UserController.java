package com.stdiosoft.restapi.controller;

import com.stdiosoft.restapi.model.User;
import com.stdiosoft.restapi.dao.UserDAO;
import com.stdiosoft.restapi.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDAO userDAO;

	//region GET METHOD
	@RequestMapping(value = "/get/", method = RequestMethod.GET)
	public List<User> get() {
		return userDAO.get();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") Integer id) {
		return userDAO.get(id);
	}
	//endregion

	//region POST METHOD (CRATE)
	@RequestMapping(value = "/post/", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse post(@RequestBody User user) {
		return userDAO.post(user);
	}
	//endregion

	//region PUT METHOD (UPDATE)
	@RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResultResponse put(@PathVariable("id") Integer id, @RequestBody User user) {
		return userDAO.put(id,user);
	}
	//endregion

	//region DELETE METHOD
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultResponse delete(@PathVariable("id") Integer id) {
		return new ResultResponse();
	}

	@RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultResponse delete() {
		return new ResultResponse();
	}
	//endregion
}