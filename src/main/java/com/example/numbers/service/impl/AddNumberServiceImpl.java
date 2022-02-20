package com.example.numbers.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.numbers.service.AddNumberService;

@Service
public class AddNumberServiceImpl implements AddNumberService {

	public int addNumbers(String numbers) {
		if(Objects.isNull(numbers) || numbers.length()==0) {
			return 0;
		}
		String[] numbersArray = numbers.split(",");
		int total = 0;
		if (Objects.nonNull(numbersArray) && numbersArray.length > 0) {
			for (String number : numbersArray) {
				total += Integer.parseInt(number);
			}
		}
		return total;
	}
}
