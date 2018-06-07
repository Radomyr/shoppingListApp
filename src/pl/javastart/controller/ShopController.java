package pl.javastart.controller;

import pl.javastart.buisnesslogic.PriceCalculator;
import pl.javastart.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@WebServlet("/shop")
public class ShopController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        double firstPrice=0,secondPrice=0,thirdPrice=0,fourthPrice=0;
        try {
            firstPrice = Double.parseDouble(request.getParameter("firstPrice"));
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        try {
            secondPrice = Double.parseDouble(request.getParameter("secondPrice"));
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        try {
            thirdPrice = Double.parseDouble(request.getParameter("thirdPrice"));
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        try {
            fourthPrice = Double.parseDouble(request.getParameter("fourthPrice"));
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        List<Double> priceList= asList(firstPrice,secondPrice,thirdPrice,fourthPrice);
        String firstProductName = request.getParameter("firstProductName");
        String secondProductName = request.getParameter("secondProductName");
        String thirdProductName = request.getParameter("thirdProductName");
        String fourthProductName = request.getParameter("fourthProductName");
        List<String> nameList=asList(firstProductName,secondProductName,thirdProductName,fourthProductName);

        List<Product> products = addCorrectProducts(priceList,nameList);
        double totalPrice=PriceCalculator.countTotalPrice(products);
        double medianPrice=(double) Math.round(PriceCalculator.medianPrice(products)*100)/100;

        request.setAttribute("listOfProducts",products);
        request.setAttribute("totalPrice",totalPrice);
        request.setAttribute("medianPrice",medianPrice);

       if (products.isEmpty()){
           request.getRequestDispatcher("empty.jsp").forward(request,response);
       }
       else {
           request.getRequestDispatcher("summary.jsp").forward(request, response);
       }
    }

    private List<Product> addCorrectProducts(List<Double> priceList, List<String> nameList){
        List<Product> products = new ArrayList<>();
        Product pr;
        for (int i=0;i<nameList.size();i++){
            if (!"".equals(nameList.get(i)) & priceList.get(i)>0){
                pr = new Product(priceList.get(i),nameList.get(i));
                System.out.println(priceList.get(i) + " "+nameList.get(i));
                products.add(pr);
            }
        }
        return products;
    }

}
