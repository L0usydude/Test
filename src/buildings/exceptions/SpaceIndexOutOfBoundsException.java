package buildings.exceptions;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public SpaceIndexOutOfBoundsException(int index, int maxIndex) {
        String errorMessage = "SpaceIndexOutOfBoundsException";
        errorMessage += " - index > maxIndex";
        throw new IndexOutOfBoundsException(errorMessage);
    }


}
