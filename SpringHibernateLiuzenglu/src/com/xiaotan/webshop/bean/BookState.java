package com.xiaotan.webshop.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "bookState")
public class BookState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookState_id")
	private Integer bookState_id;
	@Column(name = "book_State")
	private String book_State;

	 @ManyToMany(cascade=CascadeType.ALL)                                      //多对多关系  
	 @JoinTable(name="book_bookState",                     //中间表的名称
	 			joinColumns={@JoinColumn(name="bookState_id")},   //本表与中间表的外键对应关系
	             inverseJoinColumns={@JoinColumn(name="book_id")}) //另一张表与中间表的外键的对应关系
	private List<Book> bookList = new ArrayList<Book>();

	public String getBook_State() {
		return book_State;
	}

	public void setBook_State(String book_State) {
		this.book_State = book_State;
	}

	public Integer getBookState_id() {
		return bookState_id;
	}

	public void setBookState_id(Integer bookState_id) {
		this.bookState_id = bookState_id;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}


	

}
