//package com.cj.jvm.dynamiccomplie.thread;
//
//import java.util.concurrent.*;
//
///**
// * 了解创建线程的方式三：
// * @author CJ
// */
//
//public class CDownloader implements Callable<Boolean> {
//    private String url; //远程路径
//    private String name; //存储名字
//
//    public CDownloader(String url, String name) {
//        this.url = url;
//        this.name = name;
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CDownloader cd1 = new CDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%A8%8B%E5%BA%8F%E5%91%98&step_word=&hs=0&pn=1&spn=0&di=202070&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2535998274%2C2385394313&os=3468056140%2C1068876037&simid=11335943%2C546295608&adpicid=0&lpn=0&ln=1708&fr=&fmq=1582900311720_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F16%2F09%2F21%2F1657e24502aafb3.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B5fj_z%26e3BvvAzdH3FtAzdH3F%3Fcbbh7_z%26e3Bv54AzdH3Ff7vwtAzdH3F9abcd9l_z%26e3Bip4s&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "phone.jpg");
//        CDownloader cd2 = new CDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%A8%8B%E5%BA%8F%E5%91%98&step_word=&hs=0&pn=2&spn=0&di=130570&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2953582377%2C585363112&os=3173819556%2C1768517265&simid=3492283263%2C299865318&adpicid=0&lpn=0&ln=1708&fr=&fmq=1582900311720_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fdingyue.nosdn.127.net%2FN3BiWnBJiPkLHrpJoom%3DgqBW0YKN0MkE5FZtV4U6DSSH%3D1540383217104compressflag.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3F1y_z%26e3B8mn_z%26e3Bv54AzdH3FedAzdH3Fw6ptvsjAzdH3F1jpwtsAzdH3FDUTKBURUacn88AUH_z%26e3Bip4s&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "spl.jpg");
//        CDownloader cd3 = new CDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%A8%8B%E5%BA%8F%E5%91%98&step_word=&hs=0&pn=5&spn=0&di=63910&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=393391233%2C3110060225&os=4081882498%2C3538457202&simid=3331602663%2C482466037&adpicid=0&lpn=0&ln=1708&fr=&fmq=1582900311720_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20181126%2Fb05b6612525541a28b29546671f5c839.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bf5i7_z%26e3Bv54AzdH3FwAzdH3Fd00ld8999_9dmc0l&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "aaa.jpg");
//
//        //创建执行服务
//        ExecutorService ser = Executors.newFixedThreadPool(3);
//        //提交执行
//        Future<Boolean> result1 = ser.submit(cd1);
//        Future<Boolean> result2 = ser.submit(cd2);
//        Future<Boolean> result3 = ser.submit(cd3);
//        //获取结果
//        boolean r1 = result1.get();
//        boolean r2 = result1.get();
//        boolean r3 = result1.get();
//        System.out.println(r3);
//        //关闭服务
//        ser.shutdown();
//    }
//
//    @Override
//    public Boolean call() throws Exception {
//        WebDownloader wd = new WebDownloader();
//        wd.download(url, name);
//        System.out.println(name);
//        return true;
//    }
//}
