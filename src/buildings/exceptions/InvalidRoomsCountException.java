package buildings.exceptions;

public class InvalidRoomsCountException extends IllegalArgumentException{
    public InvalidRoomsCountException(int in,int max){
        String errorMessage = "ivanlid count of rooms";
        errorMessage += " - input > maxcount";
        throw new IllegalArgumentException(errorMessage);
    }
}
