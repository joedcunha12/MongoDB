package com.tutorial.core;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class App {
	public static void main(String[] args) {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("MongoDB_Tutorial");

			/**** Get collection / table from 'Edureka_Mongo' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("Edureka_Mongo");

			/**** Insert ****/
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", "John");
			document.put("age", 30);
			document.put("createdDate", new Date());
			table.insert(document);

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
