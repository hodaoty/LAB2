/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe_management;


public class RecipeInformation {
    private String recipeCode;
    private String recipeInformation;

    public RecipeInformation(String recipeCode, String recipeInformation) {
        this.recipeCode = recipeCode;
        this.recipeInformation = recipeInformation;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public String getRecipeInformation() {
        return recipeInformation;
    }

    public void setRecipeInformation(String recipeInformation) {
        this.recipeInformation = recipeInformation;
    }
    
    
}
