package poal2info.turingmachine;

public class Instruction {

    private final int currentState;
    private final boolean symbolRead;
    /**
     * r = Right <br>
     * l = Left <br>
     * w = Write <br>
     * e = Erase
     */
    private final String operations;
    private final int futureState;


    public Instruction(int currentState, boolean symbolRead, String operations, int futureState) {
        this.currentState = currentState;
        this.symbolRead = symbolRead;
        this.operations = operations;
        this.futureState = futureState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public boolean isSymbolRead() {
        return symbolRead;
    }

    public String getOperations() {
        return operations;
    }

    public int getFutureState() {
        return futureState;
    }

    @Override
    public String toString() {
        return "<" + getCurrentState() + ", '" + (symbolRead ? '1' : '0') + "', " + getOperations() + ", " + getFutureState() + ">";
    }
}
