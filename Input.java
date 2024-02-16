import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input extends Thread {
    String Ruta = "texto.txt";
    private Tube salida;

   
    public Input(Tube salida) {
        this.salida = salida;
    }

    @Override
    public void run() {

        try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){
            String s;
            while((s = bf.readLine())!=null) {
                System.out.println(s);
                salida.addInformacion(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        salida.setConexion(false);
        
        /*Esto se puede borrar.
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-Input en Standby");
        }
        */
    }
}
