package com.example.demo.service;


public class SearchService {  //assume search is creation class no need to create
    public static  Service searchService(String val){
        return ServiceControl.getServices().get(val);

    }

}
