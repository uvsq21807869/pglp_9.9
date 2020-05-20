package uvsq.bean;

public abstract class Forme extends Graphic {

	public Forme(String nom) {
		super(nom);
	}

	public abstract void move(int x, int y);
}
