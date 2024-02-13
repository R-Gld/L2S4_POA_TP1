package poal2info.turingmachine;

public class Main {

    public static void main(String[] args) {
        Program prog = getAddition();
        TuringMachine machine = new TuringMachine("00111011111000");
        machine.process(prog);
        System.out.println("Etat Final = " + machine);
    }

    public static Program getAddition() {
        Program prog = new Program("ADDITION");

        prog.addInstruction(1, false, "r", 1);
        prog.addInstruction(1, true, "r", 2);
        prog.addInstruction(2, true, "r", 2);
        prog.addInstruction(2, false, "wr", 3);
        prog.addInstruction(3, true, "r", 3);
        prog.addInstruction(3, false, "le", 0);

        return prog;
    }
}
