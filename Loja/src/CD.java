
public class CD extends Produto {
	private String producer;
	private String releaseYear;
	
	public CD(int codigoDeBarras, String nome, String producer, String releaseYear) {
		super(codigoDeBarras, nome);
		this.producer = producer;
		this.releaseYear = releaseYear;
	}
	
	public CD(int codigoDeBarras, String nome,int avalableQuantity, String producer, String releaseYear) {
		super(codigoDeBarras, nome, avalableQuantity);
		this.producer = producer;
		this.releaseYear = releaseYear;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
}
