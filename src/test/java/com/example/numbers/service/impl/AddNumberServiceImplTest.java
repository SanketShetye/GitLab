package com.example.numbers.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.exception.InvalidInputException;


@RunWith(MockitoJUnitRunner.class)
public class AddNumberServiceImplTest {
	@InjectMocks
	AddNumberServiceImpl addNumberServiceImpl;
	
	@Test
	public void testAddNumberBasic() {
		int total = addNumberServiceImpl.addNumbers("4,5");
		Assert.assertEquals(9,total);
	}
	
	@Test
	public void testAddNumberBlankValue() {
		int total = addNumberServiceImpl.addNumbers("");
		Assert.assertEquals(0,total);
	}

	@Test
	public void testAddNumberOneValue() {
		int total = addNumberServiceImpl.addNumbers("1");
		Assert.assertEquals(1,total);
	}
	
	@Test
	public void testAddNumberNullValue() {
		int total = addNumberServiceImpl.addNumbers(null);
		Assert.assertEquals(0,total);
	}

	@Test(expected=InvalidInputException.class)
	public void testAddNumberCharValue() {
		addNumberServiceImpl.addNumbers("a,b");
	}

	@Test
	public void testAddNumberMultipleValues() {
		int total = addNumberServiceImpl.addNumbers("4,5,1,5");
		Assert.assertEquals(15,total);
	}

	@Test
	public void testAddNumberMultipleValues2() {
		int total = addNumberServiceImpl.addNumbers("4,5,11,45");
		Assert.assertEquals(65,total);
	}

	@Test
	public void testAddNumberNewLine() {
		int total = addNumberServiceImpl.addNumbers("4\n5,11\n45");
		Assert.assertEquals(65,total);
	}
}
