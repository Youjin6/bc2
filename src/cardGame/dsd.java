package cardGame;

import java.util.*;

/**
 * 主函数
 * Created by yuyong on 2017/3/8.
 */
class Main {

    // 定义cardList和playerList两个属性
    public List<Card> cardList = new ArrayList<>();
    public List<Player> playerList = new ArrayList<>();

    /**
     * 创建扑克牌
     */
    public void createCard() {
        System.out.println("========== 开始创建一副扑克牌(不含大小王) ==========");
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] colors = {"方块", "梅花", "红桃", "黑桃"};
        for (String c : colors) {
            for (int i = 0; i < numbers.length; i++) {
                Card card = new Card(c, numbers[i]);
                cardList.add(card);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Card card : cardList) {
            builder.append(card.color + card.number + ",");
        }
        System.out.println("========== 扑克牌创建成功 ==========");
        System.out.println("扑克牌为：【 " + builder.substring(0, builder.lastIndexOf(",")) + " 】");
        System.out.println();
    }

    /**
     * 洗牌
     */
    public void randomCard() {
        System.out.println("========== 开始洗牌 ==========");
        Collections.shuffle(cardList);
        System.out.println("========== 洗牌结束 ==========");
        StringBuilder builder2 = new StringBuilder();
        for (Card card : cardList) {
            builder2.append(card.color + card.number + ",");
        }
        System.out.println("洗牌后为：【 " + builder2.substring(0, builder2.lastIndexOf(",")) + " 】");
        System.out.println();
    }

    /**
     * 创建两位玩家
     */
    public void createPlayer() {
        System.out.println("========== 开始创建玩家 ==========");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 3; i++) {
            System.out.println("********** 请输入第" + i + "位玩家的ID和姓名 **********");
            System.out.println("请先输入ID：");
            String id = scanner.next();
            while (true) {
                if (!id.matches("\\d*")) {
                    System.out.println("错误的ID，请重新输入正整数！");
                    id = scanner.next();
                } else {
                    break;
                }
            }
            System.out.println("请再输入玩家姓名：");
            String name = scanner.next();
            playerList.add(new Player(id, name));
        }
        for (Player p : playerList) {
            System.out.println("----欢迎玩家：" + p.id + " " + p.name);
        }
        System.out.println();
    }

    /**
     * 发牌
     * 每位玩家发两张牌
     */
    public void assignCard() {
        System.out.println("========== 开始发牌 ==========");
        for (int i = 0; i < 2; i++) {
            System.out.println("****玩家：" + playerList.get(0).name + " --拿牌");
            playerList.get(0).playerCardList.add(cardList.get(2 * i));

            System.out.println("****玩家：" + playerList.get(1).name + " --拿牌");
            playerList.get(1).playerCardList.add(cardList.get(2 * i + 1));
        }
        System.out.println("========== 发牌结束 ==========");
        System.out.println();
    }

    /**
     * 游戏开始
     */
    public void startGame() {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        System.out.println("========== 开始游戏 ==========");
        // 选出玩家1的最大的手牌
        Collections.sort(player1.playerCardList, new CompareRule());
        // 选出玩家2的最大的手牌
        Collections.sort(player2.playerCardList, new CompareRule());

        List<Card> bigCards = new ArrayList<>();
        bigCards.add(player1.playerCardList.get(1));
        bigCards.add(player2.playerCardList.get(1));
        // 用两个玩家最大的手牌，进行比较
        Collections.sort(bigCards, new CompareRule());
        System.out.println("****玩家：" + player1.name + "最大的手牌为：" + player1.playerCardList.get(1).color + player1.playerCardList.get(1).number);
        System.out.println("****玩家：" + player2.name + "最大的手牌为：" + player2.playerCardList.get(1).color + player2.playerCardList.get(1).number);
        // 比较谁获胜
        if (bigCards.get(1).equals(player1.playerCardList.get(1))) {
            System.out.println("========== 玩家：" + player1.name + "获胜 ==========");
        } else {
            System.out.println("========== 玩家：" + player2.name + "获胜 ==========");
        }
        System.out.println();
        // 两位玩家分别摊牌
        System.out.println("玩家各自的手牌为：");
        System.out.println(player1.playerCardList);
        System.out.println(player2.playerCardList);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.createCard();
        m.randomCard();
        m.createPlayer();
        m.assignCard();
        m.startGame();
    }
}
