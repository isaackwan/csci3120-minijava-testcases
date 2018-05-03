class ArrLen {
    public static void main(String[] args) {
        Foo bar;
        {
            bar = new Foo();
            System.out.println(bar.f().length);
        }
    }
}
class Foo {
    public int[] f() {
        int[] bar;
        bar = new int[123];
        return bar;
    }
}
