package resource;

import java.util.ListResourceBundle;

public class resource_en extends ListResourceBundle{

    private static final Object[][] contents = {
            {"Language", "Language"},
            {"Name", "Name"},
            {"YELLOW", "YELLOW"},
            {"GREEN", "GREEN"},
            {"BLUE", "BLUE"},
            {"login", "login"},
            {"check_error", "Invalid log/pass combination"},
            {"start", "start"},
            {"update", "update"},
            {"password", "password"},
            {"log in", "log in"},
            {"sign up", "sign up"},
            {"mainTitle", "Client GUI"},
            {"loginTitle", "Enter log/pass"},
            {"banMessage", "You are permanently banned on this server"},
            {"successSignUpMessage", "You successfully signed up"},
            {"language", "language"},

    };


    public Object[][] getContents(){
        return contents;
    }
}
