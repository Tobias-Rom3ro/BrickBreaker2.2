package vista;

import utilities.Sonido;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelJuego panelJuego;
    private MenuPrincipal menuPrincipal;
    private MenuConfiguracion menuConfiguracion;
    private Sonido sonido;

    public VentanaPrincipal() {
        setTitle("Brick Breaker");
        setSize(800, 600); // Dimensiones de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setResizable(false); // No permitir cambiar el tamaño de la
        sonido = new Sonido("/resources/Sonido/sonidoFondoPrincipal.wav");
        sonido.reproducirEnBucle();

        // Inicializar paneles
        panelJuego = new PanelJuego();
        menuPrincipal = new MenuPrincipal(this);
        menuConfiguracion = new MenuConfiguracion(this, sonido);

        // Establecer el menú principal como vista inicial
        setContentPane(menuPrincipal);

        setVisible(true);
    }

    // Cambiar la vista al Panel de Juego
    public void iniciarJuego() {
        setContentPane(panelJuego);
        panelJuego.requestFocusInWindow(); // Para asegurarse de que se detecten eventos de teclado
        revalidate();
    }

    // Cambiar la vista al Menú Principal
    public void mostrarMenuPrincipal() {
        setContentPane(menuPrincipal);
        revalidate();
    }

    // Cambiar la vista a la Configuración
    public void mostrarMenuConfiguracion() {
        setContentPane(menuConfiguracion);
        MenuConfiguracion menuConfiguracion = new MenuConfiguracion(this, sonido);
        menuConfiguracion.actualizarFondo();
        revalidate();
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public MenuConfiguracion getMenuConfiguracion() {
        return menuConfiguracion;
    }

}
