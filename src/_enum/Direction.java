package _enum;

public class Direction {
   // Direction 类的静态属性里面, 存放了一个 Direction 的实例 叫NORTH
   public static final Direction NORTH = new Direction();
   public static final Direction EAST = new Direction();
   public static final Direction WEST = new Direction();
   public static final Direction SOUTH = new Direction();
}

enum Direction1{
   NORTH, EAST, WEST, SOUTH
}
