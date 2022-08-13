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
import java.util.Formatter;

public class Buildings {
    private static BuildingFactory factory = new DwellingFactory();
    public static void outputBuilding(Building sth, OutputStream output) throws IOException {
        DataOutputStream stream = new DataOutputStream(output);
        stream.writeInt(sth.getFloorsAmount());
        stream.writeInt(sth.getSpacesAmount());
        for (int i = 0; i < sth.getFloorsAmount(); i++) {
            stream.writeInt(sth.getFloor(i).getSpacesAmount());
            for (int j = 0; j < sth.getFloor(i).getSpacesAmount(); j++) {
                stream.writeDouble(sth.getFloor(i).getSpace(j).getSquare());
                stream.writeInt(sth.getFloor(i).getSpace(j).getRooms());
            }
        }
        stream.flush();
    }

    public static Building inputBuilding(InputStream input) throws IOException {
        DataInputStream stream = new DataInputStream(input);
        Floor[] flors = new Floor[stream.readInt()];
        for(int i = 0; i < flors.length; i++){
            flors[i] = factory.createFloor(stream.readInt());
            for (int j = 0; j < flors[i].getSpacesAmount(); j++) {
                Space tmp = factory.createSpace(stream.readDouble(), stream.readInt());
                flors[i].setSpace(j,tmp);
            }
        }
        return factory.createBuilding(flors);
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

    public static Building readBuilding(Reader input) throws IOException {
        StreamTokenizer out = new StreamTokenizer(input);
        out.nextToken();
        int tmp = (int) out.nval;
        Building s = factory.createBuilding(tmp);
        for (int i = 0; i < s.getFloorsAmount(); i++) {
            out.nextToken();
            Floor tmpFloor = factory.createFloor((int) out.nval);
            for (int j = 0; j < tmpFloor.getSpacesAmount(); j++) {
                out.nextToken();
                double tmp2 = out.nval;
                out.nextToken();
                Space tmpSpace = factory.createSpace(tmp2, (int) out.nval);
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
    public static void setBuildingFactory(BuildingFactory sth){
        factory = sth;
    }
}

