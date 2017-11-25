package Tests;




import java.util.Scanner;

public abstract class Menu {
	protected Scanner sc = new Scanner(System.in);
	protected int numeroOpc;
        protected Menu(int opcionSalida){
            setOpcionSalida(opcionSalida);
        }
	public void iniciar(){
            int opc;
            do{
                escribirMenu();
                System.out.println(numeroOpc +". Salir");
                opc = sc.nextInt();
                try{
                System.out.println(procesarOpcion(opc));
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }while(opc!=numeroOpc);
	}
	abstract void escribirMenu();
	public abstract String procesarOpcion(int opc)throws Exception;

    private void setOpcionSalida(int opcionSalida) {
        this.numeroOpc= opcionSalida;
    }
}
