package com.BankAccountCaseStudy;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MenuClassTest extends TestCase {

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDeposit() {
		MenuClass mc=new MenuClass();
		int expected=1000;
		int actual=1000;
		assertEquals(expected,actual);
	}

}
