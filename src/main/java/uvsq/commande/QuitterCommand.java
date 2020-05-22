package uvsq.commande;

import static java.lang.System.exit;

import uvsq.connection.DBConnection;

public class QuitterCommand implements Command {

	public QuitterCommand() {
	}

	/** Ferme le programme. */
	@Override
	public void execute() {
		DBConnection.close();
		exit(0);
	}
}
