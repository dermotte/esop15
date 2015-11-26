package at.aau.esop15.course08;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 26.11.2015 14:24.
 */
public class ExceptionFun {
    public ExceptionFun() {

    }

    public void foo() {
        System.out.println("foo");
    }

    public void bar() throws NotImplementedException {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        ExceptionFun fun = null;
        fun = new ExceptionFun();
        fun.foo();
        try {
            for (int i = 0; i < 10; i++) {
                fun.bar();
            }
        } catch (NotImplementedException e) {
            e.printStackTrace();
        }
    }
}
