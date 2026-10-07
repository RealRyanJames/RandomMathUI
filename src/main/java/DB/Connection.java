package DB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connection {

    public static void Connect(String data) {

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
}