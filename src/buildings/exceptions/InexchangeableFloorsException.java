package buildings.exceptions;

import buildings.interfaces.Floor;

public class InexchangeableFloorsException extends RuntimeException {
    public InexchangeableFloorsException(Floor fir, Floor sec) {
        String errorMessage = "can not change";
        System.out.println(fir.toString());
        System.out.println(sec.toString());
    }
}
