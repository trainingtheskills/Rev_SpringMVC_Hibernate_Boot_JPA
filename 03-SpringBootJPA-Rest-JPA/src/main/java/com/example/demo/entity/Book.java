package com.example.demo.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity 
@Table(name="Book_revature")
//1. Declare variable
@NamedQuery(
		   name=Book.GET_Books_By_ID, 
		   query=Book.GET_Books_By_ID_QUERY
		   )
//@DynamicUpdate //Default -  include unmodified properties
public class Book {
	//2. Define variables
    public static final String GET_Books_By_ID = "GET_Books_By_ID";
	static final String GET_Books_By_ID_QUERY = "from Book b where b.id = :id";
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int  id;
	
	@Column(name="title",length=50)
	String title;
	
	@Column(name="author")
	String author;
	
	@Column(name="price")
	float price;
	public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
}
public Book(String title, String author, float price) {
	super();
	this.title = title;
	this.author = author;
	this.price = price;
}

}
