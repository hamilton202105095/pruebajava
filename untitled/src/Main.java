import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            String us = "hami";
            String contra ="tele";
            String usuario, contraseña, nombrec, nitc;
            int intentos=0, opcion=0 ;
            int contador= 0;
            int contador1= 0;
            String[] productos = new String[5];
            double[] precios= new double[5];
            String[] descuentos = new String[5] ;
            double[] porcentajeDescuento = new double[5];
            boolean agregarMas= true;
            boolean agregarMas1= true;
            boolean compraprev = false;
            boolean productosagregados = false ;



            while(intentos < 3) {
                System.out.println("por favor ingrese un usuario");
                //se le asigna lo ingresado por el usuario a la variable usuario
                usuario = entrada.nextLine();
                System.out.println("por favor ingrese una contraseña");
                contraseña = entrada.nextLine();
                //comprobador por medio de equals para ver si son lo ingresado es lo mismo
                //a lo establecido ya en las variables "us" y "contra"
                if (us.equals(usuario)) {
                    //entra al anidado si si es igual lo ingresado con lo ya preestablecido
                    //ahora evaluda si es lo mismo con la contraseña
                    if (contra.equals(contraseña)) {
                        System.out.println("¡Bienvenido al sistema!");
                        //se frena y sale del bucle cuando se cumplen ambos
                        break;
                        //else de la contraseña , si esta mal muestra el mensaje
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }

                    // entra si el usuario esta mal
                    //evalua si ambos estan incorrectos
                } else if (!us.equals(usuario) && !contra.equals(contraseña)) {
                    //si ambos estan incorrectos muestra el mensaje
                    System.out.println("Usuario y contraseña incorrectos");
                } else {
                    //si el primero esta mal ya no continua
                    System.out.println("Usuario inválido");
                }
                intentos ++ ;

                if (intentos == 3){
                    System.out.println("ya se equivoco mucho, saquese");
                    System.out.println("hasta la proximaaaa");
                    System.exit(0);
                }

            }
            // menu principal donde se usa do while para que funcione de forma que se ejecuta primero y luego hace la comprobacion
            //en este caso si lo seleccionado es diferente de 6. si es 6 eso termina el bucle|
            do {
                System.out.println("menu");
                System.out.println("1. ingresar productos");
                System.out.println("2. ingresar codigos de descuento");
                System.out.println("3. realizar venta");
                System.out.println("4. realizar factura");
                System.out.println("5. realizar un reporte");
                System.out.println("6. salir");
                opcion= entrada.nextInt();


                switch (opcion){
                    case 1 : {
                        do {
                            System.out.println("**************************************");
                            System.out.println("*       ingresar productos           *");
                            System.out.println("**************************************");
                            System.out.println("--------------------------------------");
                            System.out.println("1. agregar productos");
                            System.out.println("--------------------------------------");
                            System.out.println("2. regresar al menu principal" );
                            System.out.println("--------------------------------------");
                            opcion= entrada.nextInt();

                            switch (opcion) {
                                case 1: {
                                    // bucle mientras, primero pregunta las expresiones logicas luego ejecuta
                                    while (agregarMas && contador < 5) {
                                        System.out.println("Por favor ingrese el nombre del producto:");
                                        String producto = entrada.next();
                                        // aca se llamo a la funcion que evalua que no se repita nada
                                        if (existeproducto(producto, productos, contador)) {
                                            System.out.println("¡Error! El producto ya existe.");
                                            continue;
                                        }
                                        System.out.println("Ingrese el precio del producto:");
                                        double precio = entrada.nextDouble();
                                        productos[contador] = producto;
                                        precios[contador] = precio;
                                        // contador que va aumentando cada ves que se ejecuta el bucle
                                        contador++;

                                        entrada.nextLine();

                                        if (contador<5) {
                                            // Preguntar si quiere agregar más chivas
                                            System.out.println("¿Desea agregar más productos? (s/n)");
                                            String respuesta = entrada.nextLine();
                                            //validacion si dice que nel ahi muere :D
                                            if (respuesta.equalsIgnoreCase("n")) {
                                                // agregar mas se declaro true y si se veulve falso se muere alv
                                                agregarMas = false;
                                            }
                                        } else{
                                            System.out.println(" numero maximo de productos alcanzado");
                                        }
                                    }
                                    productosagregados = true ;

                                }
                                break;
                                case 2: {
                                    System.out.println("**************************************");
                                    System.out.println("saliendo ");
                                    System.out.println("**************************************");

                                }
                                break;
                                default: {
                                    System.out.println("--------------------------------------");
                                    System.out.println("error no existe un valor");
                                    System.out.println("--------------------------------------");

                                }
                                break;
                            }
                        } while (opcion!=2);

                    }
                    break;
                    case 2 : {
                        do {
                            System.out.println("**************************************");
                            System.out.println("ingresar codigos de descuento");
                            System.out.println("**************************************");

                            System.out.println("--------------------------------------");
                            System.out.println("1. agregar codigos");
                            System.out.println("--------------------------------------");
                            System.out.println("--------------------------------------");
                            System.out.println("2. regresar al menu principal" );
                            System.out.println("--------------------------------------");
                            opcion= entrada.nextInt();

                            switch (opcion) {
                                case 1: {

                                    while (agregarMas1 && contador1<5){


                                        System.out.println("por favor ingrese el codigo de descuento que desea agregar");
                                        String descuento = entrada.next();

                                        if (descuento.length()>5){
                                            System.out.println("EROR numero maximo de caracteres");
                                        }
                                        else if (existeDescuento (descuento,descuentos, contador1 )) {
                                            System.out.println("error, codigo ya registrado en el sistema");

                                        } else {

                                            System.out.println("por favor ingrese el porcentaje del decuento sin el %");
                                            Double porcentaje = entrada.nextDouble();

                                            descuentos[contador1] = descuento;
                                            porcentajeDescuento[contador1] = porcentaje;

                                            contador1++;
                                            entrada.nextLine();

                                            if(contador1>5) {
                                                System.out.println("desea agregar otro codigo ? (s/n)");
                                                String respuesta = entrada.nextLine();
                                                if (respuesta.equalsIgnoreCase("n")) {
                                                    agregarMas1 = false;
                                                }
                                            } else {
                                                System.out.println("numero maximo de codigos");
                                            }

                                        }
                                    }

                                }
                                break;
                                case 2: {
                                    System.out.println("**************************************");
                                    System.out.println("*  saliendo                           *");
                                    System.out.println("**************************************");

                                }
                                break;
                                default: {
                                    System.out.println("--------------------------------------");
                                    System.out.println("error no existe un valor" );
                                    System.out.println("--------------------------------------");

                                }
                                break;
                            }
                        } while (opcion!=2);
                    }
                    break;
                    case 3 : {
                        do {
                            System.out.println("**************************************");
                            System.out.println("*     realizar una compra            *");
                            System.out.println("**************************************");
                            System.out.println("--------------------------------------");
                            System.out.println("1. realizar la compra");
                            System.out.println("--------------------------------------");
                            System.out.println("2. regresar al menu principal" );
                            System.out.println("--------------------------------------");
                            opcion= entrada.nextInt();


                            switch (opcion) {


                                case 1: {
                                    if (productosagregados == false) {
                                        System.out.println("ERROR NO EXISTEN PRODUCTOS");
                                        break;
                                    } else {
                                        System.out.println("por favor ingrese su nombre");
                                        nombrec = entrada.next();
                                        System.out.println("por favor ingrese su numero de nit");
                                        nitc = entrada.next();

                                        if (nitc.length() != 8) {
                                            System.out.println("error dpi invalido");
                                        } else {


                                            System.out.println("\nLista de productos:");
                                            entrada.nextLine();
                                            for (int i = 0; i < contador; i++) {
                                                System.out.println(i+1 +".    "  +  productos[i] + ": $" + precios[i]);
                                            }

                                            System.out.println("que desea comprar?");
                                        }
                                    }
                                    compraprev = true ;
                                }
                                break;
                                case 2 :{
                                    System.out.println("**************************************");
                                    System.out.println("*  saliendo                           *");
                                    System.out.println("**************************************");
                                }
                                break;
                                default: {
                                    System.out.println("--------------------------------------");
                                    System.out.println("error no existe un valor" );
                                    System.out.println("--------------------------------------");
                                }
                                break;
                            }
                        } while (opcion !=2);
                    }
                    break;
                    case 4 : {
                        do {
                            System.out.println("**************************************");
                            System.out.println("*        EMITIR UNA FACTURA          *");
                            System.out.println("**************************************");
                            System.out.println("--------------------------------------");
                            System.out.println("1. Realizar la factura");
                            System.out.println("--------------------------------------");
                            System.out.println("2. regresar al menu principal" );
                            System.out.println("--------------------------------------");
                            opcion= entrada.nextInt();


                            switch (opcion) {

                                case 1 : {

                                    if (compraprev == false) {
                                        System.out.println("ERROR, compre primero");
                                    }else {
                                        System.out.println("bienvenido");
                                    }
                                }
                                break;
                                case 2 :{
                                    System.out.println("**************************************");
                                    System.out.println("*  saliendo                           *");
                                    System.out.println("**************************************");
                                }
                                break;
                                default: {
                                    System.out.println("--------------------------------------");
                                    System.out.println("error no existe un valor" );
                                    System.out.println("--------------------------------------");
                                }
                                break;
                            }
                        } while (opcion !=2);
                    }
                    break;


                    case 5: {
                        System.out.println("realizar reporte");


                    }
                    break;

                    case 6: {

                        System.out.println("--------------------------------------");
                        System.out.println("vuelva pronto!!!");
                        System.out.println("--------------------------------------");
                    }
                    break;
                    //el default sirve para cualquier otro que no pertenezca a las opciones ya establecidas
                    default: {
                        System.out.println("error no existe la opcion");
                    }
                    break;
                }
            } while (opcion!=6);

        }

        // funcion booleana que busca desde la variable 1 que viaja desde el primer indice hasta el ultimo
        // deveulve true si es nullo o ya existe coincidencia con alguno guardado
        private static boolean existeproducto (String producto, String[] productos, int lastIndex ){
            for (int i=1; i<lastIndex; i++){
                if (productos[i] != null && productos[i].equals(producto)) {
                    return true;
                }
            }
            return false;
        }

        //la misma funcion solo que ahora con los descuentos
        private static boolean existeDescuento (String descuento, String[] descuentos, int ultimoCodigo) {
            for (int i = 1; i < ultimoCodigo; i++) {
                if (descuentos[i] != null && descuentos[i].equals(descuento)) {
                    return true;
                }
            }
            return false;
        }

        //aca ira una funcion para hacer la manera de comprar los productos



    }

