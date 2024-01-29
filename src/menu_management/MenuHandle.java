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
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import my_ultils.Utils;

public class MenuHandle {

    List<MenuInformations> menuList = new ArrayList();
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> recipeMap = new HashMap<>();

    public MenuHandle() {
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

    public void saveToFile(String fName) {
        if (menuList.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (MenuInformations menu : menuList) {
                pw.println(menu.getMenuCode() + ":" + menu.getMenuName() + ":" + menu.getMenuRecipe() + ":" + menu.getMenuPrice());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int findByCode(String info) {
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getMenuCode().toUpperCase().equals(info.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }

    public void addNewDrink() {
        String code = "MN" + Utils.getGenerativeNumber(menuList.size());
        String name;
        String recipe;
        int price;
        int status = 0;
        boolean check = true;
        name = Utils.getString("Enter name :", "Name not be null");
        String infoRecipe = "";
        String info;
        System.out.println("Enter recipe :");
        do {
            info = Utils.getString("Enter name of INGREDIENT :", "Name not be null");
            infoRecipe = infoRecipe + info;
            System.out.print("Enter the quantity :");
            info = sc.nextLine();
            infoRecipe = infoRecipe + " " + info + " ";
            System.out.println("Do you want to countinue ? Y/N");
            String respone;
            respone = sc.nextLine();
            if (respone.startsWith("Y")) check = false;
        } while (check);
        recipeMap.put(code,infoRecipe);
        
    }

    public void deleteDrink() {

    }
}
