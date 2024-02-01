import java.sql.SQLException;
// Untuk memberikan perintah ke SQL
interface CRUD {
    void add() throws SQLException;
    void dataLaundry() throws SQLException;
    void update() throws SQLException;
    void delete() throws SQLException;
}