package buildings.utils;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFactory;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Formatter;

public class Buildings {
    private static BuildingFactory factory = new DwellingFactory();
    public static void outputBuilding(Building sth, OutputStream output) throws IOException {
        DataOutputStream stream = new DataOutputStream(output);
        stream.writeInt(sth.getFloorsAmount());
        for (int i = 0; i < sth.getFloorsAmount(); i++) {
            stream.writeInt(sth.getFloor(i).getSpacesAmount());
            for (int j = 0; j < sth.getFloor(i).getSpacesAmount(); j++) {
                stream.writeDouble(sth.getFloor(i).getSpace(j).getSquare());
                stream.writeInt(sth.getFloor(i).getSpace(j).getRooms());
            }
        }
        stream.flush();
    }

    public static <B extends Building, F extends Floor, S extends Space> Building inputBuilding(InputStream input, Class<B> buildingClass, Class<F> floorClass, Class<S> spaceClass) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataInputStream stream = new DataInputStream(input);
        Floor[] flors = new Floor[stream.readInt()];
        for(int i = 0; i < flors.length; i++){
            flors[i] = createFloor(stream.readInt(), floorClass);
            for (int j = 0; j < flors[i].getSpacesAmount(); j++) {
                Space tmp = createSpace(stream.readDouble(), stream.readInt(), spaceClass);
                flors[i].setSpace(j,tmp);
            }
        }
        return createBuilding(flors, buildingClass);
    }

    public static void writeBuilding(Building sth, Writer output) throws IOException {
        output.write(sth.getFloorsAmount() + " ");
        for (int i = 0; i < sth.getFloorsAmount(); i++) {
            output.write(sth.getFloor(i).getSpacesAmount() + " ");
            for (int j = 0; j < sth.getFloor(i).getSpacesAmount(); j++) {
                output.write(sth.getFloor(i).getSpace(j).getSquare() + " ");
                output.write(sth.getFloor(i).getSpace(j).getRooms() + " ");
            }
        }
        output.write("\n");
        output.flush();
    }

    public static <B extends Building, F extends Floor, S extends Space> Building readBuilding(Reader input, Class<B> buildingClass, Class<F> floorClass, Class<S> spaceClass) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        StreamTokenizer out = new StreamTokenizer(input);
        out.nextToken();
        int tmp = (int) out.nval;
        Building s = createBuilding(tmp, buildingClass);
        for (int i = 0; i < s.getFloorsAmount(); i++) {
            out.nextToken();
            Floor tmpFloor = createFloor((int) out.nval, floorClass);
            for (int j = 0; j < tmpFloor.getSpacesAmount(); j++) {
                out.nextToken();
                double tmp2 = out.nval;
                out.nextToken();
                Space tmpSpace = createSpace(tmp2, (int) out.nval, spaceClass);
                tmpFloor.setSpace(j, tmpSpace);
            }
            s.setFloor(i, tmpFloor);
        }
        return s;
    }

    public static void serializeBuilding(Building tmp, OutputStream outs) throws IOException {
        ObjectOutputStream res = new ObjectOutputStream(outs);
        res.writeObject(tmp);
    }

    public static Building deserializeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream res = new ObjectInputStream(in);
        return (Building) res.readObject();
    }

    public static void writeBuildingFormat(Writer wr, Building tmp) {
        Formatter form = new Formatter(wr);
        form.format("Class type - %s", tmp.getClass().getName());
        form.format("Count of floors - %d", tmp.getFloorsAmount());
        for (int i = 0; i < tmp.getFloorsAmount(); i++) {
            form.format("Count of spaces on floor - %d", tmp.getFloor(i).getSpacesAmount());
            for (int j = 0; j < tmp.getFloor(i).getSpacesAmount(); j++) {
                form.format("Square - %f", tmp.getFloor(i).getSpace(j).getSquare());
                form.format("Rooms - %d", tmp.getFloor(i).getSpace(j).getRooms());
            }
        }
        form.format("\n");
    }

    public static <T extends Comparable<T>> void sortArray (T[] mass){
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - i - 1; j++) {
                if (mass[j].compareTo(mass[j+1]) > 0){
                    T newone = mass[j];
                    mass[j] = mass[j+1];
                    mass[j+1] = newone;
                }
            }
        }
    }
    public static <T> void sortArrayBy (T[] mass, Comparator<T> comparator){
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - i - 1; j++) {
                if (comparator.compare(mass[j], mass[j+1]) > 0){
                    T newone = mass[j];
                    mass[j] = mass[j+1];
                    mass[j+1] = newone;
                }
            }
        }
    }

    public static void setBuildingFactory(BuildingFactory sth){
        factory = sth;
    }

    public static Space createSpace(double square) {
        return factory.createSpace(square);
    }

    public static Space createSpace(double square, int rooms) {
        return factory.createSpace(square, rooms);
    }

    public static Floor createFloor(int count) {
        return factory.createFloor(count);
    }

    public static Floor createFloor(Space[] spaces) {
        return factory.createFloor(spaces);
    }

    public static Building createBuilding(Floor[] floors) {
        return factory.createBuilding(floors);
    }

    public static Building createBuilding(int floorsAmount, int[] officesAmount) {
        return factory.createBuilding(floorsAmount, officesAmount);
    }

    public static Building createBuilding(int floorsamount) {
        return factory.createBuilding(floorsamount);
    }

////////////////////////////////////////////////////////////////////////////

    public static <T extends Space> Space createSpace(double square, Class<T> spaceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return spaceClass.getConstructor(double.class).newInstance(square);
    }

    public static <T extends Space> Space createSpace(double square, int rooms, Class<T> spaceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return spaceClass.getConstructor(double.class, int.class).newInstance(square,rooms);
    }

    public static <T extends Floor> Floor createFloor(int count, Class<T> floorClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return floorClass.getConstructor(int.class).newInstance(count);
    }

    public static <T extends Floor> Floor createFloor(Space[] spaces, Class<T> floorClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return floorClass.getConstructor(Space[].class).newInstance(new Object[] {spaces});
    }

    public static <T extends Building> Building createBuilding(Floor[] floors, Class<T> buildingClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return buildingClass.getConstructor(Floor[].class).newInstance(new Object[] {floors});
    }

    public static <T extends Building> Building createBuilding(int floorsAmount, int[] officesAmount, Class<T> buildingClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return buildingClass.getConstructor(int.class, int[].class).newInstance(floorsAmount,officesAmount);
    }

    public static <T extends Building> Building createBuilding(int floorsamount, Class<T> buildingClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return buildingClass.getConstructor(int.class).newInstance(floorsamount);
    }
}

