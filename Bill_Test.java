package ElectricityBillSystem.Bill;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Bill_Test {
	@Test
	public void check_password() throws Exception{
		String act="Guddu@1234";
		assertEquals(act,User.check_password());
	}
}
