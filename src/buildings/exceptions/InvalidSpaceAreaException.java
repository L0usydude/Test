package buildings.exceptions;

public class InvalidSpaceAreaException extends IllegalArgumentException{
    public InvalidSpaceAreaException(double in,double max){
        String errorMessage = "invalid space area";
        errorMessage += " - input > max space";
        throw new IllegalArgumentException(errorMessage);
    }
}
