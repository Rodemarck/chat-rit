package com.example.demo.model.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.mongodb.client.model.Filters.eq;

public class UserDao {
    public static void listar() throws InterruptedException {

        MongoCollection<Document> collection = MeuQueridoMongo.getInstance().getDb().getCollection("token");

        FindIterable<Document> documents = collection.find();
        for(Document doc : documents){
            System.out.println(doc.toJson());
        }
        /*
        System.out.println(collection.find().filter(query).first().toJson());*/
        MeuQueridoMongo.getInstance().release();
    }

    public static void getConta(String token)throws InterruptedException{
        BasicDBObject query = new BasicDBObject();
        query.put("tk", token);
        MongoDatabase db = MeuQueridoMongo.getInstance().getDb();
        MongoCollection<Document> collection = db.getCollection("token");
        Object contaIdUser = collection.find().filter(query).first().get("contaIdUser");

        System.out.println(contaIdUser);
        query.clear();
        query.put("_id",contaIdUser);
        collection = db.getCollection("user");
        ArrayList a = collection.find().filter(query).into(new ArrayList<>());
        System.out.println(collection.find().filter(query).first().toJson());
    }
}
