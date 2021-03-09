package code.wk5_mon;

public class C01_ParseIntError {
    public static void main(String[] args) {
        String str = "abcde";
        int number;

        try{
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }
}
