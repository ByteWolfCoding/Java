
public class Main extends Stack {

    public Main(String data) {
        super(data);
    }

    public static void main(String[] args){
        Stack testStack = new Stack("");
        testStack.Push("test1");
        testStack.Push("test2");
        testStack.Pop();
        System.out.println(testStack.Peek());
    }
}
