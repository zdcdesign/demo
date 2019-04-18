package com.cy.demo.service.imp;

import com.cy.demo.mapper.StudentMapper;
import com.cy.demo.dto.Student;
import com.cy.demo.entity.StudentEo;
import com.cy.demo.service.ITestService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService implements ITestService {

    @Resource
    private StudentMapper mapper;

    @Override
    public String add(Student student) {
        StudentEo eo = new StudentEo();
        BeanUtils.copyProperties(student, eo);
//        mapper.add(eo);
        int insert = mapper.insert(eo);

        //----随便返回点什么
        return insert + "";
    }

}
