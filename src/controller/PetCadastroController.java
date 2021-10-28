package controller;

import dao.Conexao;
import dao.PetDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pet;
import view.PetCadastroView;

public class PetCadastroController {

    private PetCadastroView view;
        
    public PetCadastroController(PetCadastroView view){
        this.view = view;
    }
    
    public void salvaPet(){
        
        
        String tutorIdText = view.getjTextFieldIdTutor().getText();
        int tutorId = Integer.parseInt(tutorIdText);
        
        String nome = view.getjTextFieldPetNome().getText();
        String especie = view.getjTextFieldPetEspecie().getText();
        String raca = view.getjTextFieldPetRaca().getText();
        
        String idadeText = view.getjTextFieldPetIdade().getText();
        int  idade = Integer.parseInt(idadeText);
        String relatorio = view.getjTextAreaPetRelatorio().getText();
        
        Pet novoPet = new Pet (tutorId, nome, relatorio, especie, raca, idade);
        
        try{
            Connection conexao = new Conexao().getConnection();
            PetDAO petDao = new PetDAO(conexao);
            petDao.insert(novoPet);
            
            JOptionPane.showMessageDialog(null ,"Pet salvo com Sucesso");
            
        } catch(SQLException ex){
            System.out.println("Erro ao salvar pet");         
        }
        
        
    }
    
}
