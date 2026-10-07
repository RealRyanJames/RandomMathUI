public static void CountComplex(double x) {
    for (int px = 0; px < x; px++) {
        System.out.print("-");
    }
}

String Message() {
    return "\nWelcome to Application\n".toUpperCase();
}

String DateGet() {
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    return date.format(new Date());
}

void mathMessage() {
    var num1 = new Random().nextInt(1, 10);
    var num2 = new Random().nextInt(1, 10);

    System.out.printf("%s + %s = %s\n", num1, num2, num1 - num2);
    System.out.printf("%s - %s = %s\n", num1, num2, num1 - num2);
    System.out.printf("%s * %s = %s\n", num1, num2, num1 * num2);
    System.out.printf("%s / %s = %s\n", num1, num2, num1 / num2);
}

void main() {

    try {

        double px = 20;
        double py = (px * 2) * 2 / 2;
        CountComplex(py);
        System.out.print(Message());
        System.out.print(DateGet() + "\n");
        mathMessage();
        CountComplex(py);

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}