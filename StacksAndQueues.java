public class StacksAndQueues {

    
    static class Pila {
        private int[] elementos;
        private int tope;
        private static final int LIMITE = 5;

        public Pila() {
            elementos = new int[LIMITE];
            tope = -1;
        }

      
        public void push(int valor) {
            if (tope < LIMITE - 1) {
                tope++;
                elementos[tope] = valor;
            } else {
                System.out.println("La pila está llena");
            }
        }

        
        public int pop() {
            if (tope >= 0) {
                int valor = elementos[tope];
                tope--;
                return valor;
            } else {
                System.out.println("La pila está vacía");
                return -1;
            }
        }

       
        public void pintarPila() {
            System.out.print("Pila: ");
            for (int i = 0; i <= tope; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }

    static class Cola {
        private int[] elementos;
        private int frente;
        private int fin;
        private int tamaño;
        private static final int LIMITE = 5;

        public Cola() {
            elementos = new int[LIMITE];
            frente = 0;
            fin = -1;
            tamaño = 0;
        }

       
        public void encolar(int valor) {
            if (tamaño < LIMITE) {
                fin = (fin + 1) % LIMITE;
                elementos[fin] = valor;
                tamaño++;
            } else {
                System.out.println("La cola está llena");
            }
        }

        
        public int desencolar() {
            if (tamaño > 0) {
                int valor = elementos[frente];
                frente = (frente + 1) % LIMITE;
                tamaño--;
                return valor;
            } else {
                System.out.println("La cola está vacía");
                return -1;
            }
        }

       
        public void pintarCola() {
            System.out.print("Cola: ");
            for (int i = 0; i < tamaño; i++) {
                int index = (frente + i) % LIMITE;
                System.out.print(elementos[index] + " ");
            }
            System.out.println();
        }
    }

  
    public static void main(String[] args) {
        Pila pila = new Pila();
        Cola cola = new Cola();

     
        for (int i = 1; i <= 5; i++) {
            pila.push(i);
            cola.encolar(i);
        }

        
        pila.pintarPila();
        cola.pintarCola();

        
        System.out.println("Elemento sacado de la pila: " + pila.pop());
        System.out.println("Elemento desencolado: " + cola.desencolar());

        
        pila.pintarPila();
        cola.pintarCola();
    }
}
