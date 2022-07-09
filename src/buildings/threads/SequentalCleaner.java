package buildings.threads;

import buildings.interfaces.Floor;

public class SequentalCleaner implements Runnable {

    private Floor floor;
    private Semophore sem;
    public SequentalCleaner(Floor floor, Semophore sem) {
        this.floor = floor;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i = 0; i < floor.getSpacesAmount(); i++) {
            while (!sem.getC()){
                try {
                    this.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Cleaning space number " + i + " with total area: " + floor.getSpace(i).getSquare());
            sem.setFlagR(!sem.getR());
            sem.setFlagC(!sem.getC());
        }
        System.out.println("Cleaners thread has ended");
    }
}

