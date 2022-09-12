package ca.guusto.merchant.model;

import lombok.Data;

@Data
public class Merchant{
	
	private Long id;
	private String name;
	private String currency;
	private ShoppingOption shoppingOption;
	
	public Merchant(Long id, String name, String currency) {
		super();
		this.id = id;
		this.name = name;
		this.currency = currency;
	}
	
}

