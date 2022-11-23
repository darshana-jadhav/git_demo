package in.techdenovo.apps.dao;

import in.techdenovo.apps.model.Medicine;
import in.techdenovo.apps.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao{

    DButil dbUtil = new DButil();

    public int addMedicine(Medicine medicine) {
        int flag = 0;
        try {
            Connection conn = dbUtil.getConnection();
            if (conn != null) {
                String query = "insert into Medicines (MEDICINE_NAME,MEDICINE_QUANTITY,MEDICINE_BRAND,MEDICINE_PRICE) values (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);


                ps.setString(1, medicine.getMedicineName());
                ps.setInt(2, medicine.getQuantity());
                ps.setString(3, medicine.getBrand());
                ps.setFloat(4, medicine.getPrice());

                flag = ps.executeUpdate();
//                System.out.println("Sucessfully Added to Database");
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return flag;
    }

    public Medicine getMedicine(String medicineName) {
        Medicine existingMedicine = null;

        try {
            Connection conn = dbUtil.getConnection();
            if (conn != null) {
                String query = "Select * from Medicines where MEDICINE_NAME = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, medicineName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    existingMedicine = new Medicine();
                    existingMedicine.setMedicineCode(rs.getInt("MEDICINE_CODE"));
                    existingMedicine.setMedicineName(rs.getString("MEDICINE_NAME"));
                    existingMedicine.setQuantity(rs.getInt("MEDICINE_QUANTITY"));
                    existingMedicine.setBrand(rs.getString("MEDICINE_BRAND"));
                    existingMedicine.setPrice(rs.getFloat("MEDICINE_PRICE"));
                }
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return existingMedicine;
    }

    @Override
    public Medicine getMedicine(int medicineCode) {
        Medicine existingMedicine = null;

        try {
            Connection conn = dbUtil.getConnection();
            if (conn != null) {
                String query = "Select * from Medicines where MEDICINE_CODE = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, medicineCode);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    existingMedicine = new Medicine();
                    existingMedicine.setMedicineCode(rs.getInt("MEDICINE_CODE"));
                    existingMedicine.setMedicineName(rs.getString("MEDICINE_NAME"));
                    existingMedicine.setQuantity(rs.getInt("MEDICINE_QUANTITY"));
                    existingMedicine.setBrand(rs.getString("MEDICINE_BRAND"));
                    existingMedicine.setPrice(rs.getFloat("MEDICINE_PRICE"));
                }
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return existingMedicine;
    }


    public int editMedicine(Medicine medicine) {
        int flag = 0;
        try {
            Connection conn = dbUtil.getConnection();
            if (conn != null) {
                String query = "update Medicines set MEDICINE_NAME=?,MEDICINE_QUANTITY=?,MEDICINE_BRAND=?,MEDICINE_PRICE=? where MEDICINE_CODE=?";
                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, medicine.getMedicineName());
                ps.setInt(2, medicine.getQuantity());
                ps.setString(3, medicine.getBrand());
                ps.setFloat(4, medicine.getPrice());
                ps.setInt(5,medicine.getMedicineCode());

                flag = ps.executeUpdate();
                if(flag==1)
                    System.out.println("Sucessfully Updated Medicine");
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return flag;
    }

}
