import java.util.Scanner;

class mision{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        boolean misionEnCurso = true;

        boolean guerreroVivo = true;
        int vidaGuerrero = 120;
        final int MAX_VIDA_GUERRERO = 120;

        boolean magoVivo = true;
        int vidaMago = 100;
        int puntosMago = 50;
        final int MAX_VIDA_MAGO = 100;

        boolean luchadorVivo = true;
        int vidaLuchador = 110;
        final int MAX_VIDA_LUCHADOR = 110;

        boolean curanderoVivo = true;
        int vidaCurandero = 80;
        final int MAX_VIDA_CURANDERO = 80;
        int puntosCurandero = 40;
        int seleccionCuracion;

        int vidaEnemigo = 0;

        final int ATAQUE_GUERRERO = 30;
        final int ATAQUE_CRITICO_GUERRERO = 60;
        final double ACIERTO_ATAQUE_GUERRERO = 0.8;
        final double CRITICO_ATAQUE_GUERRERO = 0.2;
        final int ATAQUESP_GUERRERO = 80;
        final double ACIERTO_ATAQUESP_GUERRERO = 0.6;

        final int ATAQUE_MAGO = 20;
        final int ATAQUE_CRITICO_MAGO = 40;
        final double ACIERTO_ATAQUE_MAGO = 0.8;
        final double CRITICO_ATAQUE_MAGO = 0.3;
        final int LLAMARADA = 90;

        final int DAÑO_LUCHADOR = 40;
        final int DAÑO_CRITICO_LUCHADOR = 80;
        double seleccionCriticoLuchador;
        final double CRITICO_ATAQUE_LUCHADOR = 0.5;

        final int ATAQUE_CURANDERO = 20;
        final int ATAQUE_CRITICO_CURANDERO = 40;
        final double ACIERTO_ATAQUE_CURANDERO = 0.8;
        final double CRITICO_ATAQUE_CURANDERO = 0.3;

        int dañoEnemigo = 0;
        double seleccionandoObjetivo;
        int seleccionObjetivo;
        double seleccionAtaque;
        final double ATAQUE_SELECCIONADO = 0.6;
        final double GUERRERO_SELECCIONADO = 0.2;
        final double MAGO_SELECCIONADO = 0.4;
        final double LUCHADOR_SELECCIONADO = 0.6;
        final double CURANDERO_SELECCIONADO = 0.8;
        boolean objetivoSeleccionado;
        final int BOLA_FUEGO = 20;
        String nombreEnemigo = "nada";

        int nivel = 0;
        int enemigosMuertos = 0;
        int movimientoElegido;
        double intentoAtaque;
        double intentoCritico;
        final double CAMINO_BUENO = 0.5;
        double seleccionCamino;
        int caminoElegido = 0;
        boolean caminoNoTomado = true;
        boolean equipoVivo = true;
        boolean enemigoVivo = true;

        while (misionEnCurso){

            switch (nivel){

                case 0 -> {
                    System.out.println("El equipo camina por las vastas estepas del reino. \nDe repente, un lobo os ataca.");
                }

                case 1 -> {
                    System.out.println("Encontrais una cueva que parece ser el destino, decidis entrar en ella. \nEntre la oscuridad sois emboscados por un pequeño demonio.");
                }

                case 2 -> {
                    
                    while (caminoNoTomado){
                        System.out.println("Llegais a lo que parece ser una bifurcacion");

                        while (caminoElegido != 1 && caminoElegido != 2) {
                            System.out.println("Que camino tomais? \n[1] izquierda \n[2] derecha");
                            caminoElegido = scanner.nextInt();

                            if (caminoElegido != 1 && caminoElegido != 2) {
                                System.out.println("Ese camino no existe");
                            }
                        }

                        seleccionCamino = Math.random();

                        if (caminoElegido == 1 && seleccionCamino <= CAMINO_BUENO || caminoElegido == 2 && seleccionCamino >= CAMINO_BUENO){
                            System.out.println("Os adentrais mqs aun en la cueva. \nLlegais a lo que parece ser un gran porton. \nAl atravesarlo, os allais en un extenso pasillo, columnas en las paredes y una larga alfombra roja decoran la estancia. \nCuando os acercais al final, escuchais un potente rugido, y del fondo del pasillo emerge un gran dragon, es el que veniais a matar.");
                        } else {
                            System.out.println("Continuais por la cueva, pero no llegais a nada \nDecidis dar la vuelta.\nOs sorprende otro demonio.");
                            nivel = 1;
                        }

                        caminoNoTomado = false;
                    }

                    if (enemigosMuertos == 3){
                        System.out.println("Os adentrais mas aun en la cueva. \nLlegais a lo que parece ser un gran porton. \nAl atravesarlo, os adentrais en un extenso pasillo, columnas en las paredes y una larga alfombra roja decoran la estancia. \nCuando os acercais al final, escuchais un potente rugido, y del fondo del pasillo emerge un gran dragon, es el que veniais a matar.");
                    }
                }
            }

            switch (nivel) {

                case 0 -> {
                    vidaEnemigo = 100;
                    dañoEnemigo = 10;
                    nombreEnemigo = "Lobo";
                    enemigoVivo = true;
                }

                case 1 -> {
                    vidaEnemigo = 400;
                    dañoEnemigo = 20;
                    nombreEnemigo = "Demonio";
                    enemigoVivo = true;
                }

                case 2 -> {
                    vidaEnemigo = 1000;
                    dañoEnemigo = 30;
                    nombreEnemigo = "Dragon";
                    enemigoVivo = true;
                }
            }
            
            System.out.println ("-------------\nB A T A L L A\n-------------");
            
            while(enemigoVivo && equipoVivo){

                if(guerreroVivo && enemigoVivo){
                    movimientoElegido = 0;
                    System.out.println("Turno del guerrero \nPS: " + vidaGuerrero);

                    while (movimientoElegido != 1 && movimientoElegido != 2){
                        System.out.println("Elige un movimiento: \n[1] Ataque \n[2] Ataque Especial");
                        movimientoElegido = scanner.nextInt();
                        
                        if (movimientoElegido != 1 && movimientoElegido != 2){
                            System.out.println("El guerrero no conoce ese ataque");
                        }
                    }

                    switch (movimientoElegido){
                        case 1 -> {
                            intentoAtaque = Math.random();

                            if (intentoAtaque <= ACIERTO_ATAQUE_GUERRERO){
                                intentoCritico = Math.random();

                                if(intentoCritico <= CRITICO_ATAQUE_GUERRERO){
                                    System.out.println("Impacto critico.\nEl " + nombreEnemigo + " recibe " + ATAQUE_CRITICO_GUERRERO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_CRITICO_GUERRERO;

                                } else{
                                    System.out.println("El " + nombreEnemigo + " recibe " + ATAQUE_GUERRERO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_GUERRERO;
                                }

                                if(vidaEnemigo <= 0){
                                    enemigoVivo = false;
                                }

                            } else {
                                System.out.println("El ataque ha fallado.");
                            }
                        }

                        case 2 -> {
                            intentoAtaque = Math.random();

                            if(intentoAtaque <= ACIERTO_ATAQUESP_GUERRERO){
                                System.out.println("El " + nombreEnemigo + " recibe " + ATAQUESP_GUERRERO + " puntos de golpe");
                                vidaEnemigo = vidaEnemigo - ATAQUESP_GUERRERO;

                                if(vidaEnemigo <= 0){
                                    enemigoVivo = false;
                                }

                            } else{
                                System.out.println("El ataque ha fallado");
                            }                          
                        }
                    }
                }

                if(magoVivo && enemigoVivo){
                    movimientoElegido = 0;
                    System.out.println("Turno del mago \nPS: " + vidaMago + "\nPP: " + puntosMago);

                    while (movimientoElegido != 1 && movimientoElegido != 2){
                        System.out.println("Elige un movimiento: \n[1] Ataque \n[2] Llamarada");
                        movimientoElegido = scanner.nextInt();
                        
                        if (movimientoElegido != 1 && movimientoElegido != 2){
                            System.out.println("El mago no conoce ese ataque");
                        }
                    }

                    switch (movimientoElegido){
                        case 1 -> {
                            intentoAtaque = Math.random();

                            if (intentoAtaque <= ACIERTO_ATAQUE_MAGO){
                                intentoCritico = Math.random();

                                if(intentoCritico <= CRITICO_ATAQUE_MAGO){
                                    System.out.println("Impacto critico.\nEl " + nombreEnemigo + " recibe " + ATAQUE_CRITICO_MAGO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_CRITICO_MAGO;

                                } else{
                                    System.out.println("El " + nombreEnemigo + " recibe " + ATAQUE_MAGO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_MAGO;
                                }

                                if(vidaEnemigo <= 0){
                                    enemigoVivo = false;
                                }

                            } else {
                                System.out.println("El ataque ha fallado.");
                            }
                        }

                        case 2 -> {
                            if(puntosMago > 0){
                                System.out.println("El enemigo recibe " + LLAMARADA + " puntos de golpe.");
                                vidaEnemigo = vidaEnemigo - LLAMARADA;
                                puntosMago = puntosMago - 10;

                                if(vidaEnemigo <= 0){
                                    enemigoVivo = false;
                                }
                            
                            } else {
                                System.out.println("El mago ha intentado usar llamarada, pero no le quedan PP");
                            }
                        }
                    }
                }

                if(luchadorVivo && enemigoVivo){
                    movimientoElegido = 0;
                    System.out.println("Turno del luchador \nPS: " + vidaLuchador);

                    while (movimientoElegido != 1 && movimientoElegido != 2){
                        System.out.println("Elige un movimiento: \n[1] Manotazo \n[2] Patada");
                        movimientoElegido = scanner.nextInt();
                        
                        if (movimientoElegido != 1 && movimientoElegido != 2){
                            System.out.println("El luchador no conoce ese ataque");
                        }
                    }

                    seleccionCriticoLuchador = Math.random();

                    if(seleccionCriticoLuchador <= CRITICO_ATAQUE_LUCHADOR && movimientoElegido == 1 || seleccionCriticoLuchador >= CRITICO_ATAQUE_LUCHADOR && movimientoElegido == 2){
                        System.out.println("Impacto critico.\nEl " + nombreEnemigo + " recibe " + DAÑO_CRITICO_LUCHADOR+ " puntos de golpe.");
                        vidaEnemigo = vidaEnemigo - DAÑO_CRITICO_LUCHADOR;

                    } else {
                        System.out.println("El " + nombreEnemigo + " recibe " + DAÑO_LUCHADOR + " puntos de golpe.");
                        vidaEnemigo = vidaEnemigo - DAÑO_LUCHADOR;
                    }

                    if(vidaEnemigo <= 0){
                    enemigoVivo = false;
                    }

                }

                if(curanderoVivo && enemigoVivo){
                    movimientoElegido = 0;
                    System.out.println("Turno del curandero \nPS: " + vidaCurandero + "\nPP: " + puntosCurandero);

                    while (movimientoElegido != 1 && movimientoElegido != 2){
                        System.out.println("Elige un movimiento: \n[1] Ataque \n[2] Curacion");
                        movimientoElegido = scanner.nextInt();
                        
                        if (movimientoElegido != 1 && movimientoElegido != 2){
                            System.out.println("El curandero no conoce ese ataque");
                        }
                    }

                    switch (movimientoElegido){
                        case 1 -> {
                            intentoAtaque = Math.random();

                            if (intentoAtaque <= ACIERTO_ATAQUE_CURANDERO){
                                intentoCritico = Math.random();

                                if(intentoCritico <= CRITICO_ATAQUE_CURANDERO){
                                    System.out.println("Impacto critico.\nEl " + nombreEnemigo + " recibe " + ATAQUE_CRITICO_CURANDERO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_CRITICO_CURANDERO;

                                } else{
                                    System.out.println("El " + nombreEnemigo + " recibe " + ATAQUE_CURANDERO + " puntos de golpe.");
                                    vidaEnemigo = vidaEnemigo - ATAQUE_CURANDERO;
                                }

                                if(vidaEnemigo <= 0){
                                    enemigoVivo = false;
                                }

                            } else {
                                System.out.println("El ataque ha fallado.");
                            }
                        }

                        case 2 -> {
                            seleccionCuracion = 0;

                            while(seleccionCuracion != 1 && seleccionCuracion != 2 && seleccionCuracion != 3 && seleccionCuracion != 4){
                                System.out.println("A quien quieres curar?\n[1] Guerrero\n[2] Mago\n[3] Luchador\n[4] Curandero");
                                seleccionCuracion = scanner.nextInt();

                                if(seleccionCuracion != 1 && seleccionCuracion != 2 && seleccionCuracion != 3 && seleccionCuracion != 4){
                                    System.out.println("Ese no es ningun aliado.");
                                }
                            }

                            switch(seleccionCuracion){

                                case 1 -> {
                                    
                                    if(puntosCurandero > 0){
                                        if (!guerreroVivo){
                                            System.out.println("El curandero intenta sanar al guerrero, pero ha sido herido de muerte.");
                                            
                                        } else {
                                            System.out.println("El guerrero recupera toda su salud.");
                                            vidaGuerrero = MAX_VIDA_GUERRERO;
                                            puntosCurandero = puntosCurandero - 10;
                                        }



                                    } else {
                                        System.out.println("El curandero ha intentado usar curacion, pero no le quedan PP.");
                                    }
                                }

                                case 2 -> {
                                    if(puntosCurandero > 0){
                                        if (!magoVivo){
                                            System.out.println("El curandero intenta sanar al mago, pero ha sido herido de muerte.");
                                            
                                        } else {
                                            System.out.println("El mago recupera toda su salud.");
                                            vidaMago = MAX_VIDA_MAGO;
                                            puntosCurandero = puntosCurandero - 10;

                                        }

                                    } else {
                                        System.out.println("El curandero ha intentado usar curacion, pero no le quedan PP.");
                                    }
                                }

                                case 3 -> {
                                    if(puntosCurandero > 0){
                                        if (!luchadorVivo){
                                            System.out.println("El curandero intenta sanar al luchador, pero ha sido herido de muerte.");

                                        } else {
                                            System.out.println("El luchador recupera toda su salud.");
                                            vidaLuchador = MAX_VIDA_LUCHADOR;
                                            puntosCurandero = puntosCurandero - 10;
                                        }

                                    } else {
                                        System.out.println("El curandero ha intentado usar curacion, pero no le quedan PP.");
                                    }
                                }

                                case 4 -> {
                                    if(puntosCurandero > 0){
                                        System.out.println("El curandero recupera toda su salud.");
                                        vidaCurandero = MAX_VIDA_CURANDERO;
                                        puntosCurandero = puntosCurandero - 10;

                                    } else {
                                        System.out.println("El curandero ha intentado usar curacion, pero no le quedan PP.");
                                    }
                                }
                            }
                        }
                    }
                }

                if (!enemigoVivo){
                    System.out.println("El "+ nombreEnemigo + " ha caido.");
                    enemigosMuertos = enemigosMuertos + 1;
                    nivel = nivel + 1;
                }

                if (enemigoVivo && equipoVivo){
                    System.out.println("Turno del" + nombreEnemigo + "\nPS: " + vidaEnemigo);
                    objetivoSeleccionado = false;
                    seleccionObjetivo = 0;

                    while(!objetivoSeleccionado){
                        seleccionandoObjetivo = Math.random();

                        if(seleccionandoObjetivo <= GUERRERO_SELECCIONADO){
                            if(guerreroVivo){
                                seleccionObjetivo = 1;
                                objetivoSeleccionado = true;
                            }
                        } else if(seleccionandoObjetivo <= MAGO_SELECCIONADO){                           
                            if(magoVivo){
                                seleccionObjetivo = 2;
                                objetivoSeleccionado = true;
                            }
                        } else if(seleccionandoObjetivo <= LUCHADOR_SELECCIONADO){
                            if(luchadorVivo){
                                seleccionObjetivo = 3;
                                objetivoSeleccionado = true;
                            }
                        } else if(seleccionandoObjetivo <= CURANDERO_SELECCIONADO){
                            if(curanderoVivo){
                                seleccionObjetivo = 4;
                                objetivoSeleccionado = true;
                            }
                        }
                    }

                    if (nivel != 2){
                        switch (seleccionObjetivo){

                            case 0 -> {
                                System.out.println("El ataque ha fallado");
                            }

                            case 1 -> {
                                System.out.println("El guerrero recibe " + dañoEnemigo + " puntos de golpe.");
                                vidaGuerrero = vidaGuerrero - dañoEnemigo;
                                if (vidaGuerrero <= 0){
                                    System.out.println("El guerrero ha caido.");
                                    guerreroVivo = false;
                                }
                            }

                            case 2 -> {
                                System.out.println("El mago recibe " + dañoEnemigo + " puntos de golpe.");
                                vidaMago = vidaMago - dañoEnemigo;
                                if (vidaMago <= 0){
                                    System.out.println("El mago ha caido.");
                                    magoVivo = false;
                                }
                            }

                            case 3 -> {
                                System.out.println("El luchador recibe " + dañoEnemigo + " puntos de golpe.");
                                vidaLuchador = vidaLuchador - dañoEnemigo;
                                if (vidaLuchador <= 0){
                                    System.out.println("El luchador ha caido.");
                                    luchadorVivo = false;
                                }
                            }

                            case 4 -> {
                                System.out.println("El curandero recibe " + dañoEnemigo + " puntos de golpe.");
                                vidaCurandero = vidaCurandero - dañoEnemigo;
                                if (vidaCurandero <= 0){
                                    System.out.println("El curandero ha caido.");
                                    curanderoVivo = false;
                                }
                            }
                        }
                    } else {
                        seleccionAtaque = Math.random();

                        if (seleccionAtaque <= ATAQUE_SELECCIONADO){
                            switch (seleccionObjetivo){

                                case 0 -> {
                                    System.out.println("El ataque ha fallado");
                                }

                                case 1 -> {
                                    System.out.println("El guerrero recibe " + dañoEnemigo + " puntos de golpe.");
                                    vidaGuerrero = vidaGuerrero - dañoEnemigo;
                                    if (vidaGuerrero <= 0){
                                        System.out.println("El guerrero ha caido.");
                                        guerreroVivo = false;
                                    }
                                }

                                case 2 -> {
                                    System.out.println("El mago recibe " + dañoEnemigo + " puntos de golpe.");
                                    vidaMago = vidaMago - dañoEnemigo;
                                    if (vidaMago <= 0){
                                        System.out.println("El mago ha caido.");
                                        magoVivo = false;
                                    }
                                }

                                case 3 -> {
                                    System.out.println("El luchador recibe " + dañoEnemigo + " puntos de golpe.");
                                    vidaLuchador = vidaLuchador - dañoEnemigo;
                                    if (vidaLuchador <= 0){
                                        System.out.println("El luchador ha caido.");
                                        luchadorVivo = false;
                                    }
                                }

                                case 4 -> {
                                    System.out.println("El curandero recibe " + dañoEnemigo + " puntos de golpe.");
                                    vidaCurandero = vidaCurandero - dañoEnemigo;
                                    if (vidaCurandero <= 0){
                                        System.out.println("El curandero ha caido.");
                                        curanderoVivo = false;
                                    }
                                }
                            }

                        } else {
                            System.out.println("El " + nombreEnemigo + " usa su bola de fuego.\nTodo el equipo recibe " + BOLA_FUEGO + " puntos de golpe.");
                            vidaGuerrero = vidaGuerrero - BOLA_FUEGO;
                            vidaMago = vidaMago - BOLA_FUEGO;
                            vidaLuchador = vidaLuchador - BOLA_FUEGO;
                            vidaCurandero = vidaCurandero - BOLA_FUEGO;

                            if (vidaGuerrero <= 0){
                                System.out.println("El guerrero ha caido.");
                                guerreroVivo = false;
                            }

                            if (vidaMago <= 0){
                                System.out.println("El mago ha caido.");
                                magoVivo = false;
                            }

                            if (vidaLuchador <= 0){
                                System.out.println("El luchador ha caido.");
                                luchadorVivo = false;
                            }

                            if (vidaCurandero <= 0){
                                System.out.println("El curandero ha caido.");
                                curanderoVivo = false;
                            }
                        }
                    }

                    if(!guerreroVivo && !magoVivo && !luchadorVivo && !curanderoVivo){
                        equipoVivo = false;
                    }
                }
            }   
            
            if (!equipoVivo || nivel == 3 && !enemigoVivo){
            misionEnCurso = false;
            }

        }

        if(equipoVivo){
            System.out.println("Habeis cumplido vuestra mision y salvado el reino");
        } else {
            System.out.println("Todo el equipo ha caido, no habeis cumplido vuestra mision");
        }
    }
}