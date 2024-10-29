package com.RestaurantPOS;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private double Total_price;
    private double Total_ShawermaNormal_price;
    private double Total_ShawermaSuper_price;
    private double Total_ShawermaDouble_price;
    private double Total_water_price;
    private double Total_cola_price;
    private double Total_Shanina_price;

    private int No_of_items;
    private double NetprofitForOrder;

    private double Total_Cost;
    private double Total_ShawermaNormal_Cost;
    private double Total_ShawermaSuper_Cost;
    private double Total_ShawermaDouble_Cost;
    private double Total_water_Cost;
    private double Total_cola_Cost;
    private double Total_Shanina_Cost;

    private int No_of_ShawermaNormalfororder;
    private int No_of_ShawermaSuperfororder;
    private int No_of_ShawermaDoublefororder;
    private int No_of_waterbottle;
    private int No_of_cola;
    private int No_of_Shanina;
    protected int Order_number;
    protected static double Total_NetProfit;
    protected static double Total_Cash;
    private Timestamp timestamp;

    public Order(int No_of_ShawermaNormalfororder, int No_of_ShawermaSuperfororder, int No_of_ShawermaDoublefororder,
            int No_of_cola,
            int No_of_Shanina, int No_of_waterbottle) {
        this.No_of_ShawermaNormalfororder = No_of_ShawermaNormalfororder;
        this.No_of_ShawermaSuperfororder = No_of_ShawermaSuperfororder;
        this.No_of_ShawermaDoublefororder = No_of_ShawermaDoublefororder;
        this.No_of_cola = No_of_cola;
        this.No_of_Shanina = No_of_Shanina;
        this.No_of_waterbottle = No_of_waterbottle;
    }

    public Order() {
    }

    public void setNo_of_ShawermaNormalfororder(int no_of_ShawermaNormalfororder) {
        No_of_ShawermaNormalfororder = no_of_ShawermaNormalfororder;
    }

    public void setNo_of_ShawermaSuperfororder(int no_of_ShawermaSuperfororder) {
        No_of_ShawermaSuperfororder = no_of_ShawermaSuperfororder;
    }

    public void setNo_of_ShawermaDoublefororder(int no_of_ShawermaDoublefororder) {
        No_of_ShawermaDoublefororder = no_of_ShawermaDoublefororder;
    }

    public void setNo_of_cola(int no_of_cola) {
        No_of_cola = no_of_cola;
    }

    public void setNo_of_waterbottle(int no_of_waterbottle) {
        No_of_waterbottle = no_of_waterbottle;
    }

    public void setNo_of_Shanina(int no_of_Shanina) {
        No_of_Shanina = no_of_Shanina;
    }

    public void setNo_of_items() {
        this.No_of_items = No_of_ShawermaNormalfororder + No_of_ShawermaSuperfororder + No_of_ShawermaDoublefororder
                + No_of_cola + No_of_waterbottle + No_of_Shanina;
    }

    public int getNo_of_ShawermaNormalfororder() {
        return No_of_ShawermaNormalfororder;
    }

    public int getNo_of_ShawermaSuperfororder() {
        return No_of_ShawermaSuperfororder;
    }

    public int getNo_of_ShawermaDoublefororder() {
        return No_of_ShawermaDoublefororder;
    }

    public int getNo_of_cola() {
        return No_of_cola;
    }

    public int getNo_of_Shanina() {
        return No_of_Shanina;
    }

    public int getNo_of_waterbottle() {
        return No_of_waterbottle;
    }

    public int getNo_of_items() {
        return No_of_items;
    }

    public void setTotal_ShawermaNormal_price() {
        Total_ShawermaNormal_price = ShawermaNormal.getTax()
                * (ShawermaNormal.getPrice() * No_of_ShawermaNormalfororder)
                + (ShawermaNormal.getPrice() * No_of_ShawermaNormalfororder);
    }

    public void setTotal_ShawermaSuper_price() {
        Total_ShawermaSuper_price = ShawermaSuper.getTax() * (ShawermaSuper.getPrice() * No_of_ShawermaSuperfororder)
                + (ShawermaSuper.getPrice() * No_of_ShawermaSuperfororder);
    }

    public void setTotal_ShawermaDouble_price() {
        Total_ShawermaDouble_price = ShawermaDouble.getTax()
                * (ShawermaDouble.getPrice() * No_of_ShawermaDoublefororder)
                + (ShawermaDouble.getPrice() * No_of_ShawermaDoublefororder);
    }

    public void setTotal_Shanina_price() {
        Total_Shanina_price = Shanina.getTax() * (Shanina.getPrice() * No_of_Shanina)
                + (Shanina.getPrice() * No_of_Shanina);
    }

    public void setTotal_cola_price() {
        Total_cola_price = Cola.getTax() * (Cola.getPrice() * No_of_cola)
                + (Cola.getPrice() * No_of_cola);
    }

    public void setTotal_water_price() {
        Total_water_price = Water.getTax() * (Water.getPrice() * No_of_waterbottle)
                + (Water.getPrice() * No_of_waterbottle);
    }

    public void setTotal_price() {
        Total_price = Total_ShawermaNormal_price + Total_ShawermaSuper_price + Total_ShawermaDouble_price
                + Total_Shanina_price + Total_cola_price + Total_water_price;
    }

    public double getTotal_price() {
        return Math.round(Total_price);
    }

    public double getTotal_ShawermaNormal_price() {
        return Math.round(Total_ShawermaNormal_price);
    }

    public double getTotal_ShawermaSuper_price() {
        return Math.round(Total_ShawermaSuper_price);
    }

    public double getTotal_ShawermaDouble_price() {
        return Math.round(Total_ShawermaDouble_price);
    }

    public double getTotal_cola_price() {
        return Math.round(Total_cola_price);
    }

    public double getTotal_water_price() {
        return Math.round(Total_water_price);
    }

    public double getTotal_Shanina_price() {
        return Math.round(Total_Shanina_price);
    }

    public void setTotal_ShawermaNormal_Cost() {
        Total_ShawermaNormal_Cost = ShawermaNormal.getCost() * No_of_ShawermaNormalfororder;
    }

    public void setTotal_ShawermaSuper_Cost() {
        Total_ShawermaSuper_Cost = ShawermaSuper.getCost() * No_of_ShawermaSuperfororder;
    }

    public void setTotal_ShawermaDouble_Cost() {
        Total_ShawermaDouble_Cost = ShawermaDouble.getCost() * No_of_ShawermaDoublefororder;
    }

    public void setTotal_water_Cost() {
        Total_water_Cost = Water.getCost() * No_of_waterbottle;
    }

    public void setTotal_cola_Cost() {
        Total_cola_Cost = Cola.getCost() * No_of_cola;
    }

    public void setTotal_Shanina_Cost() {
        Total_Shanina_Cost = Shanina.getCost() * No_of_Shanina;
    }

    public void setTotal_Cost() {
        Total_Cost = Total_ShawermaNormal_Cost + Total_ShawermaSuper_Cost + Total_ShawermaDouble_Cost
                + Total_Shanina_Cost + Total_cola_Cost + Total_water_Cost;
    }

    public double getTotal_ShawermaNormal_Cost() {
        return Math.round(Total_ShawermaNormal_Cost);
    }

    public double getTotal_ShawermaSuper_Cost() {
        return Math.round(Total_ShawermaSuper_Cost);
    }

    public double getTotal_ShawermaDouble_Cost() {
        return Math.round(Total_ShawermaDouble_Cost);
    }

    public double getTotal_water_Cost() {
        return Math.round(Total_water_Cost);
    }

    public double getTotal_cola_Cost() {
        return Math.round(Total_cola_Cost);
    }

    public double getTotal_Shanina_Cost() {
        return Math.round(Total_Shanina_Cost);
    }

    public double getTotal_Cost() {
        return Math.round(Total_Cost);
    }

    public void setNetprofitForOrder() {
        NetprofitForOrder = Total_price - Total_Cost;
    }

    public double getNetprofitForOrder() {
        return Math.round(NetprofitForOrder);
    }

    public static void setTotal_NetProfit(List<Order> orders) {
        Total_NetProfit = 0;
        for (int i = 0; i < orders.size(); i++) {
            Total_NetProfit = Total_NetProfit + orders.get(i).getNetprofitForOrder();
        }
    }

    public static double getTotal_NetProfit() {
        return Math.round(Total_NetProfit);
    }

    public boolean IsContainSN() {
        return No_of_ShawermaNormalfororder != 0;
    }

    public boolean IsContainSP() {
        return No_of_ShawermaSuperfororder != 0;
    }

    public boolean IsContainSD() {
        return No_of_ShawermaDoublefororder != 0;
    }

    public boolean IsContainCola() {
        return No_of_cola != 0;
    }

    public boolean IsContainWater() {
        return No_of_waterbottle != 0;
    }

    public boolean IsContainShanina() {
        return No_of_Shanina != 0;
    }

    public boolean ThereIsOrder() {
        if (IsContainCola() || IsContainSN() || IsContainSP() || IsContainSD() || IsContainShanina()
                || IsContainWater())

            return true;
        else {
            return false;
        }
    }

    public void setOrder_number(Order order, List<Order> orders) {
        Order_number = orders.indexOf(order) + 1;
    }

    public int getOrder_number() {
        return Order_number;
    }

    public boolean IsOrder_numberZero() {
        return Order_number == 0;
    }

    public static void setNetProfitZero() {
        Total_NetProfit = 0;
    }

    public static int partitionTP(List<Order> orders, int start, int end) {

        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (orders.get(j).getTotal_price() <= orders.get(pivot).getTotal_price()) {
                i++;
                Collections.swap(orders, i, j);
            }
        }
        return i;
    }

    public static void QuickSortTP(List<Order> arr, int start, int end) {
        if (start < end) {
            int pivot = partitionTP(arr, start, end);
            QuickSortTP(arr, start, pivot - 1);
            QuickSortTP(arr, pivot + 1, end);
        }

    }

    public static int partitionON(List<Order> orders, int start, int end) {

        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (orders.get(j).getOrder_number() <= orders.get(pivot).getOrder_number()) {
                i++;
                Collections.swap(orders, i, j);
            }
        }
        return i;
    }

    public static void QuickSortON(List<Order> arr, int start, int end) {
        if (start < end) {
            int pivot = partitionON(arr, start, end);
            QuickSortON(arr, start, pivot - 1);
            QuickSortON(arr, pivot + 1, end);
        }

    }

    public static List<Order> Linearsearch(List<Order> orders, float TP) {
        Order.QuickSortTP(orders, 0, orders.size() - 1);
        List<Order> orders2 = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getTotal_price() == TP) {
                orders2.add(orders.get(i));
            }

        }
        if (orders2.size() == 1) {
            return orders2;
        } else {
            for (int i = 0; i < orders.size(); i++) {
                if (Math.abs(orders.get(i).getTotal_price() - TP) <= 4) {
                    orders2.add(orders.get(i));
                }
            }
            return orders2;
        }
    }

    public static List<Order> BinarysearchON(List<Order> orders, int ON) {
        Order.QuickSortON(orders, 0, orders.size() - 1);

        int first = 0;
        int last = orders.size() - 1;
        int mid = (first + last) / 2;
        List<Order> orders2 = new ArrayList<>();
        while (first <= last) {
            if (orders.get(mid).getOrder_number() < ON) {
                first = mid + 1;

            } else if (orders.get(mid).getOrder_number() == ON) {
                orders2.add(orders.get(mid));
                return orders2;
            } else if (orders.get(mid).getOrder_number() > ON) {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }

        return orders2;
    }

    public static List<Order> BinarysearchTP(List<Order> orders, float TP) {
        Order.QuickSortTP(orders, 0, orders.size() - 1);
        int first = 0;
        int last = orders.size() - 1;
        int mid = (first + last) / 2;
        List<Order> orders2 = new ArrayList<>();
        while (first < last) {
            if (orders.get(mid).getTotal_price() < TP) {
                first = mid + 1;

            } else if (orders.get(mid).getTotal_price() == TP) {
                for (int i = first; i <= last; i++) {
                    if (orders.get(i).getTotal_price() == TP) {
                        orders2.add(orders.get(i));
                    }
                }
                return orders2;
            } else if (orders.get(mid).getTotal_price() > TP) {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first != last) {
            orders2.add(orders.get(first));
            orders2.add(orders.get(last));
        } else {
            orders2.add(orders.get(first));
        }

        return orders2;

    }

    public static void setTotal_Cash(List<Order> orders) {
        Total_Cash = 0;
        for (int i = 0; i < orders.size(); i++) {
            Total_Cash = Total_Cash + orders.get(i).getTotal_price();
        }
    }

    public static void setTotal_Cashzero() {
        Total_Cash = 0;
    }

    public static double getTotal_Cash() {
        return Math.round(Total_Cash);
    }

    public Timestamp getTm() {
        return timestamp;
    }

    public void setTm(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
