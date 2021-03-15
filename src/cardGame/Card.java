package cardGame;

public class Card {
    public String color;    // 花色
    public String number;    // 牌数

    public Card(String color, String number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return color + number;
    }
}
