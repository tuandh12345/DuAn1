/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Helper;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Model.NhanVienModel;
import java.util.ArrayList;

/**
 *
 * @author DELL E5470
 */
public class NewClass {
    public static void main(String[] args) {
        NhanVienDAO1 dao = new NhanVienDAO1();
        ArrayList<NhanVienModel> nv = (ArrayList<NhanVienModel>) dao.select();
        System.out.println(nv.size());
      
    }
    
}
