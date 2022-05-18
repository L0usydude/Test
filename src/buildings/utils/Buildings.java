package buildings.utils;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.*;

public class Buildings {
    public static void outputBuilding(Building sth, OutputStream output) throws IOException {
        DataOutputStream stream = new DataOutputStream(output);
        stream.writeInt(sth.getFloorsAmount());
        stream.writeInt(sth.getSpacesAmount());
        for(int i = 0; i < sth.getFloorsAmount(); i++){
            stream.writeInt(sth.getFloor(i).getSpacesAmount());
            for(int j = 0; j < sth.getFloor(i).getSpacesAmount(); j++){
                stream.writeDouble(sth.getFloor(i).getSpace(j).getSquare());
                stream.writeInt(sth.getFloor(i).getSpace(j).getRooms());
            }
        }
        stream.flush();
    }
    public static Building inputBuilding(InputStream input) throws IOException {
        DataInputStream stream = new DataInputStream(input);
        Building result = new Dwelling(stream.readInt(), stream.readInt());

        for (int i = 0; i < result.getFloorsAmount(); i++){
            Floor tmpFloor = new DwellingFloor(stream.readInt());
            int count = stream.readInt();
            for (int j = 0; j < count; j++){
                Space tmp = new Flat(stream.readDouble(),stream.readInt());
                tmpFloor.setSpace(j, tmp);
            }
            result.setFloor(i, tmpFloor);
        }
        return result;
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
        output.flush();
    }

    public static Building Reader(Reader input) throws IOException {
        StreamTokenizer out = new StreamTokenizer(input);
        out.nextToken();
        int tmp = (int) out.nval;
        Building s = new Dwelling(tmp);
        for (int i = 0; i <s.getFloorsAmount() ; i++) {
            out.nextToken();
            Floor tmpFloor = new DwellingFloor((int) out.nval);
            for (int j = 0; j < (int) out.nval; j++) {
                out.nextToken();
                double tmp2 = out.nval;
                out.nextToken();
                Space tmpSpace = new Flat(tmp2, (int) out.nval);
                tmpFloor.setSpace(j, tmpSpace);
            }
            s.setFloor(i, tmpFloor);
        }
        return s;
    }
}

