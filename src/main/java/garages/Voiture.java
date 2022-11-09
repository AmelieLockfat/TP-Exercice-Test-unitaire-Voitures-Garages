package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();


	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		if (myStationnements.size() >0){
		int index = myStationnements.size()- 1;
		Stationnement DernierStationnement= myStationnements.get(index)	;
		if (DernierStationnement.getFin()!=null){
		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);}
		else {
			throw new IllegalArgumentException("Véhicule déjà dans un garage");}}
		else {Stationnement s = new Stationnement(this, g);
				myStationnements.add(s);
		}}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage()  {
		int index = myStationnements.size()- 1;
		Stationnement DernierStationnement= myStationnements.get(index)	;
		if (DernierStationnement.getFin()==null){
			DernierStationnement.setFin();
		}
		else {
			throw new IllegalArgumentException("Véhicule déjà sorti");
		}

	}
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */

public Set<Garage> garagesVisites(){
		Set<Garage> gvisites = new HashSet<Garage>() ;
		for (Stationnement s : myStationnements){
			gvisites.add(s.getGarage());
			}
		return gvisites;
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		boolean test = false ;
		if (myStationnements.size() > 0) {
			int index = myStationnements.size() - 1;
			Stationnement DStat = myStationnements.get(index);
			if (DStat.estEnCours()){
				test=true;
		}
	}
	return test;}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		for (Garage g : garagesVisites()){
			String nom = g.getName();
			out.println(nom);
			for (Stationnement s : myStationnements){
				if (nom.equals(s.getGarage())){
				out.println(s.toString());
					}
		}
	}
	}
}
