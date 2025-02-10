package dao;

import db.DbConnection;
import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCRUDOperations implements CRUDOperations{
    private final DbConnection db=new DbConnection();
    @Override
    public void save(Author author) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con=db.getConnection();
            ps=con.prepareStatement(
                "SELECT author_id" +
                " FROM author WHERE author_name=?"
            );
            ps.setString(1, author.getAuthorName());
            rs=ps.executeQuery();
            if(rs.next()){
                ps=con.prepareStatement(
                    "UPDATE author SET author_name=?, birth_date=? WHERE author_id=?"
                );
                ps.setString(1, author.getAuthorName());
                ps.setDate(2,author.getBirthdate());
                ps.setInt(3,author.getAuthorId());
                ps.executeUpdate();
                System.out.println("Author updated");
            }else {
                ps=con.prepareStatement(
                "INSERT INTO author (author_name,birth_date)" +
                    "VALUES (?,?)"
                );
                ps.setString(1,author.getAuthorName());
                ps.setDate(2,author.getBirthdate());
                ps.executeUpdate();
                System.out.println("Author created");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            closeConnection(con,ps,rs);
        }
    }

    @Override
    public void delete(Author author) {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=db.getConnection();
            ps = con.prepareStatement("delete from authors where id=?");
            author = new Author();
            ps.setInt(1,author.getAuthorId());
            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("Author deleted successfully");
            }else{
                System.out.println("Author deletion failed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> findAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            ps = con.prepareStatement("select * from author");
            rs = ps.executeQuery();
            List<Author> authors = new ArrayList<>();
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setBirthdate(rs.getDate("birth_date"));
                authors.add(author);
            }
            return authors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null) con.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
