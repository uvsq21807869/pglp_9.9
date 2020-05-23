package uvsq.application;

import uvsq.commande.Command;
import uvsq.commande.DrawingTui;
import uvsq.connection.Database;

public class DrawingApp {

	private DrawingTui draw;
	private Command command;

	/**
	 * Application qui lance le système de dessin et crée la base de données si
	 * necessaire .
	 */
	public DrawingApp() {
		Database database = new Database();
		database.creatDatabase();
		this.draw = new DrawingTui();
	}

	/**
	 * Exécute les commandes envoyées par l'interface utilisateur.
	 */
	public void run() {

		while (true) {
			command = this.draw.nextCommand();
			try {
				command.execute();
			} catch (NullPointerException e) {}
			this.draw.afficherDessin();
		}
	}

	public static void main(String[] args) {

		DrawingApp app = new DrawingApp();
		app.run();
	}
}
