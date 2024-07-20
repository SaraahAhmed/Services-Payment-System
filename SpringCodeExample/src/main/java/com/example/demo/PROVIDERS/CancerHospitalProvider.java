package com.example.demo.PROVIDERS;

import java.util.Scanner;

public class CancerHospitalProvider extends ServiceProvider {

	@Override
	public void SP_form(String a, double c) {
		phoneNumber= a;
        amount= c;
	}

}