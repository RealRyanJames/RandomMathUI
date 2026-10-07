import DB.Connection;

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

    var str1 = "%d + %d = %d";
    var str2 = "%d - %d = %d";
    var str3 = "%d * %d = %d";
    var str4 = "%d / %d = %d";

    try {

        var num1 = new Random().nextInt(1, 10);
        var num2 = new Random().nextInt(1, 10);

        Pixels p  = PixelsUI::CountComplex;

        double px = 20;
        double py = (px * 2) * 2 / 2;
        p.getPixels(py);
        System.out.print(Message());
        System.out.print(DateGet() + "\n");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Type Of Operator? [1 - 4] \n");
        int s = scan.nextInt();
        p.getPixels(py);

        switch(s) {

            case 1 -> Connection.Connect(str1.formatted(num1, num2, num2 + num2));
            case 2 -> Connection.Connect(str2.formatted(num1, num2, num1 - num2));
            case 3 -> Connection.Connect(str3.formatted(num1, num2, num1 * num2));
            case 4 -> Connection.Connect(str4.formatted(num1, num2, num1 / num2));
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}