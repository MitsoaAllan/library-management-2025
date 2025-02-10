package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private Topic topic;
    private LocalDate releaseDate;
    private Integer pageNumbers;

    public Book(){

    }
    public Book(String id, String title, Topic topic, LocalDate releaseDate, Integer pageNumbers) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.pageNumbers = pageNumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(Integer pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", topic=" + topic +
                ", releaseDate=" + releaseDate +
                ", pageNumbers=" + pageNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && topic == book.topic && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(pageNumbers, book.pageNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, topic, releaseDate, pageNumbers);
    }
}
