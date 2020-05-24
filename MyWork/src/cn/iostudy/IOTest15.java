package cn.iostudy;

import java.io.*;

public class IOTest15 {
    public static void main(String[] args){
        //1.创建源
        File dest = new File("dest.txt");
        //2.选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            //3.操作（写出内容）
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes();//编码：字符串-->字节数组
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.释放资源
                if (null != os) {
                    os.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
