package com.example.numbers.service.impl;

import java.util.ArrayList;
import java.util.List;
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
		int total = add(numbersArray);
		return total;
	}

	private int add(String[] numbersArray) {
		int total = 0;
		List<Integer> negativeNumbers = new ArrayList<>();
		if (Objects.nonNull(numbersArray) && numbersArray.length > 0) {
			for (String number : numbersArray) {
				try {
					int value = Integer.parseInt(number);
					total += value;
					if (value < 0) {
						negativeNumbers.add(value);
					}

				} catch (NumberFormatException e) {
					throw new InvalidInputException("Expected Number received Character :" + number, e);
				}
			}
			if (!negativeNumbers.isEmpty()) {
				throw new InvalidInputException("Negatives not allowed :" + negativeNumbers.toString());
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
