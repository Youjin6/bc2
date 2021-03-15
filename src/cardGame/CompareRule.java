package cardGame;

import java.util.Comparator;

/**
 * 自定义比较规则类
 * Created by yuyong on 2017/3/8.
 */
// 继承Comparator<T>接口
public class CompareRule implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        String colors = "方块 梅花 红桃 黑桃";
        String numbers = "A 2 3 4 5 6 7 8 9 10 J Q K";

        // 比较数字的大小，选出较大的手牌
        if (numbers.indexOf(o1.number) < numbers.indexOf(o2.number)) {
            return -1;
        } else if (numbers.indexOf(o1.number) > numbers.indexOf(o2.number)) {
            return 1;
        } else {
            // 数字相同时，再比较花色的大小，选出较大的手牌
            if (colors.indexOf(o1.color) < colors.indexOf(o2.color)) {
                return -1;
            } else if (colors.indexOf(o1.color) > colors.indexOf(o2.color)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
