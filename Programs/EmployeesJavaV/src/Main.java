import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main extends OfficeEmployee {
    public Main(String name, Gender gender, String department, double monthlyIncome) {
        super(name, gender, department, monthlyIncome);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream utf8Printer = new PrintStream(System.out, true, "UTF-8"); //Creating a PrintStream that uses UTF-8

        OfficeEmployee validOfficeWorker = new OfficeEmployee("ValidOfficeWorker", Gender.Male, "Dep1", 3443.2);
        utf8Printer.println(validOfficeWorker.ToString());
        utf8Printer.println(validOfficeWorker.GetSalary());

        OfficeEmployee invalidOfficeWorker = new OfficeEmployee("", Gender.Male, "Dep2", -143.3);
        utf8Printer.println(invalidOfficeWorker.ToString());
        utf8Printer.println(invalidOfficeWorker.GetSalary());



        ChiefExecutive validChief = new ChiefExecutive("ValidChiefExecutiveName", Gender.Male, "LeadingDepartmentName1", 13344.32);
        utf8Printer.println(validChief.ToString());
        utf8Printer.println(validChief.GetSalary());

        ChiefExecutive invalidChief = new ChiefExecutive(null, Gender.Female, "LeadingDepartmentName2", -21342.34);
        utf8Printer.println(invalidChief.ToString());
        utf8Printer.println(invalidChief.GetSalary());



        Worker validWorker = new Worker("ValidWorkerName", Gender.Female, "Department1", 345.21, 13);
        utf8Printer.println(validWorker.ToString());
        utf8Printer.println(validWorker.GetSalary());

        Worker invalidWorker = new Worker("", Gender.Male, "InvalidDep1", 342.221, 30);
        utf8Printer.println(invalidWorker.ToString());
        utf8Printer.println(invalidWorker.GetSalary());
    }
}