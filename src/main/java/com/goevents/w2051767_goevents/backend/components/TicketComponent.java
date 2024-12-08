package com.goevents.w2051767_goevents.backend.components;

import com.goevents.w2051767_goevents.CLI.Config;
import com.goevents.w2051767_goevents.MongoDB.Ticket;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class TicketComponent {

    private ObjectId id;
    @BsonProperty(value = "ticket_id")
    private int ticketID;

    @BsonProperty(value = "customer_name")
    private String customerName;

    public TicketComponent( @BsonProperty(value = "ticket_id") int ticketID,@BsonProperty(value = "customer_name") String customerName){
        this.ticketID = ticketID;
        //this.vendorName = vendorName;
        this.customerName = customerName;


    }
    public TicketComponent(){

    }
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void objectToJSON(){
        JSONObject configDetails = new JSONObject();
        configDetails.put("Maximum Ticket Count ", Config.getMaxTicketCount());
        configDetails.put("Total Ticket Count ",Config.getTotalTicketCount());
        configDetails.put("Customer Retrieval Rate ",Config.getCustomerRetrivalRate());
        configDetails.put("Ticket Release Rate", Config.getTicketReleaseRate());

        try{
            FileWriter configDetailsFile = new FileWriter("/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/ConfigDetails.json");
            configDetailsFile.write(configDetails.toJSONString());
            configDetailsFile.close();

        }
        catch(IOException e){
            e.printStackTrace();

        }
    }

    //"/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/ConfigDetails.json"

    public void objectToJSON(String path,String key,String value){

        JSONObject configDetails = new JSONObject();

        configDetails.put(key,value);

        try{
            FileWriter configDetailsFile = new FileWriter(path);
            configDetailsFile.write(configDetails.toJSONString());
            configDetailsFile.close();

        }
        catch(IOException e){
            e.printStackTrace();

        }

    }

    ConnectionString conString = new ConnectionString("mongodb://localhost:27017");
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(conString).codecRegistry(codecRegistry).build();

    public void addTicketDatabase(){
        try(MongoClient mongoClient = MongoClients.create(clientSettings)){
            MongoDatabase db = mongoClient.getDatabase("Vendor_Consumer_DB");
            MongoCollection<TicketComponent> ticket = db.getCollection("Ticket_Purchase_Details", TicketComponent.class);
            ticket.insertOne(this);


        }

    }

}
