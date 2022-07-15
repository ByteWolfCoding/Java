public class Stack extends Node {

    public Stack(String data) {
        super(data);
    }

    private Node _head = null;
    private int _size = 0;

    public void Push(String s){
        if(_head == null){
            _head = new Node(s);
        }
        else
        {
            Node temp = _head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(s));
        }
        _size++;
    }
    public String Pop(){
        if(_head == null) return null;
        else
        {
            String data;

            if(_head.getNext() == null){
                data = _head.getData();
                _head = null;
            }
            else
            {
                Node temp = _head;
                while(temp.getNext().getNext() != null){
                    temp = temp.getNext();
                }
                data = temp.getNext().getData();
                temp.setNext(null);
            }
            _size--;
            return data;
        }
    }
    public String Peek(){
        if(_head == null) return null;

        Node temp = _head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp.getData();
    }

}
