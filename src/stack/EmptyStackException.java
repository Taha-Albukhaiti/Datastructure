package stack;

public class EmptyStackException extends Exception {

   /**
    * erzeugt ein EmptyStackException-Objekt
    */
    
    public EmptyStackException() {
    }
    
    /**
     * erzeugt ein EmptyStackException-Objekt mit den Nachricht reason
     * @param reason die Nachricht der Ausnahme
     */

    public EmptyStackException(String reason) {
        super(reason);
    }
}