public abstract class Employee {

    public Employee(String name, Gender gender, String department){
        setName(name);
        this.gender = gender;
        this.department = department;
    }

    public enum Gender{
        Male,
        Female,
        Diverse
    }

    protected String name;
    protected Gender gender;
    protected String department;

    public void setName(String name){
        if(name == null || name.equals("")){
            this.name = "ERROR";
        }
        else if(Character.isUpperCase(name.charAt(0)) && name.length() >= 2){
            this.name = name;
        }
        else{
            this.name = "ERROR";
        }
    }
    public String getName(){
        return name;
    }
}
