package in.techdenovo.apps.model;

public class Medicine {
    int medicineCode;
    String medicineName;
    int quantity;
    String brand;
    float price;

    public Medicine() {
    }

    public Medicine(int medicineCode, String medicineName, int quantity, String brand, float price) {
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
    }

    public Medicine(String medicineName, int quantity, String brand, float price) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
    }

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {

        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {

        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
