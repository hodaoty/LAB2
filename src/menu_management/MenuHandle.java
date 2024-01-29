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
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MenuHandle {
    List<MenuInformations> menuList = new ArrayList();
    Scanner sc = new Scanner(System.in);
    
    public MenuHandle(){
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
            String info ;
            while ( (info = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(info, ":");
                String code = stk.nextToken();
                String name = stk.nextToken();
                String recipe = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                MenuInformations menu = new MenuInformations(code, name, recipe, price);
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
                pw.println(menu.getMenuCode()+":"+menu.getMenuName()+":"+menu.getMenuRecipe()+":"+menu.getMenuPrice());
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
        
}
