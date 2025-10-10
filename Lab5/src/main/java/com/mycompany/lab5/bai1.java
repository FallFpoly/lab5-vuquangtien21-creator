/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();

        while (true) {
            System.out.print("Nhap so thuc: ");
            double x = sc.nextDouble();
            list.add(x);

            System.out.print("ban co muon nhap them khong? (Y/N): ");
            sc.nextLine(); 
            String tiepTuc = sc.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("\nDanh sach cac so thuc ban da nhap:");
        for (double num : list) {
            System.out.print(num + "  ");
        }

        double tong = 0;
        for (double num : list) {
            tong += num;
        }

        System.out.println("\nTong cac so: " + tong);
    }
}
