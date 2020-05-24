package cn.cj.hashmap;

/**
 * 自定义一个HashMap
 * @author CJ
 */

public class CJHashMap<K,V> {

    Node2[] table;//位桶数组。bucket array
    int size;//存放的键值个数

    public CJHashMap(){
        table = new Node2[16];//长度一般定义为2的整数幂
    }

    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        if (table[hash] != null) {
            Node2 temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {//如果相等，则说明找到了键值对，返回相应的value
                    value = (V)temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }

        return value;
    }

    public void put(K key, V value){
        //定义了新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];
        Node2 iterLast = null;//正在遍历的最后一个元素
        boolean keyRepeat = false;

        if (temp == null) {
            //此处的数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else{
            //此处的数组元素不为空，则遍历对应链表
            while(temp != null){
                //判断key如果重复，则覆盖
                if (temp.key.equals(key)) {
                    keyRepeat = true;
                    temp.value = value;//只是覆盖value即可，其他的值（key，hash，next）保持不变
                    break;
                }else{
                    //key不重复，则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if (!keyRepeat) {//没有发生key重复的情况，则添加到链表最后
                iterLast.next = newNode;
                size++;
            }


        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        //遍历bucket数组
        for(int i = 0; i < table.length; i++){
            Node2 temp = table[i];

            //遍历链表
            while(temp != null){
                sb.append(temp.key+":"+temp.value+",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public static void main(String[] args){
        CJHashMap<Integer, String> m = new CJHashMap<>();
        m.put(10, "aa");
        m.put(20, "bb");
        m.put(30, "cc");
        m.put(69, "ee");

        System.out.println(m);
        System.out.println(m.get(69));

    }

    public static int myHash(int v, int length){
        return v&(length - 1);
    }

}
