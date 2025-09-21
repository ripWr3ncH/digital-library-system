interface Ebook{
	void display();
	void getTitle();
	void getSize();

}



class RealEbook implements Ebook {
	String book_name;
	String author;


	public RealEbook(String book_name, String author) {
		this.book_name = book_name;
		this.author = author;
		
	}

	public void display() {
		System.out.println("Book: " + book_name + " by " + author);
		
	}
}

class DelayEbook implements Ebook {
	private String book_name;
	private String author;
	private RealEbook realEbook;
	private boolean loaded = false;

	public DelayEbook(String book_name, String author) {
		this.book_name = book_name;
		this.author = author;

	}

	private void load() {
		if (!loaded) {
			realEbook = new RealEbook(book_name, author);
			loaded = true;
		}
	}

	public void display() {
		load();
		realEbook.display();
	}
}

class Test {
	public static void main(String[] args) {
		Ebook ebook1 = new RealEbook("Java Basics", "John Doe");
		Ebook ebook2 = new DelayEbook("Python Guide", "Jane Smith");

		System.out.println("Displaying RealEbook:");
		ebook1.display();

		System.out.println("\nDisplaying DelayEbook (loads on first display):");
		ebook2.display();
	}
}