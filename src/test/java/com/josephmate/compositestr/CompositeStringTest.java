package com.josephmate.compositestr;

import org.junit.Assert;
import org.junit.Test;

public class CompositeStringTest {
	
	@Test
	public void testConcat() {
		CompositeString str = new CompositeString("first");
		MemoryReuseString concattedStr = str.concat("second");
		MemoryReuseString concatAgain = concattedStr.concat("third");
		

		CompositeString fourth = new CompositeString("fourth");
		MemoryReuseString fifth = fourth.concat("fifth");
		MemoryReuseString sixth = fifth.concat("sixth");

		Assert.assertEquals("firstsecond", concattedStr.toString());
		Assert.assertEquals("firstsecondthird", concatAgain.toString());
		Assert.assertEquals("firstsecondthirdfourthfifthsixth", concatAgain.concat(sixth).toString());
		
	}
	
}
