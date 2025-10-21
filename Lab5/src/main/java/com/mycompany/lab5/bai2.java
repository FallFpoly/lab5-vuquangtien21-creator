/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author ICT
 */
public class bai2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachHoTen = new ArrayList<>();
        int luaChon;

        do {
            hienThiMenu();
            System.out.print("Chọn chức năng (1-6): ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); 

            switch (luaChon) {
                case 1:
                    nhapDanhSach(scanner, danhSachHoTen);
                    break;
                case 2:
                    xuatDanhSach(danhSachHoTen);
                    break;
                case 3:
                    xuatDanhSachNgauNhien(danhSachHoTen);
                    break;
                case 4:
                    sapXepGiamDan(danhSachHoTen);
                    break;
                case 5:
                    timVaXoa(scanner, danhSachHoTen);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (luaChon != 6);

        scanner.close();
    }

    public static void hienThiMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Nhập danh sách họ và tên");
        System.out.println("2. Xuất danh sách vừa nhập");
        System.out.println("3. Xuất danh sách ngẫu nhiên");
        System.out.println("4. Sắp xếp giảm dần và xuất danh sách");
        System.out.println("5. Tìm và xóa họ tên nhập từ bàn phím");
        System.out.println("6. Kết thúc");
        System.out.println("==========================");
    }

    public static void nhapDanhSach(Scanner scanner, ArrayList<String> danhSach) {
        danhSach.clear(); 
        System.out.println("\n=== NHẬP DANH SÁCH HỌ TÊN ===");
        
        while (true) {
            System.out.print("Nhập họ tên: ");
            String hoTen = scanner.nextLine();
            danhSach.add(hoTen);

            System.out.print("Nhập thêm (Y/N)? ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Đã nhập xong danh sách!");
    }

    public static void xuatDanhSach(ArrayList<String> danhSach) {
        System.out.println("\n=== DANH SÁCH HỌ TÊN ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
    }

    public static void xuatDanhSachNgauNhien(ArrayList<String> danhSach) {
        System.out.println("\n=== DANH SÁCH NGẪU NHIÊN ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        ArrayList<String> danhSachSao = new ArrayList<>(danhSach);
        Collections.shuffle(danhSachSao);
        
        for (int i = 0; i < danhSachSao.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachSao.get(i));
        }
    }

    public static void sapXepGiamDan(ArrayList<String> danhSach) {
        System.out.println("\n=== DANH SÁCH SẮP XẾP GIẢM DẦN ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        ArrayList<String> danhSachSao = new ArrayList<>(danhSach);
        Collections.sort(danhSachSao); 
        Collections.reverse(danhSachSao); 
        
        for (int i = 0; i < danhSachSao.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachSao.get(i));
        }
    }

    public static void timVaXoa(Scanner scanner, ArrayList<String> danhSach) {
        System.out.println("\n=== TÌM VÀ XÓA HỌ TÊN ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        
        System.out.print("Nhập họ tên cần xóa: ");
        String hoTenCanXoa = scanner.nextLine();
        
        boolean timThay = false;
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).equalsIgnoreCase(hoTenCanXoa)) {
                danhSach.remove(i);
                System.out.println("Đã xóa: " + hoTenCanXoa);
                timThay = true;
                break; 
            }
        }
        
        if (!timThay) {
            System.out.println("Không tìm thấy họ tên: " + hoTenCanXoa);
        }
    }
}
