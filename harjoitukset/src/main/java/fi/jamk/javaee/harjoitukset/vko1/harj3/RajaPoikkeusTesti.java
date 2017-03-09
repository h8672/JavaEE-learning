package fi.jamk.javaee.harjoitukset.vko1.harj3;

public class RajaPoikkeusTesti {

    public static void main(String args[]) {
        try {
            Kokonaisluku v = new Kokonaisluku(100, 0, 500);
            v.tulosta();
            v.kerro(2);
            v.tulosta();
            //v.nelio();
            //v.tulosta();
            
            //Jako testit
            //v.jaa();
            v.jaa(0);
        } catch (RajaPoikkeus e) {
            System.out.print(e);
        } catch (JakoPoikkeus e){
        	System.out.print(e);
        }
    }
}
