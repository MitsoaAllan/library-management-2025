import dao.AuthorCRUDOperations;
import db.DbConnection;
import entity.Author;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        db.getConnection();
        Author mitsoa = new Author("Mitantsoa Alla", Date.valueOf("2003-07-06"));
        AuthorCRUDOperations authorOp = new AuthorCRUDOperations();
//        authorOp.save(mitsoa);
        System.out.println(authorOp.findAll());
    }
}