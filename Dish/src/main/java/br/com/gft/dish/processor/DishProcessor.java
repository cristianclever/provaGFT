package br.com.gft.dish.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.gft.dish.contants.IDish;
import br.com.gft.dish.contants.TimeOfDay;
import br.com.gft.dish.factory.DishFactory;
import br.com.gft.dish.factory.MorningDishFactory;
import br.com.gft.dish.factory.NightDishFactory;

public class DishProcessor {

	public static String resolve(String in) {

		if (in == null || in.length() <= 2) {
			throw new IllegalArgumentException();
		}

		String args[] = in.replaceAll(" ", "").split(",");
		return process(args);

	}

	private static void prevalidate(String args[]) throws IllegalArgumentException {

		try {
			if (args[0] != null) {
				TimeOfDay td = TimeOfDay.valueOf(args[0].toUpperCase());
			}

			if (args == null || args.length <= 2) {
				throw new IllegalArgumentException();
			}

			Set<Integer> setValidOptions = new HashSet<Integer>();
			setValidOptions.add(IDish.TYPE_DESSERT);
			setValidOptions.add(IDish.TYPE_DRINK);
			setValidOptions.add(IDish.TYPE_ENTREE);
			setValidOptions.add(IDish.TYPE_SIDE);

			try {
				for (int i = 1; i < args.length; i++) {
					Integer tmp = Integer.parseInt(args[i]);

					if (!setValidOptions.contains(tmp)) {
						throw new IllegalArgumentException();
					}

				}
			} catch (Throwable e) {
				throw new IllegalArgumentException();
			}
		} catch (Throwable e) {
			throw new IllegalArgumentException("Invalid Option: valid options <MORNING|NIGHT> [dishes 1-4]+");
		}

	}

	private static String process(String args[]) throws IllegalArgumentException {

		TimeOfDay td = null;



		prevalidate(args);
		
		
		if (args[0] != null) {
			td = TimeOfDay.valueOf(args[0].toUpperCase());
		}
		List<IDish> listDish = new ArrayList<IDish>();

		DishFactory factory = null;
		if (td.equals(TimeOfDay.MORNING)) {
			factory = new MorningDishFactory();
		} else {
			factory = new NightDishFactory();
		}

		Map<IDish, Integer> mapAcumulator = new HashMap<>();
		for (int i = 1; i < args.length; i++) {
			int choice = Integer.parseInt(args[i]);

			IDish idish = factory.makeDishFrom(choice);

			if (!mapAcumulator.containsKey(idish)) {
				mapAcumulator.put(idish, Integer.valueOf(1));
			} else {
				// contains

				if (!idish.isRepeatable()) {
					throw new IllegalArgumentException("Dish type not Repeteable[ " + idish.getName() + "]");
				}

				Integer val = mapAcumulator.get(idish);
				mapAcumulator.put(idish, Integer.valueOf(val + 1));
			}
		}

		Set<IDish> setKeys = mapAcumulator.keySet();

		Comparator<IDish> byOrder = (IDish o1, IDish o2) -> Integer.valueOf(o1.getOrder()).compareTo(o2.getOrder());

		List<IDish> ltmp = new ArrayList<IDish>(setKeys);

		Collections.sort(ltmp, byOrder);

		StringBuilder sb = new StringBuilder();
		for (IDish iDish : ltmp) {

			sb.append(iDish.getName());

			if (iDish.isRepeatable()) {
				Integer count = mapAcumulator.get(iDish);
				if (count > 1) {
					sb.append("(x" + count + ")");
				}
			}

			sb.append(", ");

		}

		if (sb.length() > 1) {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		process(new String[] { "morning", "2", "1", "3" });
	}

}
