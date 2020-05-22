package uvsq.forme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uvsq.bean.Point;
import uvsq.bean.Rectangle;
import uvsq.bean.Triangle;

public class TriangleTest {

	@Test
	public void testMove() {

		Triangle t1 = new Triangle("t1", new Point(0, 0), new Point(2, 2), new Point(4, 4));
		t1.move(1, 1);
		assertEquals(t1.getPointA().getX(), 1);
		assertEquals(t1.getPointA().getY(), 1);
		assertEquals(t1.getPointB().getX(), 3);
		assertEquals(t1.getPointB().getY(), 3);
		assertEquals(t1.getPointC().getX(), 5);
		assertEquals(t1.getPointC().getY(), 5);
	}

	@Test
	public void testDeplacerDirection() {
		Triangle car1 = new Triangle("Triangle", new Point(11, 20), new Point(23, 56), new Point(100, 0));
		car1.deplacerDirection(1, 1);
		assertEquals(12, car1.getPointA().getX());
		assertEquals(21, car1.getPointA().getY());
		assertEquals(24, car1.getPointB().getX());
		assertEquals(48, car1.getPointB().getY());
		assertEquals(101, car1.getPointC().getX());
		assertEquals(-8, car1.getPointC().getY());

	}
}
