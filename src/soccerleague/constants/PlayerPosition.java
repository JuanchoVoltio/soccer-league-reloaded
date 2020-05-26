package soccerleague.constants;

public enum PlayerPosition {
    DF("Defender", 1),
    GK("Goalkeeper", 2),
    MD("Mid-field", 3),
    FW("Forward", 4);

    private String description;
    private Integer code;

    PlayerPosition(String description, Integer code){
        this.code = code;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public Integer getCode(){
        return this.code;
    }

    public static String getDescriptionFromCode(Integer code){
        String description = null;

        for(PlayerPosition current : PlayerPosition.values()){
            if(current.getCode().intValue() == code.intValue()){
                description = current.getDescription();
            }
        }

        return description;
    }
}
