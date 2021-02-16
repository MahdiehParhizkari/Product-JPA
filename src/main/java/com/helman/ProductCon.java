package com.helman;

//@project order
//@Author Mahdieh Parhizkari
//@Date 2/7/21
//@Time 12:58PM
//        Created by Intellije IDEA
//        Description:JPA-Criteria

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.exolab.castor.types.Date;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAct", urlPatterns ={"/ProductAct"})
public class ProductCon extends HttpServlet {
    ProductDao productDao = new ProductDao();
    List<Product> productList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("crud");
        String id = req.getParameter("id");

        if (action.equals("read")){
            if (id == null || id.isEmpty()){
                productList = productDao.findAll();
            }else{
                Product product = productDao.findById(Integer.parseInt(id));
                productList.add(product);
            }

           req.setAttribute("products", productList);
           req.getRequestDispatcher("/product.jsp").forward(req, resp);
        }

        if (action.equals("add")){
            Product pro = new Product();
            pro.setId(Integer.parseInt(req.getParameter("id")));
            pro.setName(req.getParameter("name"));
            pro.setCountryid_fk(Integer.parseInt(req.getParameter("country")));
            pro.setCount(Integer.parseInt(req.getParameter("count")));
            pro.setPrice(Float.parseFloat(req.getParameter("price")));
            try {
                pro.setCreatedate(new SimpleDateFormat("YYYY-MM-dd").parse(req.getParameter("date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            productDao.insert(pro);
            req.setAttribute("message", "Added");
            req.getRequestDispatcher("/product.jsp").forward(req, resp);
        }

        if (action.equals("update")){
            Product pro = productDao.findById(Integer.parseInt(req.getParameter("id")));
            pro.setName(req.getParameter("name"));
            pro.setCountryid_fk(Integer.parseInt(req.getParameter("country")));
            pro.setCount(Integer.parseInt(req.getParameter("count")));
            pro.setPrice(Float.parseFloat(req.getParameter("price")));
            try {
                pro.setCreatedate(new SimpleDateFormat("YYYY-MM-dd").parse(req.getParameter("date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            productDao.update(pro);
            req.setAttribute("message", "updated");
            req.getRequestDispatcher("/product.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("crud");

        if (action.equals("delete")){
            Product pro = productDao.findById(Integer.parseInt(req.getParameter("id")));
            productDao.delete(pro);
            req.setAttribute("message", "deleted");
            req.getRequestDispatcher("/product.jsp").forward(req, resp);
        }

        if (action.equals("edit")){
            Product product = productDao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("pro", product);
            req.getRequestDispatcher("/Edit.jsp").forward(req,resp);
        }
        if (action.equals("report")){
            String path = req.getSession().getServletContext().getRealPath("/WEB-INF/Report/Product.jrxml");
            try {
                JasperReport jReport = JasperCompileManager.compileReport(path);
                JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(productDao.findAll());
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, jcs);
                JasperViewer.viewReport(jPrint, false);
                req.getRequestDispatcher("/product.jsp").forward(req, resp);
            } catch (JRException e) {
                e.printStackTrace();
            }
        }
    }
}