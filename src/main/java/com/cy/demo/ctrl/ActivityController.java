package com.cy.demo.ctrl;

import com.cy.demo.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhoudachao on 2019/5/16.
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService iActivityService;


}
