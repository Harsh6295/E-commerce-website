package com.example.ecom.servlet;
import com.example.ecom.dao.ProductDAO;
import com.example.ecom.model.Product;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
@WebServlet(urlPatterns = {"/admin/products", "/admin/product-form", "/admin/product-save", "/admin/product-delete"})
public class AdminProductServlet extends HttpServlet {
    private ProductDAO dao = new ProductDAO();

    private boolean isAdmin(HttpSession session) {
        Object role = session.getAttribute("role");
        return role != null && "ADMIN".equals(role.toString());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session==null || !isAdmin(session)) { resp.sendRedirect(req.getContextPath()+"/login"); return; }
        String path = req.getServletPath();
        try {
            if ("/admin/products".equals(path)) {
                List<Product> list = dao.findAll();
                req.setAttribute("products", list);
                req.getRequestDispatcher("/admin/products.jsp").forward(req, resp);
            } else if ("/admin/product-form".equals(path)) {
                String id = req.getParameter("id");
                if (id!=null && !id.isEmpty()) {
                    Product p = dao.findById(Integer.parseInt(id));
                    req.setAttribute("product", p);
                }
                req.getRequestDispatcher("/admin/product-form.jsp").forward(req, resp);
            } else if ("/admin/product-delete".equals(path)) {
                String id = req.getParameter("id");
                if (id!=null) dao.delete(Integer.parseInt(id));
                resp.sendRedirect(req.getContextPath()+"/admin/products");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session==null || !isAdmin(session)) { resp.sendRedirect(req.getContextPath()+"/login"); return; }
        try {
            String id = req.getParameter("id");
            Product p = new Product();
            p.setName(req.getParameter("name"));
            p.setDescription(req.getParameter("description"));
            p.setPrice(new BigDecimal(req.getParameter("price")));
            p.setImageUrl(req.getParameter("imageUrl"));
            p.setStock(Integer.parseInt(req.getParameter("stock")));
            if (id==null || id.isEmpty()) {
                dao.create(p);
            } else {
                p.setId(Integer.parseInt(id));
                dao.update(p);
            }
            resp.sendRedirect(req.getContextPath()+"/admin/products");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
