/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import my_ultils.Utils;
import recipe_management.RecipeInformation;

public class MenuHandle {

    List<MenuInformations> menuList = new ArrayList();
    List<RecipeInformation> recipeList = new ArrayList();

    Scanner sc = new Scanner(System.in);
    HashMap<String, String> recipeMap = new HashMap<>();
    public MenuHandle() {
        super();
    }


    public void addFromFileMenu(String fName) {
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
                String recipe = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                int status = Integer.parseInt(stk.nextToken());
                MenuInformations menu = new MenuInformations(code, name, recipe, price, status);
                menuList.add(menu);
            }
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void saveToFileMenu(String fName) {

    

        if (menuList.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (MenuInformations menu : menuList) {
                pw.println(menu.getMenuCode() + ":" + menu.getMenuName() + ":" + menu.getMenuRecipe() + ":" + menu.getMenuPrice() + ":" + menu.getMenuStatus());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addFromFileRecipe(String fName) {
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
                String information = stk.nextToken();
                RecipeInformation recipe = new RecipeInformation(code, information);
                recipeList.add(recipe);

            }
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFileRecipe(String fName) {
        if (menuList.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (RecipeInformation recipe : recipeList) {
                pw.println(recipe.getRecipeCode() + ":" + recipe.getRecipeInformation());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewMenu() {
        String code = "MN" + Utils.getGenerativeNumber(menuList.size());
        String name;
        String recipeOfMenu;
        int price;
        int status = 0; // gia tri ban dau
        boolean check = true;
        name = Utils.getString("Enter new drink :", "Name not be null");
        System.out.println("Enter the Recipe");
        String info = "";
        do {

            String nameOfIngredient;
            int quantityOfIngredient;
            nameOfIngredient = Utils.getString("Enter name of Ingredient :", "Name not be null");
            quantityOfIngredient = Utils.getInt("Enter quantity :", 0);
            info = info + nameOfIngredient + " " + quantityOfIngredient;
            String respone;
            System.out.print("Coutinue ??");
            respone = sc.nextLine();
            if (respone.toUpperCase().startsWith("N")) {
                check = false;
            }

        } while (!check);
        recipeOfMenu = "RP" + Utils.getGenerativeNumber(recipeList.size());
        String recipeCode = recipeOfMenu;
        RecipeInformation recipe = new RecipeInformation(recipeCode, info);
        recipeList.add(recipe);
        price = Utils.getInt("Enter price :", 0);
        MenuInformations menu = new MenuInformations(code, name, recipeOfMenu, price, status);

    }


    private int findByCode(String info) {
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getMenuCode().toUpperCase().equals(info.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }


    private int findRecipe(String info) {
        for (int i = 0; i < recipeList.size(); i++) {
            if (info.toUpperCase().equals(recipeList.get(i).getRecipeCode().toUpperCase())) {
                return i;
            }

        }
        return -1;
    }

    public void deleteMenu() {
        String info;
        info = Utils.getString("Enter code of drink :", "Code not be null");

        int check = findByCode(info);
        if (check == -1) {
            System.out.println("Don't find this drink");
        } else {
            System.out.println("Are you sure ?? Y/N");
            String respone;
            respone = sc.next();
            if (respone.toUpperCase().startsWith("Y")) {
                menuList.get(check).setMenuStatus(1);
                System.out.println("Delete success !!!");
            } else {
                System.out.println("Delete fail !!!");
            }
        }
    }

    public void printListMenu() {
        if (menuList.isEmpty()) {
            return;
        }
        Collections.sort(menuList);
        System.out.println("MENU LIST :");
        System.out.println("============================");
        for (MenuInformations menu : menuList) {
            if (menu.getMenuStatus() == 0) {
                System.out.println(menu.getMenuName() + "     Price :" + menu.getMenuPrice());
            }
        }

    }

    public void updateMenuDrink() {
        String info;
        info = Utils.getString("Enter code of DRINK :", "Code not be null");
        int check = findByCode(info);
        if (check == -1) {
            System.out.println("The drink does not exits");
        } else {
            String name;
            String recipe;
            String price01;
            int price;
            String info02 = "";
            boolean check02 = true;
            name = Utils.getStringCanNull("Enter new name :");
            if ("".equals(name)) {
                name = menuList.get(check).getMenuName();
            }
            System.out.println("Do you want to enter new recipe? : Y/N");
            String rp = sc.nextLine();
            if (rp.toUpperCase().startsWith("N")) {
                recipe = menuList.get(check).getMenuRecipe();
            } else {
                do {
                    String nameOfIngredient;
                    int quantityOfIngredient;
                    nameOfIngredient = Utils.getStringCanNull("Enter name of Ingredient :");
                    if (nameOfIngredient.equals("")) {
                        check02 = false;
                    }
                    quantityOfIngredient = Utils.getInt("Enter quantity :", 0);
                    info02 = info02 + nameOfIngredient + " " + quantityOfIngredient;
                    String respone;
                    System.out.print("Coutinue ??");
                    respone = sc.nextLine();
                    if (respone.toUpperCase().startsWith("N")) {
                        check02 = false;
                    }

                } while (!check02);
                int vitri = findRecipe(menuList.get(check).getMenuRecipe());
                recipeList.get(vitri).setRecipeInformation(info02);

            }
            price01 = Utils.getStringCanNull("Enter new price :");
            if (price01.equals("")) price = menuList.get(check).getMenuPrice();
            else {
                price = Integer.parseInt(price01);
            }
            menuList.get(check).setMenuName(name);
            menuList.get(check).setMenuPrice(price);
            System.out.println("Update success !!!");

        }
    }
}

