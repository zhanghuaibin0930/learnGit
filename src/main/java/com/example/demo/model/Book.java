package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


@JsonInclude(value= JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    private String _id;
    private String bname;
    private double price;
    private String author;

    public Book(String bname,double price,String author){
        this.bname = bname;
        this.price = price;
        this.author = author;
    }
}
