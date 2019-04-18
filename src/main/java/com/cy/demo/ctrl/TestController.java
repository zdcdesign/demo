package com.cy.demo.ctrl;

import com.cy.demo.dto.Student;
import com.cy.demo.service.imp.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "新增数据", notes = "新增数据")
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestBody Student student) {
        String s = testService.add(student);
        return s;
    }

}
