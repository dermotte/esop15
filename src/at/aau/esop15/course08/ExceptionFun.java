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

    public void bar() {
        throw new UnsupportedOperationException("not implemented!");
    }

    public static void main(String[] args) {
        ExceptionFun fun =null;
        fun= new ExceptionFun();
        try {
            fun.foo();
            fun.bar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
