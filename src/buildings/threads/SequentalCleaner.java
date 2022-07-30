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
            while (!sem.getR()){
//                try {
//                    this.wait(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                int u = 1;
                u += 1;
            }
            System.out.println("Cleaning space number " + i + " with total area: " + floor.getSpace(i).getSquare());
            sem.setFlagR();
        }
        System.out.println("Cleaners thread has ended");
    }
}

