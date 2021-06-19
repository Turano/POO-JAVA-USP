
public class Livro extends Produto {
	private String author;
	private int volume;
	private String edition;
	private String publishingCompany;
	private String publicationYear;	
	
	
	public Livro(int codigoDeBarras, String nome, String author, int volume, String edition,
			String publishingCompany, String publicationYear) {
		super(codigoDeBarras, nome);
		this.author = author;
		this.volume = volume;
		this.edition = edition;
		this.publishingCompany = publishingCompany;
		this.publicationYear = publicationYear;
	}
	
	public Livro(int codigoDeBarras, String nome, int availableQuantity, String author, int volume, String edition,
			String publishingCompany, String publicationYear) {
		super(codigoDeBarras, nome, availableQuantity);
		this.author = author;
		this.volume = volume;
		this.edition = edition;
		this.publishingCompany = publishingCompany;
		this.publicationYear = publicationYear;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getYear() {
		return publicationYear;
	}

	public void setYear(String year) {
		this.publicationYear = year;
	}
}
