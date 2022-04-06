public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
    }

    public DwellingFloor(int size) {
        flats = new Flat[size];
        for (int i = 0; i < size; i++) {
            flats[i] = new Flat();
        }
    }

    public int getFlatsAmount(){
        return flats.length;
    }

    public double getSquareAmount(){
        double sum = 0;
        for (Flat flat : flats) {
            sum += flat.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (Flat flat : flats) {
            sum += flat.getRooms();
        }
        return sum;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public Flat getFlat(int num){
        return flats[num];
    }

    public void setFlat(int num, Flat newFlat){
        this.flats[num] = newFlat;
    }

    public void addFlat(int num, Flat newFlat){
        if (num > flats.length)
        {
            System.out.println("Error");
        }
        Flat[] newFlats = new Flat[flats.length+1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        newFlats[num] = newFlat;
        for (int i = num+1; i <newFlats.length; i++) {
            newFlats[i] = flats[i-1];
        }
        flats = newFlats;
    }

    public void dellFlat(int num){
        if (num > flats.length)
        {
            System.out.println("Error");
        }
        Flat[] newFlats = new Flat[flats.length-1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        for (int i = num; i < newFlats.length ; i++) {
            newFlats[i] = flats[i+1];
        }
        flats = newFlats;
    }

    public Flat getBestSpace()
    {
        Flat flat = flats[0];
        for (int i = 1; i <flats.length; i++) {
            if (flat.getSquare() < flats[i].getSquare())
            {
                flat = flats[i];
            }
        }
        return flat;
    }
}
