package com.example.api.controller;

public class BaseController {
    
    private static final String ADMIN_PAGE_PATH = "/adminend/";
    
    private static final String FRONT_PAGE_PATH = "/frontend/";

    public String getAdminView(String view) {
        return ADMIN_PAGE_PATH + view;
    }
}
