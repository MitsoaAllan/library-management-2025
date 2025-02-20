import dao.AuthorCRUDOperations;
import db.DbConnection;
import entity.Author;
import entity.Sex;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnection db = new DbConnection();
        db.getConnection();
        Author mitsoa = new Author("Mitantsoa Allann",Sex.FEMALE,Date.valueOf("2005-06-04"));
        AuthorCRUDOperations authorOp = new AuthorCRUDOperations();
//        authorOp.create(mitsoa);
//        System.out.println(authorOp.findById(2));
//        System.out.println(authorOp.update(2,mitsoa));
    }
}