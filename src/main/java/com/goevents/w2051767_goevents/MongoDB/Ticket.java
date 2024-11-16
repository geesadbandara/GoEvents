package com.goevents.w2051767_goevents.MongoDB;

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

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Ticket {
    private ObjectId id;
    @BsonProperty(value = "ticket_id")
    private int ticketID;

//    @BsonProperty(value = "vendor_name")
//    private String vendorName;

    @BsonProperty(value = "customer_name")
    private String customerName;

    public Ticket( @BsonProperty(value = "ticket_id") int ticketID,@BsonProperty(value = "customer_name") String customerName){
        this.ticketID = ticketID;
        //this.vendorName = vendorName;
        this.customerName = customerName;


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

//    public String getVendorName() {
//        return vendorName;
//    }
//
//    public void setVendorName(String vendorName) {
//        this.vendorName = vendorName;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    ConnectionString conString = new ConnectionString("mongodb://localhost:27017");
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(conString).codecRegistry(codecRegistry).build();

    public void addTicketDatabase(){
        try(MongoClient mongoClient = MongoClients.create(clientSettings)){
            MongoDatabase db = mongoClient.getDatabase("Vendor_Consumer_DB");
            MongoCollection<Ticket> ticket = db.getCollection("Ticket_Purchase_Details", Ticket.class);
            //Ticket newTicket = new Ticket(ticketID,customerName);
//            newTicket.setTicketID(ticketID);
//            newTicket.setVendorName(vendorName);
//            newTicket.setCustomerName(customerName);
//
            ticket.insertOne(this);


        }

    }

}
