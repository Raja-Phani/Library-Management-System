package com.lms.library;

import java.util.ArrayList;
//import java.util.Iterator;

public class BookDTO 
{
	private static ArrayList<Book> bookList=new ArrayList<Book>();
	
	public BookDAO bookDAO()
	{
		return new BookDAOImple();
	}
	private class BookDAOImple implements BookDAO 
	{
		public void addBook(Book book) 
		{
			bookList.add(book);
		}

		public ArrayList<Book> searchBookByTitle(String bookTitle)
		{
			for(Book i1:bookList)
			{
				if(i1.getBookTitle().equals(bookTitle))
				{
					System.out.println("Title Found @ "+i1);
					break;
				}
				else
				{
					System.out.println("Title Not Found @ ");
				}
			}
			System.out.println("------------------Please Add Books--------------------------");
			return null;
		}

		public ArrayList<Book> searchBookByAuthor(String bookAuthor) 
		{
			for(Book i1:bookList)
			{
				if(i1.getBookAuthor().equals(bookAuthor))
				{
					System.out.println("Author Found @ "+i1);
					break;
				}
				else
				{
					System.out.println("Author Not Found @ "+i1);
				}
			}
			System.out.println("------------------Please Add Books--------------------------");
			return null;
		}

		public Book search(String bookTitle, String bookAuthor, int edition) 
		{
			
			for(Book i1:bookList)
			{
				if((i1.getBookTitle().equalsIgnoreCase(bookTitle)) && (i1.getBookAuthor().equals(bookAuthor)) && (i1.getBookEdition()==edition))
				{
					System.out.println("Title,Author & Edition are Found @ "+i1);
					break;
				}
				else
				{
					System.out.println("Title,Author & Edition are Not Found @ "+i1);
				}
				
			}
			System.out.println("------------------Please Add Books--------------------------");
			return null;
		}

		public boolean updateBook(Book book) 
		{
			System.out.println(bookList);
			System.out.println("Updated Values of "+book);
			return false;
		}

		public boolean RemoveBook(Book book) 
		{
			bookList.remove(book);
			return true;
			
		}
		
	}

}
