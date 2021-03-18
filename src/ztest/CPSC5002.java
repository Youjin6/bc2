package ztest;

public class CPSC5002 {
    int[][] foo;

    public static void main(String[] args) {
        CPSC5002 oneOfMine = new CPSC5002();
        System.out.println(oneOfMine.sum());
    }

    public CPSC5002(){
        foo = new int[][] {{9,8,7},{6,5},{3}};
    }

    public int sum(){
        int total = 0;
        for (int i = 0; i < foo.length; i++) {
            for (int j = 0; j < foo[i].length; j++) {
                total += foo[i][j];
            }
        }
        return total;
    }
}
