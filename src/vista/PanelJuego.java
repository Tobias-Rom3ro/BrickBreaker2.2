package vista;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {

    private HUD hud;  // El HUD para mostrar la puntuación y las vidas
    private boolean enPausa;
    private PanelPausa panelPausa;
    private CardLayout layout;

    public PanelJuego() {
        this.hud = new HUD(3);  // Inicializar el HUD con 3 vidas
        this.enPausa = false;

        // Usar CardLayout para alternar entre el juego y la pausa
        layout = new CardLayout();
        setLayout(layout);

        // Panel de pausa
        panelPausa = new PanelPausa(null);  // Panel de pausa sin ventana aún asociada

        // Añadir los paneles (Juego y Pausa) al CardLayout
        add(panelPausa, "Pausa");

        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Si no está en pausa, dibujar el juego y el HUD
        if (!enPausa) {
            hud.dibujarHUD(g, getWidth());
        }
    }

    public void incrementarPuntuacion(int valor) {
        hud.incrementarPuntuacion(valor);
        repaint();
    }

    public void decrementarVidas() {
        hud.decrementarVidas();
        repaint();
    }

    public void reiniciarNivel() {
        // Reiniciar el nivel, incluyendo el HUD
        hud = new HUD(3); // Reiniciar vidas a 3
        enPausa = false;
        layout.show(this, "JuegoActivo"); // Mostrar el panel de juego
        repaint();
    }

    public void pausarJuego() {
        enPausa = true;
        layout.show(this, "Pausa"); // Mostrar el panel de pausa
    }

    public void reanudarJuego() {
        enPausa = false;
        layout.show(this, "JuegoActivo"); // Volver al panel de juego
        repaint();
    }
}