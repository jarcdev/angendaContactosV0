package codigo;

import java.util.Scanner;

public class Principal {

    private static final int MAX_CONTACTOS = 50;
    private static int ocupacion = 0;
    private static Contacto[] contactos = new Contacto[MAX_CONTACTOS];
    
    private static final Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {
        
       
     
        boolean salir = true;
        
        //Cargamos contactos por ahora como datos constantes "hard-coded",posteriormente desde un fichero
        cargarContactos();
        do {
            System.out.println("======AGENDA DE CONTACTOS=========");
            System.out.println("1-para listar contactos");
            System.out.println("2-para detalles de un contacto");
            System.out.println("3-Agregar un contacto");
            System.out.println("4-Borrar un contacto");
            System.out.println("5-Buscar un contacto por numero de telefono");
            System.out.println("6-salir");

            String opciones;
            System.out.println("Dame un opción :");
            opciones = datos.nextLine();
            switch (opciones) {
                case "1":
                    listarContactos();
                    break;

                case "2":
                    detalleContacto();
                    break;

                case "3":
                    agregarContacto();
                    break;

                case "4":
                    eliminarContacto();
                    break;
                case "5":
                    buscarContacto();
                    break;

                case "6":
                    salir = false;
                    break;

                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (salir == true);
    }



   private static void cargarContactos() {


             
        contactos[ocupacion] = new Contacto("Javier", "12345678Z", 111111111, 'F');
        ocupacion++;
        contactos[ocupacion] = new Contacto("Miguel", "13222222H", 1112222222, 'E');
        ocupacion++;
        contactos[ocupacion] = new Contacto("Miguel", "13222222H", 1112222222, 'N');
        ocupacion++;
         contactos[ocupacion] = new Contacto("Miguel", "13222222H", 1112222222, 'N');
        ocupacion++;
        
    }

    private static void listarContactos() {
     
        for (int i = 0; i < ocupacion; i++) {
            System.out.println(+i+1+" "+contactos[i]);
        }
    }

    private static void detalleContacto() {
                int buscado;
        int i;
        System.out.println("Que contacto quieres ver los detalles?:");

        buscado = datos.nextInt();
        datos.nextLine();//Quitamos el intro del buffer del teclado
        //Si no existe mostramos mensaje y salimos de la funcion
        if (buscado < 0 || buscado >= ocupacion) {
            System.out.println("No hay un contacto con ese numero");
            return;
        }
        imprimeFichaContacto(buscado);
        


    }

    private static void eliminarContacto() {
           int i;
        int numero;
        System.out.println("Dame un numero de contacto que quieras borrar :");
        numero = datos.nextInt();
        datos.nextLine();
        if (numero < ocupacion && numero >= 0) {
            for (i = numero; i < ocupacion - 1; i++) {

               contactos[i]=contactos[i+1];

            }
            ocupacion--;

        } else {
            System.out.print("no se pueden borrar los contactos\n");

        }
    }

    private static void buscarContacto() {
        long cadena;
        int i;
        long telefonobuscado;
        System.out.println("Dame un numero de telefono para buscar a quien pertenece:");
        try {
            cadena = datos.nextLong();
            datos.nextLine();
        telefonobuscado = cadena;
        
        for (i = 0; i < ocupacion; i++) {
            if (contactos[i].getTelefono() == telefonobuscado) {
                //muestro la ficha del contacto i
                System.out.println("Datos :" + contactos[i].getNombre()+contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("no hay contacto con telefono %ld\n" + telefonobuscado);
        } catch (Exception e) {
            return;
        }
        

    }

    private static void agregarContacto() {
        String nombre;
        String dni;
        String tmp;
        
        if (ocupacion >= MAX_CONTACTOS) {
            System.out.println("No se pueden meter mas contactos");
            return;
        }
            
        //Se pide un nombre y no se admiten espacios al principio y o al final
        System.out.print("Dame un nombre:");
        nombre = datos.nextLine().trim();
      
         
        
         //Validacion de el nombre
        System.out.print("Dame un dni:");

        dni = datos.nextLine();
       
    
    
        //validacion del dni
        
         System.out.print("Dame un telefono:");
        tmp=datos.nextLine();
        long telefono;
        try {
            telefono= Long.parseLong(tmp);
        } catch (NumberFormatException e) {
            return ;
        }
        //validacion del telefono

        System.out.print("Dame un tipo (A)migo (T)rabajo (E)nemigo (F)amiliar:");

        //validacion de los tipos 
         tmp = datos.nextLine();
         char tipo;
        
       
        try {
            tipo = tmp.charAt(0);
             if(tipo=='A'||tipo=='T'||tipo=='E'||tipo=='F'){
                
            }else{
                return;
            }
        } catch (Exception e) {
            return;
        }
           
            
       
        
        Contacto c=new Contacto(nombre, dni, telefono,tipo);
        contactos[ocupacion]=c;
        
        System.out.println("Contacto agregado");
        ocupacion++;
        
    }
    
    
    private static void imprimeFichaContacto(int buscado) {
        System.out.println("Nombre :" + contactos[buscado].getNombre());
        System.out.println("DNI :" + contactos[buscado].getDni());
        System.out.println("telefono :" + contactos[buscado].getTelefono());
        switch (contactos[buscado].getTipo()) {
            case 'T':
                System.out.println("Tipo: Trabajo");
                break;
            case 'A':
                System.out.println("Tipo: Amigo");
                break;
            case 'E':
                System.out.println("Tipo: Enemigo");
                break;
            case 'F':
                System.out.println("Tipo: Familiar");
                break;
        }
        System.out.println(contactos[buscado].getTipo());
        System.out.println("\n");
    }
     private static boolean validaNombre(String nombre) {
        //Un nombre es valido si su longitud es diferente de 0
        //no es una cadena de solo espacios 
        int longitud = nombre.length();
        int i;
        //Limpiamos los posibles espacios que haya al al principio y o al final de la cadena
        String limpio;
        limpio = nombre.trim();

        return limpio.length() != 0;
    }

private static boolean validaNif(String tmp){
        char[] letras = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();      
        String strDni;
        char letraCalculada;
        //Extraemos la letra
        char letra = tmp.charAt(8);
        //System.out.println(letra);
        //Extraigo los numeros de la cadena

        strDni = tmp.substring(0, 8);
        //System.out.println(strDni);
        int dniComoNumero;
        
        if(tmp.length()!=9){
            //System.out.println("Dni mal formado debes añadir un dni con 8 numeros y 1 letra");
            return false;
        }
        
        try {
        dniComoNumero = Integer.parseInt(strDni);
    } catch (NumberFormatException numberFormatException) {
           // System.err.println("Dni mal formado.Debe comenzar obligatoriamente por un numero de ocho digitos. Rellene con ceros delante");
        return false;
    }
        //System.out.println(dniComoNumero);
        //calculamos la letra
        letraCalculada=letras[dniComoNumero%23];
        
        
        //System.out.println(letraCalculada);
        //devolvemos la validacion
        return letraCalculada==letra;
}
}
