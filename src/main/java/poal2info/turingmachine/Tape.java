package poal2info.turingmachine;

public class Tape {

    private final boolean[] tape;
    private int index;

    public Tape() {
        this.tape = new boolean[1000];
        this.index = 0;
    }

    public Tape(int size) {
        this.tape = new boolean[size];
        this.index = 0;
    }

    public boolean goRight() {
        if(index >= tape.length-1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    public boolean goLeft() {
        if(index > 0){
            index--;
            return true;
        } else {
            index = 0;
            return false;
        }
    }

    public void write() {
        tape[index] = true;
    }

    public void erase() {
        tape[index] = false;
    }

    public boolean read() {
        return tape[index];
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < tape.length; i++) {
            if(index == i) out += "[";
            out += (tape[i] ? "1" : "_");
            if(index == i) out += "]";
        }
        return out;
    }
}
