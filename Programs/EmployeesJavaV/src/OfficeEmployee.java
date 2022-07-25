import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OfficeEmployee extends Employee {
    public OfficeEmployee(String name, Gender gender, String department, double monthlyIncome) {
        super(name, gender, department);
        setMonthlyIncome(monthlyIncome);
    }

    protected double monthlyIncome;
    public void setMonthlyIncome(double monthlyIncome) {
        if(monthlyIncome < 0){
            this.monthlyIncome = 0;
        }
        else{
            this.monthlyIncome = monthlyIncome;
        }
    }

    public double GetSalary(){
        return monthlyIncome;
    }
    public String ToString(){
        String formatedString = String.format("Ich heiße %s und arbeite in der Abteilung %s und bin ", name, department);
        if(gender == Gender.Male) formatedString += "Angestellter";
        else formatedString += "Angestellte";

       return formatedString;
    }
}
