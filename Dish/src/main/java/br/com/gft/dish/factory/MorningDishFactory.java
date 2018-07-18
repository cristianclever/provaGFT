package br.com.gft.dish.factory;

import br.com.gft.dish.contants.IDish;
import br.com.gft.dish.contants.MorningDish;

public class MorningDishFactory implements DishFactory{

	
	
	public IDish makeDishFrom(int val) {
		IDish m = MorningDish.valueOf(val);
		return m;
	}

}
