package vista;

import java.awt.*;

public class HUD {

    private int puntuacion;
    private int vidas;

    public HUD(int vidasIniciales) {
        this.puntuacion = 0;
        this.vidas = vidasIniciales;
    }

    public void incrementarPuntuacion(int valor) {
        puntuacion += valor;
    }

    public void decrementarVidas() {
        vidas--;
    }

    public void dibujarHUD(Graphics g, int anchoPantalla) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));

        // Dibujar la puntuación
        g.drawString("Puntuación: " + puntuacion, 20, 30);

        // Dibujar las vidas restantes
        g.drawString("Vidas: " + vidas, anchoPantalla - 100, 30);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
