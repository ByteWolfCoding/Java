import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "Hellotest today I'm trying test to test something test";
        String[] arr = replaceSearchTermsWithPattern(stringToArray(text), "test", "patt");
        System.out.println(Arrays.toString(arr));

    }

    public static int stringLength(String s){
        return s.length();
    }

    public static int stringFindWithIndex(String[] s, String searchTemplate, int index){
        if(stringLength(searchTemplate) > s.length) return -1;

        do {
            for (int i = index; i < (s.length - stringLength(searchTemplate)) + 1; i++) { //only searching up to indexes where it still can be possible for the rest to be the search term.
                String curArrContent = "";                                             //if searchTerm == test && s == "test" for this case I added +1, else the loop wouldn't execute, since s - searchterm = 0
                for (int j = 0; j < searchTemplate.length(); j++) {
                    curArrContent += s[j + i];                          //j + i, since we always start from an index 1 farther down the array after each loop round
                }
                if(curArrContent.equals(searchTemplate)){
                    return i;
                }
            }
            return -2;
        }while (true);
    }

    public static String[] stringToArray(String s){
        String[] strArr = s.split("");
        return strArr;
    }

    public static String[] stringDelete(String[] s, int delPos, int amount){
        if((delPos + amount) > (s.length) || delPos < 0) System.out.println("Error 1");

        for (int i = delPos; i < (amount + delPos); i++) s[i] = "*";
        return s;
    }

    public static String[] stringCopyAt(String[] s, String pattern, int pos){
        if((pos + stringLength(pattern)) > (s.length) || pos < 0) System.out.println("Error 1");

        String[] patArr = stringToArray(pattern);

        int patternIndex = 0;
        for (int i = pos; i < (stringLength(pattern) + pos); i++) {
            s[i] = patArr[patternIndex];
            patternIndex++;
        }
        return s;
    }

    public static String[] replaceSearchTermsWithPattern(String[] s, String searchTerm, String pattern){
        boolean noMathFound = false;
        int curIndex = 0;

        do {
            int output = stringFindWithIndex(s, searchTerm, curIndex);
            if(output == -2) break;
            else{
                stringCopyAt(s, pattern, output);
                curIndex++;
            }
        }while(!noMathFound);
        return s;
    }
}