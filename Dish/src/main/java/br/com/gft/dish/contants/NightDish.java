package br.com.gft.dish.contants;

public enum NightDish implements IDish{


	
	STEAK(TYPE_ENTREE,"steak",1,false),
	POTATO(TYPE_SIDE,"potato",2,true),
	WINE(TYPE_DRINK,"wine",3,false),
	CAKE(TYPE_DESSERT,"cake",4,false);

	private int type;
	private String name;
	private int order;
	private boolean repeatable;
	


	private NightDish(int type,String name, int order,boolean repeatable) {
		this.type=type;
		this.name=name;
		this.order=order;
		this.repeatable=repeatable;
	}	
	
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getOrder() {
		return order;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	

	
	public  static IDish valueOf(int num) {
		NightDish retorno = null;

		NightDish dish[] = NightDish.values();
		for (int i = 0; i < dish.length; i++) {

			if (dish[i].getType() == num) {
				retorno = dish[i];
				break;
			}
		}

		return retorno;

	}
	
}

