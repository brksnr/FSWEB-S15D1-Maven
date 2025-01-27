package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Grocery Uygulamasına Hoş Geldiniz!");
        System.out.println("Seçenekler:");
        System.out.println("0 - Uygulamayı Durdur");
        System.out.println("1 - Eleman Ekleyin");
        System.out.println("2 - Eleman Çıkarın");

        while (isRunning) {
            System.out.print("Bir seçenek giriniz (0, 1, 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 0:
                    System.out.println("Uygulama kapatılıyor...");
                    isRunning = false;
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz elemanları giriniz.");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz elemanları giriniz (virgülle ayırarak birden fazla ekleyebilirsiniz): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
            }
        }
        scanner.close();
    }


    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else {
                System.out.println(trimmedItem + " zaten listede.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println(trimmedItem + " listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Mevcut Liste (Sıralı): " + groceryList);
    }

    public static void main(String[] args) {
        startGrocery();
    }

}
