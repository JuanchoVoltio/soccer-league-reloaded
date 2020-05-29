package soccerleague.model;

public class DatabaseException extends Exception{

    public static final int ITEM_ALREADY_EXISTS = -1;
    private final int errorCode;
 
// Constructor------------------------------------------------------
    
    public DatabaseException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
    
    
// Get methods------------------------------------------------------
    
    public int getErrorCode() {
        return errorCode;
    }
}
