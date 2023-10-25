package comandos;

import conexao.ConectaMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ComandosProdutos {
    Connection conexao;
    public boolean inserirBD(String produto, String categoria, float preco) {
        String comando = "INSERT INTO tb_produto Values(null,?,?,?);";

        //conexão do banco de dados
        ConectaMySQL conecta = new ConectaMySQL();
        conexao = conecta.startConnection();

        //Preperar a conexão com o comando que será executado nela
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);

            //passagem de valores para cada ? do comando INSERT
            ps.setString(1, produto);
            ps.setString(2, categoria);
            ps.setFloat(3, preco);

            //Execução do comando no Banco de Dados e teste do que foi retornado
            if (ps.executeUpdate() != 0) {
                //Se alterou pelo menos 1 linha então o INSERT deu certo
                conexao.close();//Fecha a conexão e libera o recurso


                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    //PESQUISA
    /*Método precebe um argumento para executar um comando de SELECT
     *no banco de dados e imprimir/exibir os valores que estão na tabela*/

    /******FEITO POR LUQUINHAS******/
//    public void deletarProduto(String comando) {
//        conexao = new ConectarMySql().iniciarConexao();
//        try {
//            PreparedStatement ps = conexao.prepareStatement(comando);
//            ps.executeUpdate();
//            conexao.close();
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void pesquisarProduto(String comando) {
        //conexão do banco de dados
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            //Para recuperar os valores que o comando SELECT vai retornar do
            //banco de dados, devemos armazenar eles em um objeto do tipo
            //ResultSet

            ResultSet resultado = ps.executeQuery();
            //Percorrer os valores que o SELETCT buscou
            System.out.println("Código:\tnome\t\tCategoria\tPreço ");

            while (resultado.next()) {//Enquanto tiverem linhas na tabela
                System.out.println(resultado.getInt(1) + "\t" + resultado.getString(2) + "\t\t" + resultado.getString(3) + "\t\t" + resultado.getFloat(4));

                System.out.println();//imprimi uma linha linha em branco
            }
            //Encerra a conexão
            conexao.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisarCliente(String comando) {
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ResultSet resultado = ps.executeQuery();
            System.out.println("Código\tNome\tCPF\tData Nascimento");
            while (resultado.next()) {

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");//Formato do BD
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data = out.format(in.parse(resultado.getDate(4).toString()));
                System.out.println(resultado.getInt(1) + "\t" + resultado.getString(2) + "\t\t" + resultado.getString(3) + "\t" + data);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void PesquisarVenda(String comando) {
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ResultSet resultado = ps.executeQuery();
            System.out.println("Código\tQuantidade\t\tData Venda\t\tCódigo Cliente\tCódigo Produto ");
            while (resultado.next()) {
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data = out.format(in.parse(resultado.getDate(3).toString()));
                //System.out.println(resultado.getInt(1) + "\t" + resultado.getInt(2) + data + "\t" + resultado.getInt(4) + "\t" + resultado.getInt(5);
                System.out.println(resultado.getInt(1) + "\t\t" + resultado.getInt(2) + "\t\t\t" + data + "\t\t\t" +
                        resultado.getInt(4) + "\t\t\t\t" + resultado.getInt(5));

                System.out.println();//imprimi uma linha linha em branco
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletarProduto(String comandoSQL) {
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comandoSQL);
            if (ps.executeUpdate() != 0) {
                conexao.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deletarCliente(String comandoSQL) {
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comandoSQL);
            if (ps.executeUpdate() != 0) {
                conexao.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deletarVenda(String comandoSQL) {
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(comandoSQL);
            if (ps.executeUpdate() != 0) {
                conexao.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean alterarProdutos(String comando){
        conexao = new ConectaMySQL().startConnection();
        try {
            PreparedStatement pr = conexao.prepareStatement(comando);
            if (pr.executeUpdate() != 0) {
                conexao.close();
                System.out.println("Alterado com sucesso!");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
