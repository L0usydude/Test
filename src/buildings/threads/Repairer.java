package buildings.threads;

import buildings.interfaces.Floor;

public class Repairer extends Thread{
    private Floor floor;

    public Repairer(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void run() {
        for (int i = 0; i < floor.getSpacesAmount(); i++) {
            System.out.println("repairing space number " + i + " with total area: " + floor.getSpace(i).getSquare());
        }
        System.out.println("repairing has ended");
    }
}
