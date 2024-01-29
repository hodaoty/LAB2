/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_management;

public class MenuInformations {
    private String menuCode;
    private String menuName;
    private String menuRecipe;
    private int menuPrice;

    public MenuInformations(String menuCode, String menuName, String menuRecipe, int menuPrice) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuRecipe = menuRecipe;
        this.menuPrice = menuPrice;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuRecipe() {
        return menuRecipe;
    }

    public void setMenuRecipe(String menuRecipe) {
        this.menuRecipe = menuRecipe;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
    
    @Override
    public String toString(){
        return "Code :"+menuCode+" Name :"+menuName+" Recipe :"+menuRecipe+ "Price :"+menuPrice;
    }
    
}
