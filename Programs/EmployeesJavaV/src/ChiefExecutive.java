public class ChiefExecutive extends OfficeEmployee{

    public ChiefExecutive(String name, Gender gender, String department, double monthlyIncome) {
        super(name, gender, department, monthlyIncome);
    }

    @Override
    public double GetSalary(){
        return monthlyIncome * 1.2;
    }

    @Override
    public String ToString(){
        return String.format("Ich heiße %s und leite die Abteilung %s", name, department);
    }
}
