package buildings.exceptions;

import buildings.interfaces.Space;

public class InexchangeableSpacesException extends RuntimeException{
    public InexchangeableSpacesException(Space fir, Space sec){
        String errorMessage = "can not change";
        System.out.println(fir.toString());
        System.out.println(sec.toString());
    }
}
