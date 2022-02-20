package com.example.numbers.service.impl;

import org.springframework.stereotype.Service;

import com.example.numbers.service.AddNumberService;

@Service
public class AddNumberServiceImpl implements AddNumberService {
			
	public int addNumbers(String numbers) {
		String[] numbersArray = numbers.split(",");
		int total = 0;
		for(String number : numbersArray) {
			total += Integer.parseInt(number);
		}
		return total;
	}
}
