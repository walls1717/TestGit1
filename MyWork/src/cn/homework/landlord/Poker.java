package cn.homework.landlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 扑克牌发牌模拟
 *
 * @author CJ
 * @version 2020-5-12
 */
public class Poker {
    public static void main(String[] args) {
        licensing();
    }

    public static void licensing() {
        //存放花色
        var color = new ArrayList<String>();
        color.add("红桃");
        color.add("黑桃");
        color.add("方片");
        color.add("梅花");

        //存放牌号
        var pokers = new ArrayList<String>();
        for (int i = 2; i <= 10; i++) {
            pokers.add(i + "");
        }
        pokers.add("A");
        pokers.add("J");
        pokers.add("Q");
        pokers.add("K");

        var has = new HashMap<Integer, String>(54);
        int index = 0;
        for (String col : color) {
            for (String poc : pokers) {
                has.put(index++, col + poc);
            }
        }

        has.put(index++, "小王");
        has.put(index++, "大王");

        var cards = new ArrayList<Integer>();
        for (int i = 0; i <= 53; i++) {
            cards.add(i);
        }

        Collections.shuffle(cards);

        var player1 = new ArrayList<Integer>();
        var player2 = new ArrayList<Integer>();
        var player3 = new ArrayList<Integer>();
        var selectCards = new ArrayList<Integer>();

        for (int i = 0; i < cards.size(); i++) {
            if (i >= 51) {
                selectCards.add(cards.get(i));
            } else {
                if (i % 3 == 0) {
                    player1.add(cards.get(i));
                } else if (i % 3 == 1) {
                    player2.add(cards.get(i));
                } else {
                    player3.add(cards.get(i));
                }
            }
        }

        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

        var rePlayer1 = new ArrayList<String>();
        var rePlayer2 = new ArrayList<String>();
        var rePlayer3 = new ArrayList<String>();
        var reSelectCards = new ArrayList<String>();

        for(Integer key : player1) {
            rePlayer1.add(has.get(key));
        }
        for(Integer key : player2) {
            rePlayer2.add(has.get(key));
        }
        for(Integer key : player3) {
            rePlayer3.add(has.get(key));
        }
        for(Integer key : selectCards) {
            reSelectCards.add(has.get(key));
        }

        System.out.println("玩家1：" + rePlayer1);
        System.out.println("玩家2：" + rePlayer2);
        System.out.println("玩家3：" + rePlayer3);
        System.out.println("底牌：" + reSelectCards);
    }
}
