import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sort extends Thread {
    private Tube entrada; 
    private ArrayList<String> salidaA = new ArrayList<>();
    
    public Sort(Tube entrada) {
        this.entrada = entrada;
    }
    public void run() {
        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                boolean swapped;
                while (entrada.isInformacion()) {
                    salidaA.add(entrada.getInformacion());
                }

                int n = salidaA.size();

                do {
                    swapped = false;
                    for (int i = 1; i < n; i++) {
                        // Si la oración actual es mayor que la anterior, las intercambiamos
                        if (salidaA.get(i - 1).toLowerCase().compareTo(salidaA.get(i).toLowerCase()) > 0) {
                            String temp = salidaA.get(i - 1);
                            salidaA.set(i - 1, salidaA.get(i));
                            salidaA.set(i, temp);
                            swapped = true;
                        }
                    }
                    n--;
                } while (swapped);
            }
        }
        System.out.println("/////ABC////");
        for (String string : salidaA) {
            System.out.println(string);
        }
    }

    public ArrayList<String> getSalidaA(){
        return salidaA;
    }


}
