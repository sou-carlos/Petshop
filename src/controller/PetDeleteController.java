package controller;

import dao.Conexao;
import dao.PetDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pet;
import view.PetDeleteView;

public class PetDeleteController {
    
    
    private PetDeleteView view;
    
    public PetDeleteController(PetDeleteView view){
        this.view = view;
    }
    
    public void deletaPet(){
        
        String id_petString = view.getjTextFielIdPet().getText();
        int id_pet = Integer.parseInt(id_petString);
        
        Pet petDelete = new Pet (id_pet);
        
        try{
            Connection conexao = new Conexao().getConnection();
            PetDAO petDao = new PetDAO(conexao);
            petDao.delete(petDelete);
            
            JOptionPane.showMessageDialog(null ,"Pet deletado com Sucesso");
            
        }catch(SQLException ex){
            System.out.println("Erro Ao excluir o pet");   
        }
    }
}
