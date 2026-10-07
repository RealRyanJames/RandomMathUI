import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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

    System.out.printf("%s + %s = %s\n", num1, num2, num1 + num2);
    System.out.printf("%s - %s = %s\n", num1, num2, num1 - num2);
    System.out.printf("%s * %s = %s\n", num1, num2, num1 * num2);
    System.out.printf("%s / %s = %s\n", num1, num2, num1 / num2);
}

void Connect(String data) {

    ServerApi api = ServerApi.builder().version(ServerApiVersion.V1).build();
    MongoClientSettings set = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
            .serverApi(api).build();
    try (MongoClient c = MongoClients.create(set)) {

        try {
            Document d1 = new Document("Problem", data);
            MongoDatabase db = c.getDatabase("MathApp");
            db.createCollection("d1");
            MongoCollection<Document> coll = db.getCollection("d1");
            coll.insertOne(d1);
            System.out.print(coll);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            c.close();
        }
    }

}

void main() {

    try {

        var num1 = new Random().nextInt(1, 10);
        var num2 = new Random().nextInt(1, 10);

        double px = 20;
        double py = (px * 2) * 2 / 2;
        CountComplex(py);
        System.out.print(Message());
        System.out.print(DateGet() + "\n");
        mathMessage();
        CountComplex(py);
        var str1 = "%d + %d = %d";
        var str2 = "%d - %d = %d";
        var str3 = "%d * %d = %d";
        var str4 = "%d / %d = %d";

        Connect(str1.formatted(num1, num2, num1 + num2));
        Connect(str2.formatted( num1, num2, num1 - num2));
        Connect(str3.formatted(num1, num2, num1 * num2));
        Connect(str4.formatted(num1, num2, num1 / num2));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}