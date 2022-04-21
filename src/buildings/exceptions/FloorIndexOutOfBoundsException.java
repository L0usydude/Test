package buildings.exceptions;

public class FloorIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public FloorIndexOutOfBoundsException(int index,int maxIndex){
        String errorMessage = "SpaceIndexOutOfBoundsException";
        errorMessage += " - index > maxIndex";
        throw new IndexOutOfBoundsException(errorMessage);
    }
}
