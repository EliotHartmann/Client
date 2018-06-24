package resource;

import java.util.ListResourceBundle;

public class resource_fi extends ListResourceBundle{

    private static final Object[][] contents = {
            {"Language", "suomalainen"},
            {"Age", "ikä"},
            {"Name", "nimi"},
            {"YELLOW", "keltainen"},
            {"GREEN", "vihreä"},
            {"BLUE", "sininen"},
            {"login", "Kirjaudu sisään"},
            {"check_error", "Virheellinen kirjautumis- ja salasanayhdistelmä"},
            {"start", "alkaa"},
            {"update", "päivittää"},
            {"password", "Salasana"},
            {"log in", "Kirjaudu sisään"},
            {"sign up", "Kirjaudu"},
            {"mainTitle", "asiakas"},
            {"loginTitle", "tulla sisään"},
            {"banMessage", "Olet kielletty palvelimelta"},
            {"successSignUpMessage", "Olet onnistuneesti rekisteröitynyt"},
            {"language", "Kieli"},
            {"message", "viesti"}

    };


    public Object[][] getContents(){
        return contents;
    }
}
