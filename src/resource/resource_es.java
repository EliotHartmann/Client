package resource;

import java.util.ListResourceBundle;

public class resource_es extends ListResourceBundle{

    private static final Object[][] contents = {
            {"Language", "Español"},
            {"Age", "edad"},
            {"Name", "Nombre"},
            {"YELLOW", "amarillo"},
            {"GREEN", "verde"},
            {"BLUE", "azul"},
            {"login", "iniciar sesión"},
            {"check_error", "Combinación incorrecta de inicio de sesión / contraseña"},
            {"start", "comenzar"},
            {"update", "actualizar"},
            {"password", "contraseña"},
            {"log in", "iniciar sesión"},
            {"sign up", "Regístrate"},
            {"mainTitle", "Cliente"},
            {"loginTitle", "Iniciar sesión"},
            {"banMessage", "Estás prohibido del servidor"},
            {"successSignUpMessage", "Usted se ha registrado exitosamente"},
            {"language", "Idioma"},
            {"message", "mensaje"}

    };


    public Object[][] getContents(){
        return contents;
    }
}
