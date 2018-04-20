package mx.com.itam.adsi;

import org.apache.log4j.Logger;

/**
 * Clase Solucion que utiliza la clase Node para probar generacion de
 * graficas sencillas unidireccionales y metodo de reversion.
 */

public class Solucion {
	private final static Logger LOG = Logger.getLogger(Solucion.class); //Creacion del log
	
	/**
	* Clase Nodo para representar una estructura simple de un grafo.
	*/
	
	//LOG.info("Declaracion de clase Node");
    class Node { //stars Node class
        String data;
        Node next;

        /**
         * Instanciador de un objeto de tipo Node.
         */
        Node(String data) {
        	LOG.info("Instancia de Nodo con dato: " + data);
            this.data = data; //Se asigna la cadena entregada al valor del nodo.
        }

        /**
        * Método para invertir la sucesion de los nodos
        * 
        * @return Node El nuevo nodo que encabeza la secuencia.
        */
        Node gus() {
        	LOG.info("Ejecucion de metodo gus().");
            if(next == null) {		/*Salida se realiza cuando se llega al ultimo
              						nodo de la lista, regresandolo para indicar 
              						que es la nueva "cabeza" de la grafica.*/
            	return this;
            }
            Node otro = next;		/*Se asigna el siguiente a otro para poder
            						repetir el procedimiento secuencialmente*/
            next      = null;		/*Se reinicia el enlace del nodo con su
             						subsecuente para poder enlazarlo de nuevo.*/
            Node tavo = otro.gus(); /*Llamada recursiva para aplicar la misma 
            						secuencia a cada nodo*/
            otro.next = this;
        	LOG.info("Termina ejecucion de metodo ok()");
            return tavo;
        }

        /**
         * Imprime en la consola la secuencia de Nodos que
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el método "build", la invocación de
         * este método escribe en la consola:
         *
         * A-->B-->C-->D-->E-->F-->
         *
         * Lo anterior sería lo que se visualiza en la consola
         * justo después de ejecutar las siguintes dos lineas:
         *
         *         Node a = build();
         *         a.prn();
         *
         */
        void prn() {
        	LOG.info("Ejecucion de metodo prn()");
            if(this.next != null) {
            	System.out.print(this.data + "-->"); /*Se imprime en consola segun el
            										formato especificado*/
            	this.next.prn(); /*Llamada recursiva para imprimir el siguiente nodo
            					siempre y cuando no sea el ultimo*/
            }        	
        }

    }// ends Node class

    /**
     * Método para construir un nodo con enlaces subsecuentes.
     *
     * @return Node Regresa el primero que se creó.
     */
    private Node build() {
    	LOG.info("Construccion de secuencia Node desde metodo build()");
        Node n1 = new Node("A"); //Se construye serie de nodos para enlazarlos.
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        n1.next = n2;			 //Se enlazan subsecuentemente cada una de las instancias de Nodo.
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    /**
     * Prueba la funcionalidad del método "gus" con distintos casos de prueba
     */
    public void ok() {
    	LOG.info("Ejecucion de metodo ok()");
    	LOG.info("Prueba para Nodo build()");
        Node a = build(); //Se construye serie de 6 nodos utilizando metodo build()
        a.prn();
        a = a.gus();
        a.prn();
        a = a.gus();
        a.prn();

    	LOG.info("Prueba para nodo X");
        Node b = new Node("X"); /*Se prueba funcionalidad cuando solamente se tiene
        						un nodo*/
        b = b.gus();
        b.prn();
        
    	LOG.info("Prueba para nodos X-->Y");
        Node c = new Node("X"); /*Se prueba funcionalidad con una nueva secuencia
        						de nodos*/
        Node d = new Node("Y");
        c.next = d;
        c = c.gus();
        c.prn();
    	LOG.info("Fin de ejecucion de metodo ok()");
    }

    public static void main(String...argv) {
    	LOG.info("Inicio main()");
    	LOG.info("Ejecucion de prueba: ok()");
        new Solucion().ok();
    	LOG.info("Final main()");
    }

}
