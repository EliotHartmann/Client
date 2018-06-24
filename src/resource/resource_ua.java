package resource;

import java.util.ListResourceBundle;

public class resource_ua extends ListResourceBundle{

    private static final Object[][] contents = {
            {"Language", "Український"},
            {"Age", "вік"},
            {"Name", "ім'я"},
            {"YELLOW", "жовтий"},
            {"GREEN", "зелений"},
            {"BLUE", "синій"},
            {"login", "логін"},
            {"check_error", "Невірна комбінація логін / пароль"},
            {"start", "Старт"},
            {"update", "оновити"},
            {"password", "Пароль"},
            {"log in", "Увійти"},
            {"sign up", "зареєструватися"},
            {"mainTitle", "клієнт"},
            {"loginTitle", "Вхід"},
            {"banMessage", "ви забанені на сервері"},
            {"successSignUpMessage", "Ви успішно зареєстровані"},
            {"language", "мова"},
            {"message", "повідомлення"},

    };


    public Object[][] getContents(){
        return contents;
    }
}
