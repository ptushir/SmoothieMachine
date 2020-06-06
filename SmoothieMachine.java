package com.java.smoothie;

import java.util.Set;
import java.util.TreeSet;

/**
 * The Class SmoothieMachine.
 */
public class SmoothieMachine {

	/**
	 * The Enum Menu.
	 */
	enum Menu{ 
		  
  		/** The classic. */
  		CLASSIC("strawberry, banana, pineapple, mango, peach, honey"),
		  
  		/** The freezie. */
  		FREEZIE("blackberry, blueberry, black currant, grape juice, frozen yogurt"),
		  
  		/** The greenie. */
  		GREENIE("green apple, lime, avocado, spinach, ice, apple juice"),
		  
  		/** The just desserts. */
  		JUST_DESSERTS("banana, ice cream, chocolate, peanut, cherry");
	  
		  /** The selected item. */
  		private String selectedItem;
		  
  		/**
  		 * Instantiates a new menu.
  		 *
  		 * @param selectedItem the selected item
  		 */
  		private Menu(String selectedItem) { this.selectedItem = selectedItem; }
		  
  		/**
  		 * Gets the selected order.
  		 *
  		 * @return the selected order
  		 */
  		public String getSelectedOrder() { return selectedItem; } 
		  
  		/**
  		 * Sets the selected drink.
  		 *
  		 * @param item the new selected drink
  		 */
  		public void setSelectedDrink(String item) { this.selectedItem = item;}
	  }
	 
	/**
	 * Ingredients.
	 *
	 * @param order the order
	 * @return the string
	 */
	public String ingredients(String order) {
		String ingredients = "";
		String selectedItem;
		String selectedIngredients;
		String allergicIngredient;
		
		if(order == ""){
	        throw new IllegalArgumentException("No ingredients selected");
	      }else{
	        String[] orderArray = order.split(",");
	        selectedItem = orderArray[0].replaceAll(" ", "_");
	        switch(selectedItem.toUpperCase()) {
	        case "CLASSIC":
	        	selectedIngredients = Menu.CLASSIC.getSelectedOrder();
	          break;
	        case "FREEZIE":
	        	selectedIngredients = Menu.FREEZIE.getSelectedOrder();
	          break;
	        case "GREENIE":
	        	selectedIngredients = Menu.GREENIE.getSelectedOrder();
		          break;
	        case "JUST_DESSERTS":
	        	selectedIngredients = Menu.JUST_DESSERTS.getSelectedOrder();
		          break;
	        default:
	        	throw new IllegalArgumentException("Selected order not available");
	        }
	        
	        Set<String> sortedIngredients = new TreeSet<>();
	        for(String ingredient: selectedIngredients.split(",")) {
	        	sortedIngredients.add(ingredient);
	        }
	        
			if (orderArray.length > 1) {
				for (int i = 1; i < orderArray.length; i++) {
					if (orderArray[i].startsWith("-")) {
						allergicIngredient = orderArray[i].substring(1);
						if (sortedIngredients.contains(allergicIngredient)) {
							sortedIngredients.remove(allergicIngredient);
						}
					} else {
						throw new IllegalArgumentException("Additional ingredient not supported");
					}
				}
			}
			for(String ingredient: sortedIngredients) {
				ingredient = ingredient.trim();
				ingredients += ingredient + ","; 
			}
			ingredients = (String) ingredients.subSequence(0, ingredients.length()-1);
	     }
		
		return ingredients; 
	}
}
