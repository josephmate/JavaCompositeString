package com.josephmate.compositestr;

import org.junit.Assert;
import org.junit.Test;

public class CompositeStringTest {

	CompositeString emptyWithOne = new CompositeString("");
	MemoryReuseString emptyWithTwo = emptyWithOne.concat("");
	MemoryReuseString emptyWithFour = emptyWithTwo.concat(emptyWithTwo.concat(""));
	
	CompositeString first = new CompositeString("first");
	MemoryReuseString second = first.concat("second");
	MemoryReuseString third = second.concat("third");
	
	CompositeString fourth = new CompositeString("fourth");
	MemoryReuseString fifth = fourth.concat("fifth");
	MemoryReuseString sixth = third.concat(fifth.concat("sixth"));
	
	@Test
	public void testConcat() {
		Assert.assertEquals("firstsecond", second.toString());
		Assert.assertEquals("firstsecondthird", third.toString());
		Assert.assertEquals("firstsecondthirdfourthfifthsixth", sixth.toString());
	}
	
	@Test
	public void testLength() {
		Assert.assertEquals("firstsecond".length(), second.length());
		Assert.assertEquals("firstsecondthird".length(), third.length());
		Assert.assertEquals("firstsecondthirdfourthfifthsixth".length(), sixth.length());
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, second.isEmpty());
		Assert.assertEquals(false, third.isEmpty());
		Assert.assertEquals(false, sixth.isEmpty());
		Assert.assertEquals(true, emptyWithOne.isEmpty());
		Assert.assertEquals(true, emptyWithTwo.isEmpty());
		Assert.assertEquals(true, emptyWithFour.isEmpty());
	}
	
	@Test
	public void testCharAt() {
		for(int i = 0; i < "firstsecondthirdfourthfifthsixth".length(); i++) {
			Assert.assertEquals("firstsecondthirdfourthfifthsixth".charAt(i), sixth.charAt(i));
		}
	}
	
}
