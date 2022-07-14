public class Horse {

    //region constructor
    public Horse(String name, int age, int startNumber){
        this.name = name;
        this.age = age;
        this.number = startNumber;
    }
    //endregion

    //region field variables
    private String name;
    private int number;
    private int age;
    private int position = 1;
    private int rank;
    //endregion

    //region getter and setter
    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }
    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position){
        this.position = position;
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    //endregion methodes

    //region methodes
    /**
     * Advance the horses position by 1. (position = position + 1);
     */
    public void Move(){
        this.position++;
    }

    /**
     * Assembles a String Array based on the position of the horse. Leaving blank spaces for fields which do not contain the current horse, for the horse itself a * is put in place.
     * @return
     */
    public String[] RedrawField(){
        String[] field = new String[60];
        for (int i = 0; i < field.length; i++) {
            if(this.position == i){
                field[i] = "*";
            }
            else {
                field[i] = " ";
            }
        }
        return field;
    }
    //endregion
}
