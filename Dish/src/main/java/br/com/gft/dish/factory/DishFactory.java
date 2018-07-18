package br.com.gft.dish.factory;

import br.com.gft.dish.contants.IDish;

public interface DishFactory {
	public IDish makeDishFrom(int val);
}
