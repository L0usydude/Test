package buildings.threads;

import buildings.interfaces.Floor;

public class SequentalRepairer implements Runnable {

    private Floor floor;
    private Semophore sem;
    public SequentalRepairer(Floor floor, Semophore sem) {
        this.floor = floor;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i = 0; i < floor.getSpacesAmount(); i++) {
            while (!sem.getR()){
                try {
                    this.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("repairing space number " + i + " with total area: " + floor.getSpace(i).getSquare());
            sem.setFlagR(!sem.getR());
            sem.setFlagC(!sem.getC());
        }
        System.out.println("Repairers thread has ended");
    }
}
