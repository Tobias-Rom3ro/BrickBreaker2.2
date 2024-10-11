package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utilities.Sonido;

public class MenuConfiguracion extends JPanel {

    private VentanaPrincipal ventana;
    private JSlider sliderVolumen;
    private Sonido Sonido;

    public MenuConfiguracion(VentanaPrincipal ventana, Sonido sonido) {
        this.ventana = ventana;
        this.Sonido = sonido;

        // Configuramos el layout del panel
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 150));  // Fondo negro con transparencia
        configurarComponentes();  // Configuramos los componentes
    }

    // Método para configurar los componentes del panel
    private void configurarComponentes() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaciado entre componentes

        // Etiqueta superior "Ajustes"
        JLabel etiquetaAjustes = new JLabel("Ajustes");
        etiquetaAjustes.setForeground(Color.WHITE);  // Texto en blanco
        etiquetaAjustes.setFont(new Font("Arial", Font.BOLD, 24));  // Tamaño de fuente grande
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;  // Centrar el título
        add(etiquetaAjustes, gbc);

        // Etiqueta "Volumen de Fondo"
        JLabel etiquetaVolumen = new JLabel("Volumen de Fondo:");
        etiquetaVolumen.setForeground(Color.WHITE);  // Texto en blanco
        etiquetaVolumen.setFont(new Font("Arial", Font.BOLD, 18));  // Tamaño de fuente medio
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(etiquetaVolumen, gbc);

        // Deslizador de volumen personalizado
        sliderVolumen = new JSlider(0, 100, (int) (Sonido.getVolumen()));
        sliderVolumen.setPreferredSize(new Dimension(200, 50));
        sliderVolumen.setBackground(Color.BLACK);  // Fondo del slider negro
        sliderVolumen.setForeground(Color.WHITE);  // Color del texto en el slider
        sliderVolumen.setPaintTicks(true);  // Mostrar marcas en el slider
        sliderVolumen.setMajorTickSpacing(10);  // Separación de ticks
        sliderVolumen.setUI(new CustomSliderUI(sliderVolumen));  // Estilo personalizado
        sliderVolumen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Sonido.setVolumen(sliderVolumen.getValue());
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(sliderVolumen, gbc);

        // Botón para "Volver al Menú Principal"
        JButton botonMenuPrincipal = new JButton("Volver al Menú Principal");
        personalizarBoton(botonMenuPrincipal);  // Aplicar el estilo personalizado al botón
        botonMenuPrincipal.addActionListener(e -> ventana.mostrarMenuPrincipal());

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botonMenuPrincipal, gbc);
    }

    // Método para personalizar botones
    private void personalizarBoton(JButton boton) {
        boton.setPreferredSize(new Dimension(200, 40));
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.setFocusPainted(false);  // Sin borde de enfoque
        boton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));  // Borde verde brillante
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));  // Cambiar a magenta al pasar el mouse
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));  // Volver a verde cuando se quita el mouse
            }
        });
    }

    // Clase personalizada para el estilo del deslizador
    class CustomSliderUI extends javax.swing.plaf.basic.BasicSliderUI {

        public CustomSliderUI(JSlider b) {
            super(b);
        }

        @Override
        public void paintTrack(Graphics g) {
            g.setColor(Color.WHITE);  // Color blanco para la pista
            super.paintTrack(g);
        }

        @Override
        public void paintThumb(Graphics g) {
            g.setColor(Color.WHITE);  // Color blanco para el deslizador
            g.fillRect(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
        }

        @Override
        public void paintTicks(Graphics g) {
            g.setColor(Color.LIGHT_GRAY);  // Color gris claro para las marcas
            super.paintTicks(g);
        }
    }

    public void actualizarFondo() {
        setBackground(new Color(0, 0, 0, 150));  // Fondo semitransparente
        revalidate();  // Asegura que se actualicen los componentes visuales
        repaint();     // Redibuja el panel con el fondo actualizado
    }

}
