class SeqCall {
    public static void main(String[] args) {
        Foo bar;
        {
            bar = new Foo();
            System.out.println(bar.f().f().g());
        }
    }
}
class Foo {
    public Foo f() {
        Foo bar;
        bar = new Foo();
        return bar;
    }
    public int g() {
        return 2321;
    }
}
