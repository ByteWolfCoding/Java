public class Worker extends Employee {

    public Worker(String name, Gender gender, String department) {
        super(name, gender, department);
    }

    public Worker(String name, Gender gender, String department, double hourlyIncome, double hours) {
        super(name, gender, department);
        setHourlyIncome(hourlyIncome);
        setHours(hours);
    }

    private double hourlyIncome;
    private double hours;

    public double getHourlyIncome() {
        return hourlyIncome;
    }
    public void setHourlyIncome(double hourlyIncome) {
        if(hourlyIncome < 0){
            this.hourlyIncome = 0;
        }
        else{
            this.hourlyIncome = hourlyIncome;
        }
    }

    public double getHours() {
        return hours;
    }
    public void setHours(double hours) {
        if(hours < 0 || hours > 16.0){
            this.hours = 0;
        }
        else{
            this.hours = hours;
        }
    }

    public double GetSalary(){
        return hourlyIncome * hours;
    }

    public String ToString(){
        String formatedString = String.format("Ich heiße %s und arbeite in der Abteilung %s und bin ", name, department);
        if(gender == Gender.Male) formatedString += "Arbeiter";
        else formatedString += "Arbeiterin";

        return formatedString;
    }
}
