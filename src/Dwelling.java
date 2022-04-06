public class Dwelling {
    private DwellingFloor[] floors;

    public Dwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }

    public Dwelling(int floorsAmount, int... flatsAmount)
    {
        if (flatsAmount.length != floorsAmount)
        {
            System.out.println("Error");
        }
        floors = new DwellingFloor[floorsAmount];
        for (int i = 0; i < floorsAmount; i++) {
            floors[i] = new DwellingFloor(flatsAmount[i]);
        }
    }

    public int getFloorsAmount(){
        return floors.length;
    }

    public int getFlatsAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getFlatsAmount();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getRoomsAmount();
        }
        return sum;
    }

    public int getSquareAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getSquareAmount();
        }
        return sum;
    }


}
