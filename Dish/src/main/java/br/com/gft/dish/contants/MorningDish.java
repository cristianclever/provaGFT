package br.com.gft.dish.contants;

public enum MorningDish implements IDish {

	EGGS(TYPE_ENTREE, "eggs", 1,false), 
	TOAST(TYPE_SIDE, "toast", 2,false), 
	COFFEE(TYPE_DRINK, "coffee",3,true), 
	NOT_APPLICABLE(TYPE_DESSERT, "error", 4,false);

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
	
	private int type;
	private String name;
	private int order;
	private boolean repeatable;
	
	private MorningDish(int type, String name, int order,boolean repeatable) {
		this.type = type;
		this.name = name;
		this.order = order;
		this.repeatable=repeatable;
	}

	public static IDish valueOf(int num) {
		MorningDish retorno = null;

		MorningDish morningDish[] = MorningDish.values();
		for (int i = 0; i < morningDish.length; i++) {

			if (morningDish[i].getType() == num) {
				retorno = morningDish[i];
				break;
			}
		}

		return retorno;

	}

}
