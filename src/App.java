import DAO.codigos_bancosDAO;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("oba");

        codigos_bancosDAO bancos = new codigos_bancosDAO();

        System.out.println("Banco" + bancos.listarProdutos());

    }
}
