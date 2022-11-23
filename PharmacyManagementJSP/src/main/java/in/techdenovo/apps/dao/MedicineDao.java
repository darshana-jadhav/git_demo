package in.techdenovo.apps.dao;


import in.techdenovo.apps.model.Medicine;

import java.util.List;

public interface MedicineDao {
   public int addMedicine(Medicine medicine);
   public Medicine getMedicine(String medicineName);
   public Medicine getMedicine(int medicineCode);
   public int editMedicine(Medicine medicine);

   //public Medicine getMedicineByName(String medicineName);
  // public List<Medicine> getMedicines();

}
