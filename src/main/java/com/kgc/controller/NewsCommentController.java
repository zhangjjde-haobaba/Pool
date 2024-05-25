package com.kgc.controller;


import com.kgc.entity.NewsComment;
import com.kgc.service.NewsCommentService;
import com.kgc.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-09-10
 */
@RestController
@RequestMapping("/newsComment")
public class NewsCommentController {

    @Autowired
    private NewsCommentService newsCommentService;


    @GetMapping("/list")
    public Result list(){
        List<NewsComment> list = this.newsCommentService.list();
        return Result.ok().put("data",list);
    }

}

