package com.mycompany.encuestas_app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mycompany.encuestas_app.vistas.cuentas.IniciarSesionFrame;

public class Encuestas_App {

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        new IniciarSesionFrame().setVisible(true);
    }
}
