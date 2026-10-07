import DB.Connection;
import ErrorHandler.ErrorHandler;
import FileWriting.FileWriterSync;

String Message() {
    return "\nWelcome to Application\n".toUpperCase();
}

String DateGet() {
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    return date.format(new Date());
}
public interface Pixels {

    void getPixels(double x);
}

static class PixelsUI implements Pixels {

    public static void CountComplex(double x) {
        for (int px = 0; px < x; px++) {
            System.out.print("-");
        }
    }

    public void getPixels(double x) {
        CountComplex(x);
    }
}

void main() {

    try {

        var str1 = "%d + %d = %d";
        var str2 = "%d - %d = %d";
        var str3 = "%d * %d = %d";
        var str4 = "%d / %d = %d";
        var num1 = new Random().nextInt(1, 10);
        var num2 = new Random().nextInt(1, 10);

        if ((double) num1 / (double) num2 == 0.0 && ErrorHandler.isError()) {

            ErrorHandler.isError();
        }
        else {

            Pixels p = PixelsUI::CountComplex;

            double px = 20;
            double py = (px * 2) * 2 / 2;
            p.getPixels(py);
            System.out.print(Message());
            System.out.print(DateGet() + "\n");

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a Type Of Operator? [1 - 4] \n");
            int s = scan.nextInt();

            String formatted2 = str1.formatted(num1, num2, num2 + num2);
            String formatted = str2.formatted(num1, num2, num1 - num2);
            String formatted3 = str3.formatted(num1, num2, num1 * num2);
            String formatted4 = str4.formatted(num1, num2, num1 / num2);

            switch (s) {

                case 1 -> {
                    Connection.Connect(formatted);
                    FileWriterSync.FileWriter("main.numbers.txt", formatted);
                }

                case 2 -> {
                    Connection.Connect(formatted2);
                    FileWriterSync.FileWriter("main.numbers.txt", formatted2);
                }

                case 3 -> {
                    Connection.Connect(formatted3);
                    FileWriterSync.FileWriter("main.numbers.txt", formatted3);
                }

                case 4 -> {
                    Connection.Connect(formatted4);
                    FileWriterSync.FileWriter("main.numbers.txt", formatted4);
                }
            }
            p.getPixels(py);

        }
    }
    catch(Exception e){
        System.out.print(e.getMessage());
    }
}