package com.codegym.model;

import com.codegym.dto.BlogDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedNativeQuery(name = "Blog.findBlogDtoById",
        query = "select * from Blog where id = :id",
        resultSetMapping = "Mapping.PlayerNameDto")
@SqlResultSetMapping(name = "Mapping.PlayerNameDto",
        classes = @ConstructorResult(targetClass = BlogDto.class,
                columns = {@ColumnResult(name = "author"),
                        @ColumnResult(name = "status"),
                        @ColumnResult(name = "category"),
                        @ColumnResult(name = "day")
                }))

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    private String author;

    @Column(columnDefinition = "DATE")
    private String day;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String status, String author, String day) {
        this.id = id;
        this.status = status;
        this.author = author;
        this.day = day;
    }
}
