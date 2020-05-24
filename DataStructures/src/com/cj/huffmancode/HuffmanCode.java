package com.cj.huffmancode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {

        /*//测试压缩文件
        String srcFile = "E:/src.jpg";
        String destFile = "E:/dst.zip";

        zipFile(srcFile, destFile);
        System.out.println("压缩成功");*/

        //测试解压文件
        String zipFile = "E:/dst.zip";
        String dstFile = "E:/src2.jpg";
        unZipFile(zipFile, dstFile);
        System.out.println("解压成功");

        /*String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodeBytes) + "长度为：" + huffmanCodeBytes.length);

        //测试，byteToBitString方法
//        System.out.println(byteToBitString(true, (byte)1));
        byte[] sourBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println("原来的字符串：" + new String(sourBytes));*/

        /*
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes: " + nodes);

        //测试，
        System.out.println("赫夫曼树：");
        Node huffmanTreeRoot = createHuffManTree(nodes);
        System.out.println("前序遍历：");
        preOrder(huffmanTreeRoot);

        //测试，是否生成了对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码表：" + huffmanCodes);

        //测试
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("huffmanCodeBytes：" + Arrays.toString(huffmanCodeBytes)); //17

        //发送huffmanCodeBytes数组
         */

    }

    /**
     * 将一个文件进行压缩
     *
     * @param srcFile  传入的希望压缩的文件全路径
     * @param destFile 将压缩后的文件放到那个目录下
     */
    private static void zipFile(String srcFile, String destFile) {
        //创建输出流
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            //创建文件输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件输出流，存放压缩文件
            os = new FileOutputStream(destFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入赫夫曼编码，是为了以后恢复源文件时使用
            //注意：一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 完成对压缩文件的解压
     *
     * @param zipFile  准备解压的文件
     * @param destFile 将文件解压到那个路径
     */
    private static void unZipFile(String zipFile, String destFile) {
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            //将bytes数组写入到目标文件
            os = new FileOutputStream(destFile);
            //写数据到destFile中
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //完成数据解压
    //思路
    //1.将huffmanCodeBytes数组重新转成赫夫曼编码对应的二进制字符串
    //2.将赫夫曼编码的二进制字符串转成原始字符串

    /**
     * 将一个byte转成一个二进制的字符串
     *
     * @param b    传入的byte
     * @param flag 标志是否需要补高位，如果是true表示需要补高位，false表示不补，如果是最后一个字节无需补高位
     * @return 该b 对应的二进制的字符串，注意是按照补码返回的
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b; //将b转成int
        //如果是正数我们还存在补高位
        if (flag) {
            temp |= 256; //按位与 256  1 000 0000 | 0000 0001 -> 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 对压缩数据的解码
     *
     * @param huffmanCodes 赫夫曼编码
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 原始字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1.先得到huffmanBytes对应的二进制的字符串，形式：1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二级制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行一个调换，因为要反向查询a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成一个索引，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1; //小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //1010100010111.。。
                //递增的取出key 1
                String key = stringBuilder.substring(i, i + count); //i不动，让count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null) { //说明没有匹配到
                    count++;
                } else { //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count; //让i直接移动到count
        }
        //当for循环结束后，我们list中就存放了所有的字符
        //把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将前面的方法封装起来，便于调用
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回经过赫夫曼编码处理后的字节数组（压缩后的数组）
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node huffmanTreeRoot = createHuffManTree(nodes);
        //根据赫夫曼树创建对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    /**
     * 字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码表处理过后的byte[]
     *
     * @param bytes        原始字符串对应的byte数组
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     * <p>
     * 举例：String content = "i like like like java do you like a java"; -》byte[] contentBytes = content.getBytes();
     * 返回的是赫夫曼编码（字符串）-》对应的byte[] huffmanCodeBytes ，即8位对应一个byte，放入到huffmanCodeBytes
     * huffmanCodeBytes[0] = 10101000(补码) -> byte [推导：10101000 -》 10101000 - 1 -》 10100111（反码）-》11011000]
     * huffmanCodeBytes[0] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println("测试：" + stringBuilder.toString());
        //将“10101...”转成byte[]
        //统计返回byte[] huffmanCodes长度
        //一句话搞定 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每8位对应一个byte，所以步长 +8
            String strByte;
            if (i + 8 > stringBuilder.length()) { //不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }

            //将strByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路：
    //1.将赫夫曼编码表存放在Map<Byte, String>中，形式：32->01 97->100 ...
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //2.在生成赫夫曼编码表时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合
     *
     * @param node          传入的节点
     * @param code          路径：左子节点 0，右子节点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) { //如果node == null不处理
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) { //非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //说明是一个叶子节点
                //就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     * @param bytes 接收字节数组
     * @return List形式
     */
    public static List<Node> getNodes(byte[] bytes) {
        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历bytes，统计每个byte出现的次数->map[key, value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { //Map还没有这个字符数据, 第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每个键值对转成一个Node对象，并加入到Nodes集合
        //遍历Map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过List创建对应的赫夫曼树
    private static Node createHuffManTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二个小的二叉树
            Node rightNode = nodes.get(1);
            //创建一个新的二叉树，它的根节点没有data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);
        }
        //nodes最后的节点就是赫夫曼树的根节点
        return nodes.get(0);
    }
}

//创建Node，带数据和权值
class Node implements Comparable<Node> {
    Byte data; //存放数据（字符）本身，比如'a' —> 97
    int weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
