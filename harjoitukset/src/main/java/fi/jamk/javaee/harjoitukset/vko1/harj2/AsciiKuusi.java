package fi.jamk.javaee.harjoitukset.vko1.harj2;

/* 
 Mallivastaus:
  
 Toiminta:
 for-silmukoiden käyttä!

 Tulostaa joulukuusen rungo-osan:
 *
 ***
 *****
 *******
 *********
 ***
 ***
 *****
 Joulukuusi on tässä tulostettu suht. monimutkaisesti,
 mutta esimerkissä onkin panostettu parametrisointiin!
 Kaikki muutettavat arvot ovat luokan vakioina
 */
public class AsciiKuusi {

    // Vakioiden määrittely
    static final int MAX_LEVEYS = 43, // kuusen maksimileveys
            RUNGON_KORKEUS = 5, // rungo-osan korkeus
            RUNGON_LEVEYS = 3, // runko-osan leveys
            JALAN_LEVEYS = 5;   // jalka-osan leveys
    
    //Privaatit metodit
    private static void Oksat(boolean... suunta){
    	//Jos suunta käännetään
    	if(suunta.length > 0 && suunta[0] == false){
	        for (int i = MAX_LEVEYS; i > 0; i = i - 2) {
	            int alkukohta = (MAX_LEVEYS - i) / 2;
	            for (int k = 1; k <= alkukohta; k++) // tulostetaan tyhjät
	            {
	                System.out.print(" ");
	            }
	            for (int j = 1; j <= i; j++) // tulostetaan "oksat"
	            {
	                System.out.print("*");
	            }
	            System.out.print("\n");
	        }
    	}
    	//Tavallinen suunta
    	else {
    		for (int i = 1; i <= MAX_LEVEYS; i = i + 2) {
	            int alkukohta = (MAX_LEVEYS - i) / 2;
	            for (int k = 1; k <= alkukohta; k++) // tulostetaan tyhjät
	            {
	                System.out.print(" ");
	            }
	            for (int j = 1; j <= i; j++) // tulostetaan "oksat"
	            {
	                System.out.print("*");
	            }
	            System.out.print("\n");
	        }
    	}
    	
    }

    private static void Runko(boolean... suunta){
    	//Jos suunta käännetään ja joskus funktiota muutetaan...
    	if(suunta.length > 0 && suunta[0] == false){
        	for (int i = RUNGON_KORKEUS; i > 0; i--) {
                int alkukohta = (MAX_LEVEYS - RUNGON_LEVEYS) / 2;
                for (int k = 1; k <= alkukohta; k++) // tulostetaan tyhjät
                {
                    System.out.print(" ");
                }
                for (int j = 1; j <= RUNGON_LEVEYS; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
    	}
    	//Tavallinen suunta
    	else {
        	for (int i = 1; i <= RUNGON_KORKEUS; i++) {
                int alkukohta = (MAX_LEVEYS - RUNGON_LEVEYS) / 2;
                for (int k = 1; k <= alkukohta; k++) // tulostetaan tyhjät
                {
                    System.out.print(" ");
                }
                for (int j = 1; j <= RUNGON_LEVEYS; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
    		
    	}
    }

    private static void Jalka(boolean... suunta){
    	//Ei oikeen saa muutettua suuntaa tällä :D
    	int alkukohta = (MAX_LEVEYS - JALAN_LEVEYS) / 2;
        for (int k = 1; k <= alkukohta; k++) // tulostetaan tyhjät
        {
            System.out.print(" ");
        }
        for (int p = 1; p <= JALAN_LEVEYS; p++) {
            System.out.print("*");
        }
        //Fixasin, lisäsin välin jos haluu osien paikkaa vaihtaa
        System.out.println();
    }

    private static void Puu(int... suunta){
    	if(suunta.length > 0 && suunta[0] == 1){
            // Tulostetaan kuusi väärinpäin
    		Jalka(false);
            Runko(false);
        	Oksat(false);
    	}
    	if(suunta.length > 0 && suunta[0] == 2){
            // Tulostetaan kuusi väärinpäin
    		Runko(false);
    		Jalka(false);
        	Oksat(false);
    	}
    	else {
            // Tulostetaan kuusi oikeinpäin
        	Oksat();
            Runko();
            Jalka();
    	}
    }
    
    //Pääohjelma
    public static void main(String argumentit[]) {
    	Puu(2, 3);
    } // pääohjelma loppuu
}
