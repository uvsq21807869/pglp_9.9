package connection;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void test() {
		Database db=new Database();
		assertTrue(db.creatDatabase());
		
	}

}
