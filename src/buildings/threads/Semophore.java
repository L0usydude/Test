package buildings.threads;

public class Semophore {
    private boolean flagR;
//    private boolean flagC;

    public Semophore(boolean flagR, boolean flagC) {
        this.flagR = flagR;
//        this.flagC = flagC;
    }

    public boolean getR(){
        return flagR;
    }

//    public boolean getC(){
//        return flagC;
//    }

    public void setFlagR() {
        this.flagR = !flagR;
    }

//    public void setFlagC() {
//        this.flagC = !flagC;
//    }


}
