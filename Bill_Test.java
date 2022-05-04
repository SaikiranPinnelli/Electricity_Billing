package Electricity_Billing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Bill_Test {
	@Test
	public void check_Admin() throws Exception{
		act = ElectricityBillingSystem.test();
			act=act.toLowerCase();
			//if(act.equals("admin")==true)
			assertEquals("admin",act);
		
	}
}
