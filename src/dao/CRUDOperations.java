package dao;

import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface CRUDOperations<T> {
    T create(T author);
    T update(int id,T newAuthor);
    T findById(int id) throws Exception;
    void delete(int id);

    List<T> findAll(int page, int size);
    void closeConnection(Connection con, PreparedStatement ps, ResultSet rs);

}
