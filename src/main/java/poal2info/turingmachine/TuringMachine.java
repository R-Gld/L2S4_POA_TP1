package poal2info.turingmachine;

public class TuringMachine {

    private final Tape tape;
    private int state = 1;

    public TuringMachine(final String ruban) {
        this.tape = new Tape(ruban.length());

        for (char c : ruban.toCharArray()) {
            if (Integer.parseInt(c + "") != 0){
                tape.write();
            }
            tape.goRight();
        }
        returnToStart();
    }

    private void returnToStart() {
        while(true) if (!tape.goLeft()) break;
    }

    private void execute(String code) {
        for (char c : code.toLowerCase().toCharArray()) {
            switch(c) {
                case 'r':
                    tape.goRight();
                    break;
                case 'l':
                    tape.goLeft();
                    break;
                case 'w':
                    tape.write();
                    break;
                case 'e':
                    tape.erase();
                    break;
                default:
                    throw new IllegalArgumentException("Les seuls caractères acceptés sont {'r', 'l', 'w', 'e'}. '" + c + "' n'est pas accepté.");
            }
        }
    }

    public void process(Program program) {
        returnToStart();
        while(state != 0) {
            Instruction inst = program.getInstruction(this.state, tape.read());
            execute(inst.getOperations());
            this.state = inst.getFutureState();
        }
    }


    @Override
    public String toString() {
        return tape.toString();
    }
}
