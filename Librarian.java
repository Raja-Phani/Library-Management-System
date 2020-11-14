package com.lms.library;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Librarian extends Thread implements Serializable
{
	private Scanner scan=new Scanner(System.in);
	public void access()
	{
		BookDTO bookDTO = new BookDTO();
		BookDAO bookAccessObject = bookDTO.bookDAO();//Revise Abstraction
		
		System.out.println("Press 1 to add a book...");
		System.out.println("Press 2 to search a book using book Title...");
		System.out.println("Press 3 to search a book using author name...");
		System.out.println("Press 4 to search a book using book Title,Author & Edition...");
		System.out.println("Press 5 to update a book...");
		System.out.println("Press 6 to remove a book...");
		
		System.out.println("Enter your choice...");
		
		int choice=scan.nextInt();
		if(choice==1)
		{
			System.out.println("-------Please Enter Book Details-----------");
			System.out.println("Enter BookTitle");
			String title=scan.next();
			System.out.println("Enter Author Name");
			String author=scan.next();
			System.out.println("Enter genre...");
			String genre=scan.next();
			System.out.println("Enter the edition...");
			int edition=scan.nextInt();
			System.out.println("Enter the Price");
			int price=scan.nextInt();
			Book book=new Book(title,author,genre,edition,price);
			bookAccessObject.addBook(book);
		}
		else if(choice==2)
		{
			System.out.println("-------Please Enter a Book title to Search------------");
			String bookTitle=scan.next();	
			bookAccessObject.searchBookByTitle(bookTitle);
			
		}
		else if(choice==3)
		{
			System.out.println("-------Please Enter Book Author Name to Search-------");
			String bookAuthor=scan.next();
			bookAccessObject.searchBookByAuthor(bookAuthor);
		}
		else if(choice==4)
		{
			System.out.println("Enter Book Title");
			String bookTitle=scan.next();
			System.out.println("Enter Book Author");
			String bookAuthor=scan.next();
			System.out.println("Enter Book Edition Number");
			int edition=scan.nextInt();
			bookAccessObject.search(bookTitle, bookAuthor, edition);
		}
		else if(choice==5)
		{
			System.out.println("Enter the New Values to the book");
			System.out.println("Update Book Title");
			String bookTitle=scan.next();
			System.out.println("Update Author Name");
			String bookAuthor=scan.next();
			System.out.println("Update Book Genre");
			String bookGenre=scan.next();
			System.out.println("Update Book Edition");
			int bookEdition=scan.nextInt();
			System.out.println("Update Book Price");
			int bookPrice=scan.nextInt();
			Book book=new Book(bookTitle,bookAuthor,bookGenre,bookEdition,bookPrice);
			bookAccessObject.updateBook(book);
			
		}
		else if(choice==6)
		{
			System.out.println("Enter Book Title,Author,genre,edition and its price to delete the book");
			String title=scan.next();
			String author = scan.next();
			String genre = scan.next();
			int edition = scan.nextInt();
			
			int price = scan.nextInt();
			Book book=new Book(title,author,genre,edition,price);
			bookAccessObject.RemoveBook(book);
		}
		
		else
		{
			throw new InvalidChoiceException();
		}
		
	}
	
	public void run()
	{
		
		System.out.println("Welcome to Library Management System....");
		char c;
		do
		{
			access();
			System.out.println("Press 'Y' to continue....");
			System.out.println("Press 'N' to stop....");
			c=scan.next().charAt(0);
		}
		while(c=='y'||c=='Y');
		System.out.println("Thank you visit us again....");
	}
		

}
