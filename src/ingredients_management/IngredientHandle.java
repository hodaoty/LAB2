/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingredients_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import my_ultils.Utils;

public class IngredientHandle {

    List<IngredientsInformation> ingreList = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public IngredientHandle() {
        super();
    }

    public void addFromFile(String fName) {
        try {
            File file = new File(fName);
            if (!file.exists()) {
                return;
            }

            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String info;
            while ((info = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(info, ":");
                String code = stk.nextToken();
                String name = stk.nextToken();
                int quantity = Integer.parseInt(stk.nextToken());
                int status = Integer.parseInt(stk.nextToken());
                IngredientsInformation ingredient = new IngredientsInformation(code, name, quantity, status);
                ingreList.add(ingredient);
            }
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile(String fName) {
        if (ingreList.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        try {
            File file = new File(fName);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            for (IngredientsInformation ingredient : ingreList) {
                pw.println(ingredient.getIngreCode() + ":" + ingredient.getIngreName() + ":" + ingredient.getIngreQuantity() + ":" + ingredient.getIngreStatus());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int findByCode(String info) {
        for (int i = 0; i < ingreList.size(); i++) {
            if (ingreList.get(i).getIngreCode().toUpperCase().equals(info.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }
    
    private int findByName(String info) {
        for(int i=0;i<ingreList.size();i++){
            if(ingreList.get(i).getIngreName().toUpperCase().equals(info.toUpperCase())) return i;
        }
        return -1;
    }

    private boolean checkNumber(String info) {
        int count = 0;
        for (int i = 0; i < info.toCharArray().length; i++) {
            if (!Character.isDigit(info.charAt(i))) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            System.out.println("Input number !!!");
            return false;
        }
    }

    public void addNewIngredient() {
        String code = "INGRE" + Utils.getGenerativeNumber(ingreList.size());
        String name;
        int quantity;
        int status = 0;
        name = Utils.getString("Enter name :", "Name not be null");
        quantity = Utils.getInt("Enter quantiry :", 0);
        IngredientsInformation ingredient = new IngredientsInformation(code, name, quantity, status);
        ingreList.add(ingredient);
        System.out.println("Add new Ingredient successfully !!!");
    }

    public void printList() {
        if (ingreList.isEmpty()) {
            return;
        }
        Collections.sort(ingreList);

        System.out.println("INGREDIENT LIST :");
        System.out.println("============================================");
        for (IngredientsInformation ingredient : ingreList) {
            if (ingredient.getIngreStatus() == 0) {
                System.out.println(ingredient);
            }
        }
    }

    public int searchIngredient() {
        int numberCode;
        System.out.print("Enter number of CODE :");
        numberCode = Integer.parseInt(sc.nextLine());
        String info = "INGRE" + numberCode;
        int check = findByCode(info);
        if (check == -1) {
            System.out.println("THE INGREDIENT DOES NOT EXITS");
            return -1;
        }
        return check;
    }

    public void updateIngredient() {
        int check = searchIngredient();
        if (check == -1) {
            return;
        } else {
            System.out.println("UPDATE INGREDIENT :" + ingreList.get(check));
            String name = Utils.getStringCanNull("Update new name :");
            if ("".equals(name)) {
                name = ingreList.get(check).getIngreName();
            }
            String quantity01 = Utils.getStringCanNull("Update new quantity : ");
            int quantity02;
            if ("".equals(quantity01)) {
                quantity02 = ingreList.get(check).getIngreQuantity();
            } else {
                quantity02 = Integer.parseInt(quantity01);
            }
            ingreList.get(check).setIngreName(name);
            ingreList.get(check).setIngreQuantity(quantity02);
            System.out.println(ingreList.get(check));
            System.out.println("UPDATED SUCCESSFULLY !!!");
        }

    }
    
    public void deleteIngredient(){
        int check = searchIngredient();
        if (check == -1 ) return;
        else {
            System.out.println("Do you want to delete this ingredient ?");
            String respone;
            respone = sc.nextLine();
            if(respone.toUpperCase().startsWith("Y")){
                ingreList.get(check).setIngreStatus(1);
                System.out.println("DELETE SUCCESSFULLY !!!");
            }else{
                System.out.println("DELETE UNSUCCESSFULLY !!!");
            }
        }
    }

}
