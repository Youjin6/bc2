package cardGame;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家类
 * Created by yuyong on 2017/3/8.
 */
public class Player {

    public String id;    // ID
    public String name;    // 姓名
    public List<Card> playerCardList;    // 玩家拿到的手牌

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.playerCardList = new ArrayList<>();
    }


}
