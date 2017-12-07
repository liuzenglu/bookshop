package com.xiaotan.webshop.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer book_id;
	@Column(name = "book_name")
	private String book_name;
	@Column(name = "book_author")
	private String book_author;
	@Column(name = "book_description")
	private String book_description;
	@Column(name = "book_publisher")
	private String book_publisher;
	@Column(name = "book_price")
	private Double book_price;
	@Column(name = "book_imgurl")
	private String book_imgurl;
	@ManyToOne()
	@JoinColumn(name = "type_id")
	private BookType bookType;

	@ManyToMany(cascade = CascadeType.ALL) // 指定多对多关系
	@JoinTable(name = "book_bookState", // 指定第三张表
			joinColumns = { @JoinColumn(name = "book_id") }, // 本表与中间表的外键对应
			inverseJoinColumns = { @JoinColumn(name = "bookState_id") }) // 另一张表与第三张表的外键的对应关系
	//@Lazy(value=false)	
	private List<BookState> bookStateList = new ArrayList<BookState>();

	@OneToMany(mappedBy = "book", targetEntity = Order_detail.class, cascade = CascadeType.ALL)
	private Set<Order_detail> orderDetailsSet = new HashSet<Order_detail>();

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public Double getBook_price() {
		return book_price;
	}

	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}

	public String getBook_imgurl() {
		return book_imgurl;
	}

	public void setBook_imgurl(String book_imgurl) {
		this.book_imgurl = book_imgurl;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Set<Order_detail> getOrderDetailsSet() {
		return orderDetailsSet;
	}

	public void setOrderDetailsSet(Set<Order_detail> orderDetailsSet) {
		this.orderDetailsSet = orderDetailsSet;
	}

	public List<BookState> getBookStateList() {
		return bookStateList;
	}

	public void setBookStateList(List<BookState> bookStateList) {
		this.bookStateList = bookStateList;
	}



	

	







}
