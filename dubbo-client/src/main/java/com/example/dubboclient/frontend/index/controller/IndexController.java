package com.example.dubboclient.frontend.index.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.controller.BaseController;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

}