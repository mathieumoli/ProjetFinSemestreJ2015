package zuul;

/**
 * A class randomly generating an advertisement, when the player is in the foyer
 * and uses the command "see ads".
 * 
 * To add an ad, you must declare a new adx, and add it to allAds.
 * @author user
 *
 */
public class Advertisement {
    private String ad1 = "advertisement.ad1";
    private String ad2 = "advertisement.ad2";
    private String ad3 = "advertisement.ad3";
    private String ad4 = "advertisement.ad4";
    private String [] allAds = {ad1, ad2, ad3, ad4};
    // used to know what ad was already printed
    private int numeroAnnonce;
    
    public Advertisement() {
        numeroAnnonce = 0;
    }
    
    /**
     * A class printing a new ad, following the ones printed before.
     * An ad can only be printed once.
     * If there's no ad left, it's just as if the board was empty.
     */
    public void displayNewAd() {
        if (numeroAnnonce < allAds.length) {
            Display.displayln(allAds[numeroAnnonce]);
        } else {
        	Display.displayln("Il n'y a plus d'annonces.");
        }
        numeroAnnonce++;
    }
}
