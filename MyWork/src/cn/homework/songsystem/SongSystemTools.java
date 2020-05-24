package cn.homework.songsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 点歌系统
 * 实现：
 * 1. 将歌曲添加至列表
 * 2. 将歌曲置顶
 * 3. 将歌曲前移一位
 * 4. 退出
 *
 * @author CJ
 * @version 2020-5-9
 */
@SuppressWarnings("all")
public class SongSystemTools {

    private static ArrayList<String> songList = new ArrayList<String>();

    /**
     * 启动点歌系统
     * 初始歌单歌曲为：稻香、龙卷风、听妈妈的话
     */
    public static void start() {
        songList.add("稻香");
        songList.add("龙卷风");
        songList.add("听妈妈的话");

        var sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------欢迎光临CJKTV----------");
            System.out.println("0:添加一首歌到歌单");
            System.out.println("1:将一首歌置顶");
            System.out.println("2:将一首歌前移一位");
            System.out.println("3:退出");
            System.out.println(songList);
            int index = sc.nextInt();
            switch (index) {
                case 0:
                    addSong(songList);
                    break;
                case 1:
                    top(songList);
                    break;
                case 2:
                    moveForward(songList);
                    break;
                case 3:
                    System.out.println("感谢光临CJKTV");
                    System.exit(0);
                    sc.close();
                default:
            }
        }
    }

    /**
     * 实现添加歌曲到列表
     *
     * @param songList 需要添加的歌曲
     */
    public static void addSong(ArrayList songList) {
        System.out.print("输入您需要添加的歌：");
        var songName = new Scanner(System.in).nextLine();
        songList.add(songName);
    }

    /**
     * 实现歌曲置顶
     *
     * @param songName 需要置顶的歌曲
     */
    public static void top(ArrayList songList) {
        System.out.print("输入您需要置顶的歌：");
        var songName = new Scanner(System.in).nextLine();
        int index = songList.indexOf(songName);
        String topSong = (String) songList.get(0);
        if (index != 0) {
            songList.set(0, songName);
            songList.set(index, topSong);
        } else {
            System.out.println("您输入的歌曲已经是置顶了！！！");
        }
    }

    /**
     * 实现歌曲前移
     *
     * @param songName 需要前移的歌曲
     */
    public static void moveForward(ArrayList songList) {
        System.out.print("输入您需要前移的歌：");
        var songName = new Scanner(System.in).nextLine();
        int index = songList.indexOf(songName);
        if (index - 1 >= 0) {
            String forwardSong = (String) songList.get(index - 1);
            songList.set(index - 1, songName);
            songList.set(index, forwardSong);
        } else {
            System.out.println("您输入个歌曲已经是第一个了！！");
        }
    }
}
