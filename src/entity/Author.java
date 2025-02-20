package entity;

import java.sql.Date;
import java.util.Objects;

public class Author {
    private int authorId;
    private String authorName;
    private Sex sex;
    private Date birthdate;

    public Author() {

    }

    public Author(String author_name, Sex sex, Date birthdate) {
        this.authorName = author_name;
        this.sex = sex;
        this.birthdate = birthdate;
    }
    public Author(int authorId,String author_name, Sex sex, Date birthdate) {
        this.authorId = authorId;
        this.authorName = author_name;
        this.sex = sex;
        this.birthdate = birthdate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;
        return authorId == author.authorId && Objects.equals(authorName, author.authorName) && sex == author.sex && Objects.equals(birthdate, author.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, sex, birthdate);
    }
}