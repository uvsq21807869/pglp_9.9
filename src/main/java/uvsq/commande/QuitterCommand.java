package uvsq.commande;

import static java.lang.System.exit;

import uvsq.connection.DBConnection;

public class QuitterCommand implements Command {

	public QuitterCommand() {
	}

	/** la fermeture de la bd et l'arret de l'application */
	@Override
	public void execute() {
		DBConnection.close();
		exit(0);
	}
}
