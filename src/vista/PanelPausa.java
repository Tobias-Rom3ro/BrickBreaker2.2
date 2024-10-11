package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPausa extends JPanel {

    private VentanaPrincipal ventana;

    public PanelPausa(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setLayout(new GridBagLayout()); // Para centrar los botones
        setBackground(new Color(0, 0, 0, 150)); // Fondo transparente para que se vea el juego detrás

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones

        // Botón para reanudar el juego
        JButton botonReanudar = new JButton("Reanudar Juego");
        botonReanudar.setPreferredSize(new Dimension(200, 50));
        botonReanudar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.getPanelJuego().reanudarJuego();
                ventana.getPanelJuego().requestFocusInWindow();
            }
        });

        // Botón para reiniciar el nivel
        JButton botonReiniciar = new JButton("Reiniciar Nivel");
        botonReiniciar.setPreferredSize(new Dimension(200, 50));
        botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reiniciar el nivel actual
                ventana.getPanelJuego().reiniciarNivel();
            }
        });

        // Botón para volver al menú principal
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.setPreferredSize(new Dimension(200, 50));
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarMenuPrincipal();
            }
        });

        // Añadir los botones al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(botonReanudar, gbc);

        gbc.gridy = 1;
        add(botonReiniciar, gbc);

        gbc.gridy = 2;
        add(botonMenuPrincipal, gbc);
    }
}
