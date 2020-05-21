package uvsq.connection;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq.connection.Database;

public class DatabaseTest {

	@Test
	public void test() {
		Database db=new Database();
		assertTrue(db.creatDatabase());
		
	}

}
