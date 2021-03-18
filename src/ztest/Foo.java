package ztest;

public class Foo {
    private enum CallSign{ABLE, BAKER, CHARLIE}
    public CallSign getCallSign(int n) {
        return n % 3 == 0 ? CallSign.ABLE : (n % 3 == 1 ? CallSign.BAKER :
                CallSign.CHARLIE);
    }
}