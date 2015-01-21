package zuul.foundobject;

// TODO internationnalisation

// ATTENTION, emplacement temporaire, cette classe n'hérite pas de FoundObject!

/**
 * A class randomly generating an advertisement, when the player is in the foyer
 * and uses the command "see ads".
 * @author user
 *
 */
public class Advertisement {
    private String ad1 = "...don du sang le moi prochain ...";
    private String ad2 = "...la BU sera exceptionellement fermée lundi, mardi, mercredi, jeudi et vendredi prochains...";
    private String ad3 = "...vendredi soir, soirée BDE à Nice...";
    private String ad4 = "...forum des métiers la semaine prochaine...";
    private String [] allAds = {ad1, ad2, ad3, ad4};
    // useful to know what ad was already printed
    private int numeroAnnonce;
    
    public Advertisement() {
        numeroAnnonce = 0;
    }
    
    /**
     * A class printing a new ad, followinf the ones printed before.
     * An ad can only be printed once.
     * If there's no ad left, it's just as if the board was empty.
     */
    public void displayNewAd() {
        if (numeroAnnonce < allAds.length) {
            System.out.println(allAds[numeroAnnonce]);
        } else {
        	System.out.println("Il n'y a plus d'annonces.");
        }
        numeroAnnonce++;
    }
}
