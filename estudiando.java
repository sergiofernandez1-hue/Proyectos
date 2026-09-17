class Vehiculo{
    public int numeroRuedas;
    public int peso;
    public String nombre;

    public Vehiculo(int numeroRuedas, int peso, String nombre){
        this.numeroRuedas = numeroRuedas;
        this.peso = peso;
        this.nombre = nombre;
    }

    public int GetNumeroRuedas(){
        return numeroRuedas;
    }

    public int GetPeso(){
        return peso;
    }

    public String GetNombre(){
        return nombre;
    }
}

class estudiando{
    public static void main(String[] args) {
        Vehiculo coche = new Vehiculo(4, 1000, "coche");
        Vehiculo camion = new Vehiculo(6, 5000, "camion");

        System.out.println("Esto es un " + coche.GetNombre() + " tiene " + coche.GetNumeroRuedas() + " ruedas y pesa " + coche.GetPeso() + " kilos.");
        System.out.println("Esto es un " + camion.GetNombre() + " tiene " + camion.GetNumeroRuedas() + " tuedas y pesa " + camion.GetPeso() + " kilos.");
    }
}