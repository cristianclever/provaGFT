package br.com.gft.dish.contants;

public interface IDish {
	
	public static final int TYPE_ENTREE = 1;
	public static final int TYPE_SIDE = 2;
	public static final int TYPE_DRINK = 3;
	public static final int TYPE_DESSERT = 4;
	
	
	
	

	
	public int getType();

	public String getName();

	public int getOrder();
	
	public boolean isRepeatable() ;
	
}
