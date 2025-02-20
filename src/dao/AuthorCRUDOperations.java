package dao;

import db.DbConnection;
import entity.Author;
import entity.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorCRUDOperations implements CRUDOperations<Author> {
    private final DbConnection db=new DbConnection();
    @Override
    public Author create(Author author) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con=db.getConnection();
            ps=con.prepareStatement(
            "INSERT INTO author (author_name,sex,birth_date)" +
                "VALUES (?,?,?)"
            );
            ps.setString(1,author.getAuthorName());
            ps.setString(2,String.valueOf(author.getSex()));
            ps.setDate(3,author.getBirthdate());
            ps.executeUpdate();
            System.out.println("Author created");
            return author;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            closeConnection(con,ps,null);
        }
    }

    @Override
    public Author update(int id,Author newAuthor) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = """
                UPDATE author SET
                author_name = ?,
                sex = ?,
                birth_date = ?
                WHERE author_id = ?
                """;
        try{
            con=db.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1,newAuthor.getAuthorName());
            ps.setString(2,newAuthor.getSex().toString());
            ps.setDate(3,newAuthor.getBirthdate());
            ps.setInt(4,id);
            ps.executeUpdate();
            return this.findById(newAuthor.getAuthorId());

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Author findById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = """
                SELECT * FROM author a WHERE author_id = ?
                """;
        try {
            con = db.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name"),
                        Sex.valueOf(rs.getString("sex")),
                        rs.getDate("birth_date")
                );
            }else{
                return null;
            }
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }finally {
            closeConnection(con,ps,rs);
        }
    }
    @Override
    public void delete(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=db.getConnection();
            ps = con.prepareStatement("delete from author where author_id=?");
            Author authorToDel =this.findById(id);
            ps.setInt(1,authorToDel.getAuthorId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally{
            closeConnection(con,ps,null);
        }
    }

    @Override
    public List<Author> findAll(int page,int size) {
        if (page < 1){
            throw new IllegalArgumentException("page must be greater than 0 actual is "+page);
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            ps = con.prepareStatement("select a.author_id, a.author_name,a.sex, a.birth_date from author a ORDER BY a.author_id LIMIT ? OFFSET ?");
            ps.setInt(1,page);
            ps.setInt(2,size * (page - 1));
            rs = ps.executeQuery();
            List<Author> authors = new ArrayList<>();
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setSex(Sex.valueOf(rs.getString("sex")));
                author.setBirthdate(rs.getDate("birth_date"));
                authors.add(author);
            }
            return authors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(con,ps,rs);
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
