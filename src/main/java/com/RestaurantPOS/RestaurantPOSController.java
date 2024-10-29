package com.RestaurantPOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestaurantPOSController {
    static Security c = new Security();

    List<Order> orders = new ArrayList<>();
    List<Order> orders2 = new ArrayList<>();
    private double searchTP;
    private int searchON;

    @GetMapping("/")
    public String orderDetails(Model model) {

        model.addAttribute("order", new Order());
        return "OrderInput";
    }

    @PostMapping("/dataSubmitOrder")
    public String dataSubmitOrder(Order order) {
        // in the postmapping seting operation happens automatically
        String query = "insert into orders (Order_number,No_of_SN,price_SN,No_of_SP,price_SP,No_of_SD,price_SD,No_of_Cola,price_Cola,No_of_Water,price_Water,No_of_Shanina,price_Shanina,No_of_items,Total_price,Order_Date) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection C1 = c.connect();
                PreparedStatement PS = C1.prepareStatement(query);) {
            if (order.ThereIsOrder()) {
                orders.add(order);
                order.setNo_of_items();
                order.setTotal_Shanina_Cost();
                order.setTotal_cola_Cost();
                order.setTotal_water_Cost();
                order.setTotal_ShawermaNormal_Cost();
                order.setTotal_ShawermaSuper_Cost();
                order.setTotal_ShawermaDouble_Cost();
                order.setTotal_Cost();
                order.setTotal_cola_price();
                order.setTotal_water_price();
                order.setTotal_Shanina_price();
                order.setTotal_ShawermaNormal_price();
                order.setTotal_ShawermaSuper_price();
                order.setTotal_ShawermaDouble_price();
                order.setTotal_price();
                order.setNetprofitForOrder();
                order.setOrder_number(order, orders);
                order.setTm(new Timestamp(System.currentTimeMillis()));
                PS.setInt(1, order.getOrder_number());
                PS.setInt(2, order.getNo_of_ShawermaNormalfororder());
                PS.setDouble(3, order.getTotal_ShawermaNormal_price());
                PS.setInt(4, order.getNo_of_ShawermaSuperfororder());
                PS.setDouble(5, order.getTotal_ShawermaSuper_price());
                PS.setInt(6, order.getNo_of_ShawermaDoublefororder());
                PS.setDouble(7, order.getTotal_ShawermaDouble_price());
                PS.setInt(8, order.getNo_of_cola());
                PS.setDouble(9, order.getTotal_cola_price());
                PS.setInt(10, order.getNo_of_waterbottle());
                PS.setDouble(11, order.getTotal_water_price());
                PS.setInt(12, order.getNo_of_Shanina());
                PS.setDouble(13, order.getTotal_Shanina_price());
                PS.setInt(14, order.getNo_of_items());
                PS.setDouble(15, order.getTotal_price());
                PS.setTimestamp(16, order.getTm());
                PS.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    public static void setDatafromdatabase(List<Order> orders) {
        if (orders.size() == 0) {
            String query2 = "SELECT * FROM `orders`";
            try (Connection C2 = c.connect();
                    PreparedStatement PS2 = C2.prepareStatement(query2);
                    ResultSet rs = PS2.executeQuery(query2);) {
                while (rs.next()) {
                    Order order = new Order(rs.getInt(2), rs.getInt(4), rs.getInt(6), rs.getInt(8), rs.getInt(10),
                            rs.getInt(12));
                    order.setTm(rs.getTimestamp(16));
                    orders.add(order);

                }
                // No of index start from 1.
                for (int i = 0; i < orders.size(); i++) {
                    orders.get(i).setNo_of_items();
                    orders.get(i).setTotal_Shanina_Cost();
                    orders.get(i).setTotal_cola_Cost();
                    orders.get(i).setTotal_water_Cost();
                    orders.get(i).setTotal_ShawermaNormal_Cost();
                    orders.get(i).setTotal_ShawermaSuper_Cost();
                    orders.get(i).setTotal_ShawermaDouble_Cost();
                    orders.get(i).setTotal_Cost();
                    orders.get(i).setTotal_cola_price();
                    orders.get(i).setTotal_water_price();
                    orders.get(i).setTotal_Shanina_price();
                    orders.get(i).setTotal_ShawermaNormal_price();
                    orders.get(i).setTotal_ShawermaSuper_price();
                    orders.get(i).setTotal_ShawermaDouble_price();
                    orders.get(i).setTotal_price();
                    orders.get(i).setNetprofitForOrder();
                    orders.get(i).setOrder_number(orders.get(i), orders);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @GetMapping("/OrdersTables")
    public String getOrdersTables(Model model) {
        orders2.clear();
        RestaurantPOSController.setDatafromdatabase(orders);
        Order.setTotal_NetProfit(orders);
        double t = (float) Order.getTotal_NetProfit();
        RestaurantPOSController r = new RestaurantPOSController();
        RestaurantPOSController r1 = new RestaurantPOSController();

        Order.setTotal_Cash(orders);
        double tc = (float) Order.getTotal_Cash();
        model.addAttribute("orders", orders);
        model.addAttribute("TotalNetProfitToday", t);
        model.addAttribute("Total_Cash", tc);
        model.addAttribute("r", r);
        model.addAttribute("r1", r1);
        Order.setTotal_Cashzero();
        Order.setNetProfitZero();
        return "OrdersTables";
    }

    @GetMapping("/RemoveOrders")
    public String removeOldOrders() {
        String query3 = "DELETE FROM orders";
        try (Connection C3 = c.connect();
                Statement S = C3.createStatement();) {
            orders.clear();
            S.execute(query3);
            Order.setNetProfitZero();
            Order.setTotal_Cashzero();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/OrdersTables";
    }

    @GetMapping("/SortAccordingToTotalprice")
    public String sortOrdersTP(Model model) {
        orders2.clear();
        Order.QuickSortTP(orders, 0, orders.size() - 1);

        return "redirect:/OrdersTables";
    }

    @GetMapping("/SortAccordingToOrderNumber")
    public String sortOrdersON(Model model) {
        orders2.clear();
        Order.QuickSortON(orders, 0, orders.size() - 1);

        return "redirect:/OrdersTables"; // When you clear all items from orders after they are sorted the function
                                         // disappear.
    }

    @PostMapping("/SubmitSearchTP")
    public String enterThePriceYouSearch(float searchTP) {
        orders2 = Order.BinarysearchTP(orders, searchTP);

        return "redirect:/OrdersTables2";

    }

    public void setSearchTP(double x) {
        searchTP = x;
    }

    public double getSearchTP() {
        return searchTP;
    }

    @GetMapping("/OrdersTables2")
    public String goTosearchPageTP(Model model) {
        model.addAttribute("orders2", orders2);
        return "OrdersTables2";
    }

    @PostMapping("/SubmitSearchON")
    public String enterTheOrderNumberYouSearch(int searchON) {
        orders2 = Order.BinarysearchON(orders, searchON);
        return "redirect:/OrdersTables3";
    }

    @GetMapping("/OrdersTables3")
    public String goTosearchPageON(Model model) {

        model.addAttribute("orders2", orders2);
        return "OrdersTables3";
    }

    public int getSearchON() {
        return searchON;
    }

    public void setSearchON(int searchON) {
        this.searchON = searchON;
    }
}
