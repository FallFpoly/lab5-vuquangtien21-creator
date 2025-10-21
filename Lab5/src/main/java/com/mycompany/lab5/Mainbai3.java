/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Mainbai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<bai3> danhSachSanPham = new ArrayList<>();
        int luaChon;

        do {
            hienThiMenu();
            System.out.print("Chọn chức năng (1-4, 0 để thoát): ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự thừa

            switch (luaChon) {
                case 1:
                    nhapDanhSachSanPham(scanner, danhSachSanPham);
                    break;
                case 2:
                    sapXepGiamDanTheoGia(danhSachSanPham);
                    break;
                case 3:
                    timVaXoaSanPham(scanner, danhSachSanPham);
                    break;
                case 4:
                    xuatGiaTrungBinh(danhSachSanPham);
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (luaChon != 0);

        scanner.close();
    }

    public static void hienThiMenu() {
        System.out.println("\n========== QUẢN LÝ SẢN PHẨM ==========");
        System.out.println("1. Nhập danh sách sản phẩm từ bàn phím");
        System.out.println("2. Sắp xếp giảm dần theo giá và xuất ra màn hình");
        System.out.println("3. Tìm và xóa sản phẩm theo tên nhập từ bàn phím");
        System.out.println("4. Xuất giá trung bình của các sản phẩm");
        System.out.println("0. Thoát");
        System.out.println("=======================================");
    }

    public static void nhapDanhSachSanPham(Scanner scanner, ArrayList<bai3> danhSach) {
        danhSach.clear();
        System.out.println("\n=== NHẬP DANH SÁCH SẢN PHẨM ===");
        
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String ten = scanner.nextLine();
            
            System.out.print("Nhập giá sản phẩm: ");
            Double gia = scanner.nextDouble();
            scanner.nextLine();
            
            bai3 sp = new bai3(ten, gia);
            danhSach.add(sp);

            System.out.print("Nhập thêm sản phẩm (Y/N)? ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Đã nhập xong danh sách " + danhSach.size() + " sản phẩm!");
    }

    public static void sapXepGiamDanTheoGia(ArrayList<bai3> danhSach) {
        System.out.println("\n=== DANH SÁCH SẢN PHẨM SẮP XẾP GIẢM DẦN THEO GIÁ ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        ArrayList<bai3> danhSachSao = new ArrayList<>(danhSach);
        
        Comparator<bai3> comp = new Comparator<bai3>() {
            @Override
            public int compare(bai3 o1, bai3 o2) {
                return o1.donGia.compareTo(o2.donGia);
            }
        };
        
        Collections.sort(danhSachSao, comp);
        Collections.reverse(danhSachSao);
        
        System.out.printf("%-20s %s\n", "Tên sản phẩm", "Giá");
        System.out.println("----------------------------------------");
        for (bai3 sp : danhSachSao) {
            System.out.println(sp);
        }
    }

    public static void timVaXoaSanPham(Scanner scanner, ArrayList<bai3> danhSach) {
        System.out.println("\n=== TÌM VÀ XÓA SẢN PHẨM ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        
        boolean timThay = false;
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).ten.equalsIgnoreCase(tenCanXoa)) {
                bai3 spXoa = danhSach.remove(i);
                System.out.println("Đã xóa sản phẩm: " + spXoa.ten + " - Giá: " + spXoa.donGia);
                timThay = true;
                break;
            }
        }
        
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm: " + tenCanXoa);
        }
    }

    public static void xuatGiaTrungBinh(ArrayList<bai3> danhSach) {
        System.out.println("\n=== GIÁ TRUNG BÌNH CỦA CÁC SẢN PHẨM ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        double tongGia = 0;
        for (bai3 sp : danhSach) {
            tongGia += sp.donGia;
        }
        
        double giaTrungBinh = tongGia / danhSach.size();
        System.out.printf("Tổng số sản phẩm: %d\n", danhSach.size());
        System.out.printf("Tổng giá: %,.2f\n", tongGia);
        System.out.printf("Giá trung bình: %,.2f\n", giaTrungBinh);
    }
}