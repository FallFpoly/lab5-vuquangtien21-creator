/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author ICT
 */
public class bai3 {
    String ten;
    Double donGia;

    public bai3(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return String.format("%-20s %,.2f", ten, donGia);
    }
}