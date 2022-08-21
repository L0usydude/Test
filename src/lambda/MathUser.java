package lambda;

public class MathUser <T> {
    public Math<T> calc;

}

class main {
    public static void main(String[] args) {
        MathUser<Integer> a = new MathUser();
        a.calc = Integer::parseInt;
        System.out.println(a.calc.math1("5"));
    }
}
