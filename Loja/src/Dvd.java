
public class Dvd extends Produto {
	private String brand;
	private String manufacturingYear;
	
	public Dvd(int codigoDeBarras, String nome, String brand, String manufacturingYear) {
		super(codigoDeBarras, nome);
		this.brand = brand;
		this.manufacturingYear = manufacturingYear;
	}

	public Dvd(int codigoDeBarras, String nome, int avalableQuantity, String brand, String manufacturingYear) {
		super(codigoDeBarras, nome, avalableQuantity);
		this.brand = brand;
		this.manufacturingYear = manufacturingYear;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
}
