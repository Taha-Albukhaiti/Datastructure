package stack;
/**
 * Beschreibung: Testklasse zur Klasse ArrayStack
 */
public class TestStack {

    /**
     * Main-Methode.
     * @param args Uebergabeparameter
     */
    public static void main(String[] args) {
        Stack<Integer> fs = new ArrayStack<>(5);
        //Stack<Integer> fs = new ListStack<>();
        try {
            // einfache verkette Liste
            ListStack<Integer> listStack = new ListStack<>();
            listStack.push(2);
            listStack.push(2+3);
            listStack.push(2+32);
            System.out.println(listStack);

            //TestEnde
            System.out.println(fs); // Stapel-Inhalt ausgeben
                                    // toString()-Methode wird implizit aufgerufen
            // Elemente hinzufuegen
            fs.push(3); // auto-boxing seit Java 5
            fs.push(Integer.valueOf(7));
            fs.push(Integer.valueOf(1));
            fs.push(Integer.valueOf(2));
            fs.push(Integer.valueOf(1));
            System.out.println(fs); // Stapel-Inhalt ausgeben
            
            // Elemente entfernen
            System.out.println("fs.pop " + fs.pop());

            System.out.println(fs); // Stapel-Inhalt ausgeben
            
            // Elemente hinzufuegen
            fs.push(Integer.valueOf(1));
            fs.push(Integer.valueOf(2));
            fs.push(Integer.valueOf(3));
            System.out.println(fs); // Stapel-Inhalt ausgeben
        
            fs.push(Integer.valueOf(3)); // Ausnahme FullStackException bei der Array-Implementierung


        } catch (FullStackException | EmptyStackException e) {
            System.out.println(e.getMessage());
        } ;
    }
}