package fr.iut.simpleplateformer;

import fr.iut.simpleplateformer.modele.BoucleAbstraite;

public abstract class Observateur {

    protected BoucleAbstraite boucle;

    public abstract void mettreAJour();
}
