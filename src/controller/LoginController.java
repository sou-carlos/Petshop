
package controller;

import dao.Conexao;
import dao.TutorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Tutor;
import view.LoginView;
import view.MenuView;

public class LoginController {
    
    private LoginView view;
    
    public LoginController(LoginView view){
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Pega a senha e o usuario e passa pro objeto usuario
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        Tutor usuarioAutenticar = new Tutor(usuario, senha);
        
        
        //Verificar o usuario
        Connection conexao = new Conexao().getConnection();
        TutorDAO usuarioDao = new TutorDAO(conexao);
        
        
        boolean existe = usuarioDao.existeNoBancoEsteUsuarioESenha(usuarioAutenticar);
        
        if(existe){
            MenuView TelaDeMenu = new MenuView();
            TelaDeMenu.setVisible(true);  
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
        }
    }
}
