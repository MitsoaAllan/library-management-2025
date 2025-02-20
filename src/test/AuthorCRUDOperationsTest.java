//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import dao.AuthorCRUDOperations;
//import db.DbConnection;
//import entity.Author;
//import entity.Sex;
//import jdk.jfr.Unsigned;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.List;
//
//
//@ExtendWith(MockitoExtension.class)
//class AuthorCRUDOperationsTest {
//    @Mock
//    private DbConnection dbConnection;
//
//    @Mock
//    private Connection connection;
//
//    @Mock
//    private PreparedStatement preparedStatement;
//
//    @Mock
//    private ResultSet resultSet;
//
//    @Mock
//    AuthorCRUDOperations subject;
//
//    @Test
//    void create_author_ok() {
//        Author expected = authorRado();
//
//        Author actual = subject.create(expected);
//        assertEquals(expected, actual);
//    }
//
////    @Test
////    void find_author_by_id_ok() throws SQLException {
////        Author expected = authorRado();
////        subject.create(expected);
////
////        Author actual = subject.findById(expected.getAuthorId());
////        assertEquals(expected, actual);
////    }
//    @Test
//    void find_author_ok() throws SQLException {
//        Author expected = authorRado();
//
//        when(dbConnection.getConnection()).thenReturn(connection);
//        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
//        when(preparedStatement.executeQuery()).thenReturn(resultSet);
//        when(resultSet.next()).thenReturn(true);
//        when(resultSet.getInt("author_id")).thenReturn(expected.getAuthorId());
//        when(resultSet.getString("author_name")).thenReturn(expected.getAuthorName());
//        when(resultSet.getString("sex")).thenReturn(expected.getSex().toString());
//        when(resultSet.getDate("birth_date")).thenReturn(expected.getBirthdate());
//
//        Author actual = subject.findById(authorRado().getAuthorId());
//
//        assertEquals(expected, actual);
//
//    }
//    @Test
//    void update_author_ok() throws SQLException {
//        Author expected = authorRado();
//
//        Author actual = subject.update(expected.getAuthorId(), expected);
//        assertEquals(expected, actual);
//    }
//    private Author authorRado() {
//        return newAuthor(2, "Rado",Sex.MALE, Date.valueOf("1990-01-01")); // ID en int
//    }
//
//    private Author authorJJR() {
//        Author expectedAuthor = new Author();
//        expectedAuthor.setAuthorId(1); // ID en int
//        expectedAuthor.setAuthorName("JJR");
//        expectedAuthor.setBirthdate(Date.valueOf("2000-01-01"));
//        return expectedAuthor;
//    }
//
//    private Author newAuthor(int id, String name,Sex sex, Date birthDate) { // ID en int
//        Author author = new Author();
//        author.setAuthorId(id);
//        author.setAuthorName(name);
//        author.setSex(sex);
//        author.setBirthdate(birthDate);
//        return author;
//    }
//}