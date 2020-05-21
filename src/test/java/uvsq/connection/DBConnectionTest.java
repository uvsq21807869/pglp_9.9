package uvsq.connection;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq.connection.DBConnection;

public class DBConnectionTest {

	@Test
	public void testconnection() {

		assertTrue(DBConnection.getInstance()!=null);
	}

}
