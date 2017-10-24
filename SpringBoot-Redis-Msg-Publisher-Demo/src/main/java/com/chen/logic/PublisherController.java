package com.chen.logic;

import com.chen.logic.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 * @author 陈梓平
 * @date 2017/10/24.
 */
@RestController
@RequestMapping
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "pub/{id}")
    public String pubMsg(@PathVariable String id){
        return publisherService.pubMsg(id);
    }
}
