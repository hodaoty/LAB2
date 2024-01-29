/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredients_management;


public class IngredientsInformation implements Comparable<IngredientsInformation>{
    private String ingreCode;
    private String ingreName;
    private int ingreQuantity;
    private int ingreStatus;

    public IngredientsInformation(String ingreCode, String ingreName, int ingreQuantity, int ingreStatus) {
        this.ingreCode = ingreCode;
        this.ingreName = ingreName;
        this.ingreQuantity = ingreQuantity;
        this.ingreStatus = ingreStatus;
    }

    public int getIngreStatus() {
        return ingreStatus;
    }

    public void setIngreStatus(int ingreStatus) {
        this.ingreStatus = ingreStatus;
    }

    public String getIngreCode() {
        return ingreCode;
    }

    public void setIngreCode(String ingreCode) {
        this.ingreCode = ingreCode;
    }

    public String getIngreName() {
        return ingreName;
    }

    public void setIngreName(String ingreName) {
        this.ingreName = ingreName;
    }

    public int getIngreQuantity() {
        return ingreQuantity;
    }

    public void setIngreQuantity(int ingreQuantity) {
        this.ingreQuantity = ingreQuantity;
    }
    
    @Override
    public String toString(){
        return "Code : "+ ingreCode+" Name : "+ ingreName+" Quantity : "+ ingreQuantity;
    }

    @Override
    public int compareTo(IngredientsInformation t) {
        return this.getIngreName().compareTo(t.getIngreName());
    }
    
    
    
    
}
