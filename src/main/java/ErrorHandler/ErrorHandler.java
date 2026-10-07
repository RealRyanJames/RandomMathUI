package ErrorHandler;

public class ErrorHandler {

    public static boolean isError() {

        try {

            System.out.print("Cannot Divide By Zero");
        }

        catch (ArithmeticException ce) {
            System.out.print(ce.getMessage());
            return false;
        }

        return true;
    }
}
