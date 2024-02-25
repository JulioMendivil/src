public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String rutaEntrada = RutaTXT.rutaEntrada();
        String rutaSalida = RutaTXT.rutaSalida();

        Tube InP_CS = new Tube();
        Tube CS_Sort = new Tube();
        Tube inpOutput = new Tube();
        Input input = new Input(InP_CS);
        CircularShift cs = new CircularShift(InP_CS, CS_Sort);
        Sort sortObj = new Sort(CS_Sort);
        cs.start();
        input.start();
        sortObj.start();
        try {
            sortObj.join(); // Espera a que el hilo termine
            System.out.println("El hilo ha terminado.");
            Output out = new Output(sortObj.getSalidaA());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
