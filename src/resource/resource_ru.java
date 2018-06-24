package resource;

import java.util.ListResourceBundle;

public class resource_ru extends ListResourceBundle{

    private static final Object[][] contents = {
            {"Language", "Русский"},
            {"Age", "Возраст"},
            {"Name", "Имя"},
            {"YELLOW", "Желтый"},
            {"GREEN", "Зеленый"},
            {"BLUE", "Синий"},
            {"login", "Логин"},
            {"check_error", "Неверная комбинация логин/пароль"},
            {"start", "Старт"},
            {"update", "Обновить"},
            {"password", "Пароль"},
            {"log in", "Войти"},
            {"sign up", "Зарегестрироваться"},
            {"mainTitle", "Клиент"},
            {"loginTitle", "Вход"},
            {"banMessage", "Вы забанены на сервере"},
            {"successSignUpMessage", "Вы успешно зарегестрированы"},
            {"language", "Язык"},
            {"message", "Сообщение"}

    };


    public Object[][] getContents(){
        return contents;
    }
}
