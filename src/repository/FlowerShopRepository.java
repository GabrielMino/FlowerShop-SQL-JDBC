package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import connection.Conexion;
import domain.Decoration;
import domain.Flower;
import domain.Product;
import domain.Tree;


public class FlowerShopRepository {

	

	//defined in order to connect to sql
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prepStatement;
	
	
	
	
	
	//List of flowers
	public List<Flower> getFlower(){
		List<Flower> flowerList = new ArrayList<>();
		try {
		connection = Conexion.giveConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from flower");
		
		while (resultSet.next()) {
			try {
				Flower flower = new Flower(resultSet.getString("name"),resultSet.getString("color"),resultSet.getDouble("price"));
				flower.setProductId(resultSet.getInt("productId"));
				flowerList.add(flower);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		}catch(SQLException e) {}
		return flowerList;
	}
	
	// create Flower
	
	public void saveFlower(Flower flower) {
		
		connection = Conexion.giveConnection();
		
		try {
			
			prepStatement= connection.prepareStatement(
			"INSERT INTO flower(productId,name,color, price) VALUES(?,?,?,?)");
			
			prepStatement.setString(1, null);
			prepStatement.setString(2, flower.getName());
			prepStatement.setString(3, flower.getColor());
			prepStatement.setDouble(4, flower.getPrice());
			// Similarly for the remaining 4 

			// And then do an executeUpdate
			prepStatement.executeUpdate();
			
			
	}catch(SQLException e) {}
	}
	
	
	public void deleteFlower(int productId) {
		
		connection = Conexion.giveConnection();
		
		try {
			prepStatement = connection.prepareStatement("DELETE FROM flower  WHERE productId=? ");

			prepStatement.setInt(1, productId);

			prepStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	
	//List of flowers
		public List<Tree> getTree(){
			
			List<Tree> treeList = new ArrayList<>();
			
			try {
			connection = Conexion.giveConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from tree");
			
			while (resultSet.next()) {
				try {
					Tree tree = new Tree(resultSet.getString("name"),resultSet.getDouble("height"),resultSet.getDouble("price"));
					tree.setProductId(resultSet.getInt("productId"));
					treeList.add(tree);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			}catch(SQLException e) {}
			return treeList;
		}
		
		// create Flower
		
		public void saveTree(Tree tree) {
			
			connection = Conexion.giveConnection();
			
			try {
				
				prepStatement= connection.prepareStatement(
				"INSERT INTO tree(productId,name,height, price) VALUES(?,?,?,?)");
				
				prepStatement.setString(1, null);
				prepStatement.setString(2, tree.getName());
				prepStatement.setDouble(3, tree.getHeight());
				prepStatement.setDouble(4, tree.getPrice());
				// Similarly for the remaining 4 

				// And then do an executeUpdate
				prepStatement.executeUpdate();
				
		}catch(SQLException e) {}
		}
		
		
		public void deleteTree(int productId) {
			
			connection = Conexion.giveConnection();
			
			try {
				prepStatement = connection.prepareStatement("DELETE FROM tree WHERE productId=? ");

				prepStatement.setInt(1, productId);

				prepStatement.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		//List of flowers
		public List<Decoration> getDecoration(){
			List<Decoration> decorationList = new ArrayList<>();
			try {
			connection = Conexion.giveConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from decoration");
			
			while (resultSet.next()) {
				try {
					Decoration decoration = new Decoration(resultSet.getString("name"),resultSet.getString("material"),resultSet.getDouble("price"));
					decoration.setProductId(resultSet.getInt("productId"));
					decorationList.add(decoration);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			}catch(SQLException e) {}
			return decorationList;
		}
		
		// create Flower
		
		public void saveDecoration(Decoration decoration) {
			
			connection = Conexion.giveConnection();
			
			try {
				
				prepStatement= connection.prepareStatement(
				"INSERT INTO decoration(productId,name,material, price) VALUES(?,?,?,?)");
				
				prepStatement.setString(1, null);
				prepStatement.setString(2, decoration.getName());
				prepStatement.setString(3, decoration.getMaterial());
				prepStatement.setDouble(4, decoration.getPrice());
				// Similarly for the remaining 4 

				// And then do an executeUpdate
				prepStatement.executeUpdate();
				
				
		}catch(SQLException e) {}
		}
		
		
		public void deleteDecoration(int productId) {
			
			connection = Conexion.giveConnection();
			
			try {
				prepStatement = connection.prepareStatement("DELETE FROM decoration  WHERE productId=? ");

				prepStatement.setInt(1, productId);

				prepStatement.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
	

    
    
    
    

	

}
	
	
	


	
	



