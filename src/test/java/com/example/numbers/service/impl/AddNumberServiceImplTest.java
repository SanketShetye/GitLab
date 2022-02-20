package com.example.numbers.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AddNumberServiceImplTest {
	@InjectMocks
	AddNumberServiceImpl addNumberServiceImpl;
	
	@Test
	public void testAddNumberBasic() {
		int total = addNumberServiceImpl.addNumbers("4,5");
		Assert.assertEquals(9,total);
	}
}
