package restaurant;

class Store{
	private String number;
	private String storename;
	private String area;
	private String price;
	private String taste;
	private String favorite;
	
	public Store() {
		
	}
	public Store(String storename,String area,String price,String taste,String favorite) {
		this.storename=storename;
		this.area=area;
		this.price=price;
		this.taste=taste;
		this.favorite=favorite;		
	}

	public String getStoreName() {
		return storename;
	}

	public String getArea() {
		return area;
	}

	public String getPrice() {
		return price;
	}

	public String isTaste() {
		return taste;
	}

	public String getFavorite() {
		return favorite;
	}
	
	public void setStoreName(String storename) {
		this.storename = storename;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	public String export() {
		return (storename+"|"+area+"|"+price+"|"+taste+"|"+favorite);
	}
}
