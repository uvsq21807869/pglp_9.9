package uvsq.forme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import uvsq.bean.Carre;
import uvsq.bean.Point;

public class CarreTest {

	@Test
	public void testMove() {

		Carre car1 = new Carre("carre", new Point(11, 20), 5);
		car1.move(15, 15);
		assertEquals(15, car1.getPointDOrigine().getX());
		assertEquals(15, car1.getPointDOrigine().getY());
	}
	
	@Test
	public void testDeplacerDirection() {
		Carre car1 = new Carre("carre", new Point(11, 20), 5);
		car1.deplacerDirection(1, 1);
		assertEquals(12, car1.getPointDOrigine().getX());
		assertEquals(21, car1.getPointDOrigine().getY());
	}
}
