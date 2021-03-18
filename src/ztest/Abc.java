package ztest;

public class Abc<T> {
    private T x;
    private char[] letters;
    public Abc() {
        x = null;
        letters = new char[]{ 'A', 'b', 'c' };
    }
    public void set(T d) {
        x = d;
        setLetters(d.toString());
    }
    private void setLetters(String s) {
        for (int i = 0; i < letters.length && i < s.length(); i++)
            letters[i] = s.charAt(i);
    }

    public static void main(String[] args) {
        Abc<String> x = new Abc<>();
        x.set("Rx");
        System.out.println(x.x);
        System.out.println(x.letters);
    }
}
