import java.text.DecimalFormat;

public class Tiempo1 {
    private int hora;
    private int minuto;
    private int segundo;

    // Constructor
    public Tiempo1(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    // Método para convertir a String en formato de hora universal (HH:mm:ss)
    public String aStringUniversal() {
        DecimalFormat dosDigitos = new DecimalFormat("00");
        return dosDigitos.format(hora) + ":" +
                dosDigitos.format(minuto) + ":" +
                dosDigitos.format(segundo);
    }

    // Método para convertir a String en formato de hora estándar (hh:mm:ss AM/PM)
    public String aStringEstandar() {
        DecimalFormat dosDigitos = new DecimalFormat("00");
        String periodo = (hora < 12) ? "AM" : "PM";
        int horaEstandar = (hora == 0 || hora == 12) ? 12 : hora % 12;

        return horaEstandar + ":" +
                dosDigitos.format(minuto) + ":" +
                dosDigitos.format(segundo) + " " +
                periodo;
    }

    public static void main(String[] args) {
        Tiempo1 tiempo = new Tiempo1(14, 30, 45);

        System.out.println("Hora Universal: " + tiempo.aStringUniversal());
        System.out.println("Hora Estándar: " + tiempo.aStringEstandar());
    }

    public void establecerHora(int i, int i1, int i2) {

    }
}
