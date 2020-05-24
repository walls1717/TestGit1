/**
 * 测试构造器
 * 构造器也叫构造方法，用于对象的初始化
 * 1.同构new关键字调用！！
 * 2.构造器虽然有返回值，但是不能定义返回值类型（返回值的类型肯定是本类）
 *   不能再构造器里使用return返回某个值
 * 3.如果我们没有定义构造器，则编译器会自动定义一个无参的构造函数。
 *   如果已定义则编译器不会自动添加！
 * 4.构造器的方法名必须和类名一致！
 * @author CJ
 */

class Point{
    double x, y;
    //构造方法名称和类名保持一致
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }
    //打印两点距离的方法
    public double getDistance(Point p){
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
}

public class TestConstructor {
    public static void main(String[] args){
        Point p = new Point(3.0, 4.0);//创建第一个点，调用构造器
        Point origin = new Point(0.0, 0.0);//创建第二个点（原点），调用构造器
        System.out.println(p.getDistance(origin));//调用计算两点距离的方法，将原点传送过去
    }
}
