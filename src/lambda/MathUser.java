package lambda;

public class MathUser <T> {
    public Math<T> calc;

}

class main {
    public static void main(String[] args) {
        MathUser<Integer> a = new MathUser();
        a.calc = str -> {
            for (int i = 0; i < 5; i++) {
                i++;
                System.out.println(str);
            }
            return null;
        };
        System.out.println(a.calc.math1("5"));
    }
}
