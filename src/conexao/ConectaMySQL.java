package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBNAME = "tarde_B_Lojinha";
    private final String URL = "jdbc:mysql://ESN509VMYSQL/" + DBNAME;
    private final String LOGIN = "aluno";
    private final String SENHA = "Senai1234";

    //Objeto da classeque sera usado para configurar o ip do banco e login e senha;

    private Connection conexao;

    //o metodo ira retornar o objeto retornado na conexao. ou seja, se tudo der certo retornara aberto, caso nao, fechado;
    public Connection startConnection(){
        try {
            Class.forName(DRIVER);
            //o metodo getConnction tenta iniciar a conexao com os valores passados como parametros
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Conexão ao banco de dados bem-sucedida!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }

    public void close(){
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conexão fechada.");
    }
}
