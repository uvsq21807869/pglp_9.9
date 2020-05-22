package uvsq.forme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uvsq.bean.Carre;
import uvsq.bean.Groupe;
import uvsq.bean.Point;
import uvsq.bean.Rectangle;

public class GroupeTest {

	@Test
	public void testDeplacerDirection() {

		Groupe g1 = new Groupe("groupe");
		Carre c = new Carre("carre", new Point(0, 0), 16);
		Rectangle r = new Rectangle("rectangle", new Point(100, 0), 3, 8);
		g1.ajoutForme(r);
		g1.ajoutForme(c);

		g1.deplacerDirection(20, 20);
		assertTrue(c.getPointDOrigine().getX() == 20);
		assertTrue(c.getPointDOrigine().getY() == 20);
		assertTrue(r.getPointDOrigine().getX() == 120);
		assertTrue(r.getPointDOrigine().getY() == 20);
	}
}
