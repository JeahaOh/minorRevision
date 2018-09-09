package summary.java.cms.util;
public class LinkedList<T> {
    //  LinkedList 구현하기.
    
    class Node<T2>{
        //  LinkedList는 Node 들로 value(객체)를 저장,
        //  Node에 value값과 전후 node를 가리키는 주소값을 저장하고 있음.
        T2 value;
        Node<T2> next;
        Node<T2> prev;
        
        public Node() {}
        
        public Node(T2 value, Node<T2> prev) {
            //  node가 생성되면 value값과, 다음 node를 준비함.
            this.value = value;
            this.prev = prev;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int length;
    //  LinkedList생성시 처음과 끝을 가르키는 주소값을 저장하는 변수와
    //  가지고 있는 value가 몇 개인지 세는 length값이 있음. 
    
    
    public LinkedList() {
        first = last = new Node<>();
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last;
        last.next = node;
        last = node;
        length++;
        // 새로운 value 추가시 마지막 node에 값을 저장.
        //  새 노드를 만들어서 마지막 노드와 서로를 가르키게 만들고,
        //  새 노드를 마지막 노드값으로 명명.
        //  가지고 있는게 추가되었음으로 length값++.
    }
    
    public T get(int index) {
        if(index < 0 || index >= length)
            return null;
        Node<T> cursor = first;
        
        for (int count = 0; count < index; count++) {
            cursor = cursor.next;
        }
        return cursor.value;
        //  node의 value값을 요청시,
        //  index가 유효한지 먼저 확인,
        //  cursor를 생성해서 받은 index값을 반환함.
    }
    
    public T remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        length--;
        
        Node<T> cursor = first;
        for(int count = 0; count < index; count++) {
            cursor = cursor.next;
        }
        
        if(cursor == first) {
            first = first.next;
            first.prev = null;
            return cursor.value;
        }
        
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        return cursor.value;
        //  node값 삭제 요청시,
        //  index가 유효한지 확인,
        //  length값 --
        //  cursor를 생성해서 index값과 동일한 녀석을 찾아감.
        //  index가 첫번째라면 이전 노드는 없으므로 null.
        //  아니라면, index값에 일치하는 녀석의 이전과 이후를 서로 연결 시켜줌.
    }
    
    public void insert(int index, T obj) {
        if(index < 0 || index >= length) {
            return;
        }
        length++;
        
        Node<T> node = new Node<>();
        node.value = obj;
        
        Node<T> cursor = first;
        for(int count = 0; count < index; count++) {
            cursor = cursor.next;
        }
        
        if(cursor != first) {
            cursor.prev.next = node;
            node.prev = cursor.prev;
        }
        
        cursor.prev = node; //  현재 노드는 새 노드를 가리킨다.
        node.next = cursor; //  새 노드의 다음은 현재 노드를 가리킨다.
        //  새 value값을 중간에 추가할 경우.
        //  index값 유효 확인,
        //  length값 확장.
        //  새 노드에 value값 대입.
        //  cursor를 생성 index로 찾아감.
        //      index node가 first가 아니라면 새 node와 서로 연결.
        //  새 node와 원래 있던 노드를 연결함.
    }
    
    public int size() {
        return this.length;
    }
}
