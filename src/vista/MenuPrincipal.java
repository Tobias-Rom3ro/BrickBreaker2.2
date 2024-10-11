package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JPanel {

    private VentanaPrincipal ventana;

    public MenuPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones

        // Botón para iniciar el juego
        JButton botonIniciar = new JButton("Iniciar Juego");
        botonIniciar.setPreferredSize(new Dimension(200, 50));
        botonIniciar.addActionListener(e -> ventana.iniciarJuego());

        // Botón para ir a la configuración
        JButton botonConfiguracion = new JButton("Configuración");
        botonConfiguracion.setPreferredSize(new Dimension(200, 50));
        botonConfiguracion.addActionListener(e -> ventana.mostrarMenuConfiguracion());

        // Añadir botones al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(botonIniciar, gbc);

        gbc.gridy = 1;
        add(botonConfiguracion, gbc);
    }
}
