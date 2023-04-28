package Model.Ship;

public enum Ship_Type {
    SUBMARINE,      //2
    DESTROYER,      //3
    BATTLESHIP,     //4
    CARRIER;        //5

    public int length() {
        switch(this) {
            case SUBMARINE:
                return 2;
            case DESTROYER:
                return 3;
            case BATTLESHIP:
                return 4;
            case CARRIER:
                return 5;
            default:
                throw new IllegalStateException("no such ship");
        }
    }
}
