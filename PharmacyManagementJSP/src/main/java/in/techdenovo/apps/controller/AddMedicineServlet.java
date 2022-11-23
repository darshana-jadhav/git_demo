package in.techdenovo.apps.controller;

import in.techdenovo.apps.dao.MedicineDao;
import in.techdenovo.apps.dao.MedicineDaoImpl;
import in.techdenovo.apps.model.Medicine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/addmedicine"})
public class AddMedicineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String medicineName= req.getParameter("medicine-name");
       int quantity = Integer.parseInt(req.getParameter("medicine-quantity"));
       String brand = req.getParameter("medicine-brand");
        float price = Float.parseFloat(req.getParameter("medicine-price"));

        if(!medicineName.isEmpty() && !brand.isEmpty() && quantity!=0 && price!=0){
            Medicine medicine = new Medicine(medicineName,quantity,brand,price);
            MedicineDao medicineDao = new MedicineDaoImpl();
            if(medicineDao.addMedicine(medicine)!=0){
                PrintWriter out = resp.getWriter();
                out.println("Successfully added Medicine");
            }
        }
    }
}

