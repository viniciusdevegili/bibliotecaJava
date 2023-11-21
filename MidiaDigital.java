import java.sql.Connection;
import java.sql.PreparedStatement;

public class MidiaDigital extends Midia {
    private String album;

    public MidiaDigital(String titulo, String album, boolean disponivel) {
        super(titulo, disponivel);
        this.album = album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return this.album;
    }

    public String toString() {
        return "Album: " + this.album + super.toString();
    }

    // criado o metodo adicionarMidiaDigital que recebe um objeto MidiaDigital, um
    // objeto Biblioteca e uma conexao com o banco de dados

    public static void adicionarMidiaDigital(Connection conn, MidiaDigital midiaDigital, Biblioteca biblioteca)
            throws Exception {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO midia_digital (titulo, album, disponivel, id_biblioteca) VALUES (?, ?, ?, ?)");
        ps.setString(1, midiaDigital.getTitulo());
        ps.setString(2, midiaDigital.getAlbum());
        ps.setBoolean(3, midiaDigital.getDisponivel());
        ps.setInt(4, biblioteca.getId());
        ps.executeUpdate();
    }

    // criado o metodo listarMidiasDigitais que recebe uma conexao com o banco de
    // dados

    public static void listarMidiasDigitais(Connection conn) throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM midia_digital");
        java.sql.ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("titulo") + " - " + rs.getString("album") + " - "
                    + (rs.getBoolean("disponivel") == true ? "Disponivel" : "Indisponivel"));
        }
    }

    // criado o metodo emprestar que recebe uma conexao com o banco de dados e um id

    public static void emprestar(Connection conn, int id) throws Exception {
        PreparedStatement ps = conn.prepareStatement("UPDATE midia_digital SET disponivel = false WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    // criado o metodo devolver que recebe uma conexao com o banco de dados e um id

    public static void devolver(Connection conn, int id) throws Exception {
        PreparedStatement ps = conn.prepareStatement("UPDATE midia_digital SET disponivel = true WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

}
