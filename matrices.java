class matrices{

    public static void main(String[] args) {
        
        double[] piso = {0,0,0,0,0};
        String[] piso2 = {"[ ]","[ ]","[ ]","[ ]","[ ]"};

        for (int horas = 0 ; horas <= 4 ; horas++ ){
            System.out.println("han pasado " + horas + " horas");
            
            for (int edificio = 0 ; edificio <= 6 ; edificio++){
                
                for (int altura = 0 ; altura <= 4 ; altura++){
                    piso [altura] = (double) (Math.random());
                    
                    if (piso [altura] <= 0.5){
                        piso2 [altura] = ("[ ]");
                    } else{
                        piso2 [altura] = ("[O]");
                    }

                    if (altura == 4){
                        System.out.println(piso2 [0] + piso2 [1] + piso2 [2] + piso2 [3] + piso2 [4]);
                    }
                }
            }
        }
    }
}