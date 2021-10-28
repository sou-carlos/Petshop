package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pet;

public class PetDAO {
    
    private final Connection connection;
    
    public PetDAO(Connection connection){
        this.connection = connection;
    }
    
    
    //ta ok
    public Pet insert(Pet pet) throws SQLException{
        
        String sql = "INSERT INTO PET(nome, especie, raca, idade, relatorio, id_tutor) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      
        statement.setString(1, pet.getNome());
        statement.setString(2, pet.getEspecie());
        statement.setString(3, pet.getRaca());
        statement.setInt(4, pet.getId());
        statement.setString(5, pet.getRelatorio());
        statement.setInt(6, pet.getTutorId());
        statement.execute();
        
        return pet;
    }
    
        
    public void update(Pet pet) throws SQLException{
        
        String sql = "UPDATE pet SET nome = ?, especie = ?, raca = ?, relatorio = ?, id_tutor = ? WHERE id_pet = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, pet.getNome());
        statement.setString(2, pet.getEspecie());
        statement.setString(3, pet.getRaca());
        statement.setString(4, pet.getRelatorio());
        statement.setInt(5, pet.getTutorId());
        statement.setInt(6, pet.getId());
        statement.execute();    
    }
    
    
    //ta 
    public void delete(Pet pet) throws SQLException{
                
        String sql = "DELETE from Pet WHERE id_pet = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, pet.getId());
        statement.execute();
    }
    
    public ArrayList<Pet> selectAll() throws SQLException{
        String sql = "SELECT * FROM pet";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }
    
    private ArrayList<Pet> pesquisa(PreparedStatement statement) throws SQLException{
        ArrayList<Pet> pets = new ArrayList<Pet>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id_pet");
            int tutorId = resultSet.getInt("id_tutor");
            String relatorio = resultSet.getString("relatorio");
            String nome = resultSet.getString("nome");
            int idade = resultSet.getInt("idade");
            String especie = resultSet.getString("especie");
            String raca = resultSet.getString("raca");
            
            Pet petComDados = new Pet(tutorId, nome, relatorio, especie, raca, idade);
            pets.add(petComDados);
        }
        return pets;
    }

    
    
    public Pet selectPorId(Pet pet) throws SQLException{
        
        String sql = "SELECT * FROM Pet WHERE id_pet = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pet.getId());
        
        return pesquisa(statement).get(0);  
    } 
    
}
