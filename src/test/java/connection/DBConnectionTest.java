package connection;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBConnectionTest {

	@Test
	public void testconnection() {

		assertTrue(DBConnection.getInstance()!=null);
	}

}
