package com.example.api.entity;

import com.example.api.utils.PropertyUtil;

public class Constants {

    public static PropertyUtil propertyUtil = PropertyUtil.getInstance("project");
    
    public static String contextPath = propertyUtil.getProperty("contextPath");
}
