package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import connection.Conexion;
import domain.Product;
import domain.Ticket;

public class FlowerShopSales {
	

	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prepStatement;
	
	Gson gson = new Gson();
	
	public void saveSell(Ticket ticket) {
		
		// Converts ticket object into JSON string
		String jsonTicket = gson.toJson(ticket.getProduct());
		
		connection = Conexion.giveConnection();
		
		try {
			
			prepStatement= connection.prepareStatement(
			"INSERT INTO sells(sellsId,products) VALUES(?,?)");
			
			
			prepStatement.setString(1, null);
			//insert product as json
			prepStatement.setString(2, jsonTicket);
			
			// And then do an executeUpdate
			prepStatement.executeUpdate();
			
			
	}catch(SQLException e) {}
	}
	
	public List<Ticket> getSells(){
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			connection = Conexion.giveConnection();
			statement = connection.createStatement();
			//select sells
			resultSet = statement.executeQuery("select * from sells");
			Type type = new TypeToken<List<Product>>() {
	        }.getType();
			
			while (resultSet.next()) {
				try {
					 ArrayList<Product> productList = gson.fromJson(resultSet.getString("products"), type);
					Ticket ticket = new Ticket();
					ticket.setProduct(productList);
					ticket.setId(resultSet.getInt("sellsId"));
					tickets.add(ticket);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			}catch(SQLException e) {}
			return tickets;
		}
		

		
		
		
	}
	
	
	
	

