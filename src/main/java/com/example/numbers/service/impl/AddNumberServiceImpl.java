package com.example.numbers.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.exception.InvalidInputException;
import com.example.numbers.service.AddNumberService;

@Service
public class AddNumberServiceImpl implements AddNumberService {

	public int addNumbers(String numbers) {
		if (Objects.isNull(numbers) || numbers.length() == 0) {
			return 0;
		}
		String[] numbersArray = getNumbersFromString(numbers);
		int total = 0;
		if (Objects.nonNull(numbersArray) && numbersArray.length > 0) {
			for (String number : numbersArray) {
				try {
					total += Integer.parseInt(number);
				} catch (NumberFormatException e) {
					throw new InvalidInputException("Expected Number received Character :" + number, e);
				}
			}
		}
		return total;
	}

	private String[] getNumbersFromString(String numbers) {
		String delimiter = ",";
		if (numbers.contains("//")) {
			StringBuilder customDelimiter = new StringBuilder();
			int i = 0;
			for (i = 2; i < numbers.length(); i++) {
				if (numbers.charAt(i) == '\n') {
					break;
				}
				customDelimiter = customDelimiter.append(numbers.charAt(i));
			}
			numbers = numbers.substring(i + 1);
			numbers = numbers.replace(customDelimiter.toString(), delimiter);
			return numbers.split(delimiter);
		} else {
			numbers = numbers.replace("\n", delimiter);
			return numbers.split(delimiter);
		}
	}
}
