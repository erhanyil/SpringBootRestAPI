package com.stdiosoft.restapi.controller;

import com.stdiosoft.restapi.model.Student;
import com.stdiosoft.restapi.dao.StudentDAO;
import com.stdiosoft.restapi.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
    StudentDAO studentDAO;

    //region GET METHOD
    @RequestMapping(value = "/get/", method = RequestMethod.GET)
    public List<Student> get() {
        return studentDAO.get();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Student get(@PathVariable("id") Integer id) {
        return studentDAO.get(id);
    }
    //endregion

    //region POST METHOD (CRATE)
	@RequestMapping(value = "/post/", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse post(@RequestBody Student student) {
		return studentDAO.post(student);
	}
	//endregion

    //region PUT METHOD (UPDATE)
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultResponse put(@PathVariable("id") Integer id, @RequestBody Student student) {
        return studentDAO.put(id,student);
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