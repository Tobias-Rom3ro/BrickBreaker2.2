package utilities;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Recursos {

    // Método para cargar una imagen desde la ruta especificada
    public static Image cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para cargar un sonido
    public static Sonido cargarSonido(String ruta) {
        return new Sonido(ruta);
    }
}
