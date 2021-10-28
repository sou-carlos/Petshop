package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Tutor;

public class TutorDAO {
    
    private final Connection connection;
    
    public TutorDAO(Connection connection){
        this.connection = connection;
    }
    
    public Tutor insert(Tutor tutor) throws SQLException{

        String sql = "INSERT INTO tutor (nome,senha) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, tutor.getUsuario());
        statement.setString(2, tutor.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getGeneratedKeys();
        
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            tutor.setId(id);
        }
        
        return tutor;
        
    }
    
    public void update(Tutor tutor) throws SQLException{
        
        String sql = "update tutor set nome = ?, senha = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, tutor.getUsuario());
        statement.setString(2, tutor.getSenha());
        statement.setInt(3, tutor.getId());
        statement.execute();
    }
    
    public void inserOrUpdate(Tutor tutor) throws SQLException{
        
        if(tutor.getId() > 0){
            update(tutor);
        }else{
            insert(tutor);
        }
        
    }
    
    public void delete(Tutor tutor) throws SQLException{
                
        String sql = "delete from tutor where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, tutor.getId());
        statement.execute();
    }
    
    public ArrayList<Tutor> selectALL() throws SQLException{
        
        String sql = "select * from tutor";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Tutor> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Tutor> tutores = new ArrayList<>();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            
            Tutor tutorComDadosDoBanco = new Tutor(id, nome, senha);
            tutores.add(tutorComDadosDoBanco);
        }
         
        return tutores;
    }
    
    public Tutor selectPorId(Tutor tutor) throws SQLException{
                
        String sql = "select * from tutor where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tutor.getId());

        return pesquisa(statement).get(0);
        
    }
            

    public boolean existeNoBancoEsteUsuarioESenha(Tutor tutor) throws SQLException {
        
        String sql = "select * from tutor where nome = ?  and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);  
        
        statement.setString(1, tutor.getUsuario());
        statement.setString(2, tutor.getSenha());
        statement.execute();
        
        
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
}
