package poal2info.turingmachine;

public class Program {

    private final String name;
    private final Instruction[] instructions;
    private int instructionsSize;

    public Program(String name) {
        this.name = name;
        this.instructions = new Instruction[15];
        this.instructionsSize = 0;
    }

    public String getName() {
        return this.name;
    }

    public Instruction[] getInstructions() {
        return this.instructions;
    }

    public int getInstructionsSize() {
        return this.instructionsSize;
    }

    public Instruction getInstruction(int state, boolean symbol) {
        for (int i = 0; i < instructionsSize; i++) {
            Instruction inst = instructions[i];
            if(inst.getCurrentState() == state && inst.isSymbolRead() == symbol) {
                return inst;
            }
        }
        throw new IllegalArgumentException("L'état \"" + state + "\" ou le symbol \"" + symbol + "\" n'est pas disponible dans le programme actuelle (" + this.getName() + ").");
    }

    public void addInstruction(Instruction instruction) {
        this.instructions[this.instructionsSize] = instruction;
        this.instructionsSize++;
    }

    public void addInstruction(int currentState, boolean symbolRead, String operations, int futureState) {
        addInstruction(new Instruction(currentState, symbolRead, operations, futureState));
    }

    @Override
    public String toString() {
        String out = "";
        out += "Program " + this.getName() + "\n";
        for (int i = 0; i < instructionsSize; i++) {
            out += i + ": " + instructions[i].toString() + "\n";
        }
        return out;
    }
}
