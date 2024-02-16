import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
    private ArrayList<String> salidaArreglo;
    private String ruta = "textoSalida.txt";

    public Output(ArrayList lista){
        this.salidaArreglo= lista;
        salidaEnArchivo();
    }

    private void salidaEnArchivo(){
         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
            for (String linea : salidaArreglo) {
                writer.write(linea);
                writer.newLine(); // Agrega una nueva línea después de cada elemento
            }
            writer.close();
            System.out.println("El ArrayList se ha escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir el ArrayList en el archivo: " + e.getMessage());
        }
    }

}
