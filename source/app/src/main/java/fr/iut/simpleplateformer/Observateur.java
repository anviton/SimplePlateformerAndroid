package fr.iut.simpleplateformer;

import fr.iut.simpleplateformer.modele.BoucleAbstraite;

public abstract class Observateur {

    BoucleAbstraite boucle;

    public abstract void mettreAJour();
}
