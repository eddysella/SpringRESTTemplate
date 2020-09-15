package com.RESTService.Template.JPA.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
// TODO: Change table name and columns
@Table(name = "template")
public class Template implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "longText", columnDefinition = "TEXT")
    private String longText;

    public Template() { }

    public Template(String longText) {
        this.longText = longText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return id == template.id &&
                longText.equals(template.longText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longText);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", longText='" + longText + '\'' +
                '}';
    }
}
