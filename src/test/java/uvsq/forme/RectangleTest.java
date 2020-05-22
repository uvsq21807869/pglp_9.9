package uvsq.forme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uvsq.bean.Cercle;
import uvsq.bean.Point;
import uvsq.bean.Rectangle;

public class RectangleTest {

	@Test
	public void testMove() {

		Rectangle r1 = new Rectangle("r1", new Point(7, 20), 20, 10);
		r1.move(7, 5);
		assertEquals(r1.getPointDOrigine().getPosition(), "(7, 5)");
	}

	@Test
	public void testDeplacerDirection() {
		Rectangle car1 = new Rectangle("rectangle", new Point(11, 20), 5, 6);
		car1.deplacerDirection(1, 1);
		assertEquals(12, car1.getPointDOrigine().getX());
		assertEquals(21, car1.getPointDOrigine().getY());
	}
}
