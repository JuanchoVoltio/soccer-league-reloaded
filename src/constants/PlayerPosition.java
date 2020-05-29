package constants;

public enum PlayerPosition {
    
    DF("Defender", 1),
    GK("Goalkeeper", 2),
    MD("Mid-field", 3),
    FW("Forward", 4);

    private String description;
    private Integer code;
// contructors-----------------------------------------------
    
    PlayerPosition(String description, Integer code){
        this.code = code;
        this.description = description;
    }
    
// Gets and Sets ---------------------------------------------
    
    public String getDescription(){
        return this.description;
    }

    public Integer getCode(){
        return this.code;
    }
    
}
