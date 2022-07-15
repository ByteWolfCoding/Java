public class Node {
    private String _data;
    private Node _next;

    public Node(String data){
        _data = data;
    }


    public String getData() {
        return _data;
    }

    public Node getNext() {
        return _next;
    }

    public void setNext(Node _next) {
        this._next = _next;
    }
}
