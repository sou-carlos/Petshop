package controller;

import dao.Conexao;
import dao.TutorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Tutor;
import view.FormCadastroView;

public class FormCadastroController {
    
    private  FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }
    
    
    public void salvaUsuario(){    
         
       String usuario =  view.getjTextFieldUsuario().getText();
       String senha = view.getjPasswordFieldSenha().getText();
               
       Tutor novoUsuario = new Tutor(usuario, senha);
       
        try {
            Connection conexao = new Conexao().getConnection();
            TutorDAO usuarioDao = new TutorDAO(conexao);
            usuarioDao.insert(novoUsuario);
            
            JOptionPane.showMessageDialog(null ,"Usuario salvo com Sucesso");
            
        } catch (SQLException ex) {
            System.out.println("Erro");           
        }
    }
    
}
