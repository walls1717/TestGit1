package cn.cj.likedlist;

/**
 * 自定义一个链表
 * @author CJ
 */

public class Test01 <E> {
    private Node first;
    private Node last;
    private int size;

    //
    private void checkRange(int index){
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法:" + index);
        }
    }

    //
    public void remove(int index) {
        checkRange(index);
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }
            if (index == 0) {
                first = down;
            }
            if (index == size - 1) {
                last = up;
            }
            size--;
        }
    }



    //
    public E get(int index) {
        checkRange(index);
        Node temp = getNode(index);
        return temp != null ? (E)temp.element : null;
    }

    //
    private Node getNode(int index) {
        checkRange(index);
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    //
    public void add(E element) {
        Node node = new Node(element);

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

    //
    public void add(int index, E element) {
        checkRange(index);
        Node newNode = new Node(element);
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            up.next = newNode;
            newNode.previous = up;
            newNode.next = temp;
            temp.previous = newNode;
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Test01<String> list = new Test01<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list);
        list.add(3, "CJ");
        System.out.println(list);
        System.out.println(list.get(1));
    }
}
