/**
 * 测试垃圾回收机制
 * 1.发现无用的对象
 * 2.回收无用对象占用的内存空间
 * @author CJ
 */

public class TestGarbageCollection {
    String name;
    TestGarbageCollection friend;
    //循环引用(缺点：循环引用无用的对象无法识别)
    public static void main(String[] args){
        TestGarbageCollection s1 = new TestGarbageCollection();
        TestGarbageCollection s2 = new TestGarbageCollection();

        s1.friend = s2;
        s2.friend = s1;//两变量循环引用，则无法识别
        s1 = null;
        s2 = null;
    }
}
/**
 * 通常使用引用可达法
 * 没有被到达的节点，就是无用的节点
 */
