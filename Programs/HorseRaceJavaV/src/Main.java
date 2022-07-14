import javax.net.ssl.HostnameVerifier;
import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main extends Horse {
    public Main(String name, int age, int startNumber) {    // constructors are not inherited, so we need a "super constructor"
        super(name, age, startNumber);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Horse[] horses = ReadFile("src/horses.csv");

        int userTip = getUserTip(horses);

        //region Race
        Random rand = new Random();
        int upperBound = 2;

        do {
            for (int i = 0; i < horses.length; i++) {
                int random_int = rand.nextInt(upperBound);  //number can ranged from 0 - 1;
                if (random_int == 1) {
                    horses[i].Move();
                }
                System.out.print("Horse " + i + ":");
                System.out.println(Arrays.toString(horses[i].RedrawField()));   //using Arrays.toString(arr) i print our the whole array in one go.
            }                                                                   // read documentation for depper understanding
            Thread.sleep(1000);     //stopping after each round for 1 secound, so the game looks smooth
            FakeClearScreen();
        }while(!hasHorseWon(horses));
        //endregion

        //region Sorting and Assigning Ranks after Race
        quickSort(horses, 0, horses.length - 1); //Sorting horse array so we can assign the ranks easily
        assignRank(horses);

        listHorseNames(horses); // list all horses
        tipOutcome(horses, userTip);  //tell user which place his tip achived.
        //endregion

        System.out.println("Thank you for playing!!! <3 <3 <3");
    }

    //region methodes
    private static int getUserTip(Horse[] horses) {
        Scanner sc = new Scanner(System.in);    //In Java you need to create an object from the class "Scanner"
        int userInput = 0;                      // giving over the parameter "System.in" to read from the console.

        do {
            PrintHorseInfo(horses);
            System.out.println("Type in your Tip: ");
            userInput = sc.nextInt();                   // via sc.nextInt() we read in the integer which is typed in the console.
        }while(userInput < 1 || userInput > 10);
        return userInput - 1; //-1 because array starts at 0
    }

    private static void listHorseNames(Horse[] horses) {
        for (int i = horses.length - 1; i >= 0; i--) {
            String formatedString = String.format("%s is rank %d, with the position on the field being %d", horses[i].getName(), horses[i].getRank(), horses[i].getPosition()); //String formatting in Java
            System.out.println(formatedString);
        }
        System.out.println("\n");
    }

    private static void tipOutcome(Horse[] horses, int userInput) {
        for (int i = 0; i < horses.length; i++) {
            if(horses[i].getNumber() == (userInput + 1)){       // userInput + 1 because our start number starts with 1
                String tipSpeech = String.format("Your Tip (%s), was on %d on the race track!\n", horses[i].getName(), horses[i].getRank());
                System.out.println(tipSpeech);
            }
        }
    }

    public static Horse[] ReadFile(String filePath) throws IOException {
        Scanner sc = new Scanner(new File(filePath));   //Creating scanner for that certain file
        int lines = ((int)get_LineCount(filePath)); // needed to determin horseArr length.
        Horse[] horses = new Horse[lines];

        for (int i = 0; i < lines; i++) {
            String Info = sc.nextLine();
            String[] SplitInfo = Info.split(";");   //splitting like we always used to in C#

            Horse horse = new Horse(SplitInfo[0], Integer.parseInt(SplitInfo[1]), i + 1);
            horses[i] = horse;
        }
        sc.close();
        return horses;
    }
    public static long get_LineCount(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        long lines = Files.lines(path).count(); //My own explanation is not sufficient, google these lines or look up the documentation.
        return lines;
    }
    public static void PrintHorseInfo(Horse[] horses){
        for (int i = 0; i < horses.length; i++) {
            String formatedString = String.format("%2d %14s %10d", horses[i].getNumber(), horses[i].getName(), horses[i].getAge()).replace(' ', ' ');
            System.out.println(formatedString);
        }
    }
    public static void FakeClearScreen(){
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");   //clearing the screen does not work, so I implemented a "fake" clear screen by printing lots of newlines.
        }
    }

    public static boolean hasHorseWon(Horse[] horses){
        for (int i = 0; i < horses.length; i++) {
            if(horses[i].getPosition() == 60) return true;
        }
        return false;
    }

    public static void quickSort(Horse[] horses, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }

        int pivot = horses[highIndex].getPosition();

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(horses[leftPointer].getPosition() <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(horses[rightPointer].getPosition() >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            Swap(horses, leftPointer, rightPointer);
        }
        Swap(horses, leftPointer, highIndex);

        quickSort(horses, lowIndex, leftPointer - 1);
        quickSort(horses, leftPointer + 1, highIndex);
    }
    public static void Swap(Horse[] horses, int index1, int index2){
        Horse temp = horses[index1];
        horses[index1] = horses[index2];
        horses[index2] = temp;
    }
    public static void assignRank(Horse[] horses){
        horses = reverseArray(horses);

        int curRank = 1;
        horses[0].setRank(curRank);
        for (int i = 1; i < horses.length; i++) {
           if(horses[i].getPosition() == horses[i - 1].getPosition()){
               horses[i].setRank(curRank);
           }
           else{
               curRank++;
               horses[i].setRank(curRank);
           }
        }
    }

    /**
     * Reverses the array in the oposite order, This is needed, since our horse array is sorted the wrong way around. We need to reverse it to assign the ranks right.
     * @param horses
     * @return
     */
    public static Horse[] reverseArray(Horse[] horses){
        Horse[] tempHorses = new Horse[horses.length];
        int tempIndex = horses.length - 1;

        for (int i = 0; i < tempHorses.length; i++) {
            tempHorses[i] = horses[tempIndex];
            tempIndex--;
        }
        return tempHorses;
    }
    //endregion
}
