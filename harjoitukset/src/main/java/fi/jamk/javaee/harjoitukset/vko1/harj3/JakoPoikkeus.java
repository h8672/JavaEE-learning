package fi.jamk.javaee.harjoitukset.vko1.harj3;

public class JakoPoikkeus extends Exception{
	public JakoPoikkeus() {
        super("virhe! Ei jakajia");
    }
	public JakoPoikkeus(int a) {
        super("virhe! Koetit jakaa lukua luvulla " + a);
    }
}
