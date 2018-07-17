package com.example.api.controller;

public class BaseController {
    
    private static final String ADMIN_PAGE_PATH = "/adminend/";

    public String getAdminView(String view) {
        return ADMIN_PAGE_PATH + view;
    }
}
