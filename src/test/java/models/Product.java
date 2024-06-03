package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder

public class Product{
	@JsonProperty("title")
	private String title;

	@JsonProperty("price")
	private Integer price;

	@JsonProperty("description")
	private String description;

	@JsonProperty("image")
	private String image;

	@JsonProperty("category")
	private String category;

	@JsonProperty("id")
	private Integer id;

	public Product(String title, Integer price, String description, String image, String category, Integer id) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
		this.id = id;
	}

	public Product() {
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(Integer price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}


	@Override
 	public String toString(){
		return 
			"Product{" + 
			"image = '" + image + '\'' + 
			",price = '" + price + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}