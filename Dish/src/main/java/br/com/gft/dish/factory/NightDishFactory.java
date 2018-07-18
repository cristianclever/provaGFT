package br.com.gft.dish.factory;

import br.com.gft.dish.contants.IDish;
import br.com.gft.dish.contants.MorningDish;
import br.com.gft.dish.contants.NightDish;

public class NightDishFactory implements DishFactory{

	public IDish makeDishFrom(int val) {
		IDish m = NightDish.valueOf(val);
		return m;
	}

}
