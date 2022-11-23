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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {"/getmedicine"})

public class GetMedicinesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String medicineName=req.getParameter("medicine-name");
        String destPage = "";
        Medicine medicine=new Medicine();
        if(medicineName != null){
            MedicineDao medicineDao = new MedicineDaoImpl();

            medicine=medicineDao.getMedicine(medicineName);
            req.setAttribute("medicine",medicine);
            destPage="/search-medicine.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destPage);
            dispatcher.forward(req,resp);
        }
    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


    }

}
