package in.techdenovo.apps.controller;

import in.techdenovo.apps.dao.MedicineDao;
import in.techdenovo.apps.dao.MedicineDaoImpl;
import in.techdenovo.apps.model.Medicine;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/editmedicine"})

public class EditMedicineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int medicineCode = Integer.parseInt(req.getParameter("medicineCode"));
        String destPage = "";
        Medicine medicine = new Medicine();
        if (medicineCode != 0) {
            MedicineDao medicineDao = new MedicineDaoImpl();

            medicine = medicineDao.getMedicine(medicineCode);
            req.setAttribute("medicine", medicine);
            destPage = "/edit-medicine.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destPage);
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int medicineCode = Integer.parseInt(req.getParameter("medicine-code"));
        String medicineName = req.getParameter("medicine-name");
        int quantity = Integer.parseInt(req.getParameter("medicine-quantity"));
        String brand = req.getParameter("medicine-brand");
        float price = Float.parseFloat(req.getParameter("medicine-price"));

        if (!medicineName.isEmpty() && !brand.isEmpty()) {
            Medicine medicine = new Medicine(medicineCode,medicineName, quantity, brand, price);
            MedicineDao medicineDao = new MedicineDaoImpl();
            if (medicineDao.editMedicine(medicine) != 0) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(req,resp);
            }

        }
    }
}
