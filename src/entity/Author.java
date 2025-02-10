package entity;

import java.sql.Date;
import java.util.Objects;

public class Author {
    private int authorId;
    private String authorName;
    private Date birthdate;

    public Author(){

    }
    public Author(String author_name, Date birthdate) {
        this.authorName = author_name;
        this.birthdate = birthdate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorIdd) {
        this.authorId = authorIdd;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + authorId +
                ", author_name='" + authorName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(authorName, author.authorName) && Objects.equals(birthdate, author.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, birthdate);
    }
}

