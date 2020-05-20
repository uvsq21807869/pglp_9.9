package uvsq.forme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uvsq.bean.Carre;
import uvsq.bean.Cercle;
import uvsq.bean.Point;

public class CercleTest {

	@Test
	public void testMove() {
		Cercle c1 = new Cercle("cercle", new Point(8, 0), 20);
		c1.move(3, 0);
		assertEquals(3, c1.getCentre().getX());
		assertEquals(0, c1.getCentre().getY());
	}
	
	@Test
	public void testDeplacerDirection() {
		Cercle car1 = new Cercle("cercle", new Point(11, 20), 5);
		car1.deplacerDirection(1, 1);
		assertEquals(12, car1.getCentre().getX());
		assertEquals(21, car1.getCentre().getY());
	}
}
