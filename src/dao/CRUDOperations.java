package dao;

import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface CRUDOperations {
    void save(Author author);
    void delete(Author author);
    List<Author> findAll();
    void closeConnection(Connection con, PreparedStatement ps, ResultSet rs);

}
