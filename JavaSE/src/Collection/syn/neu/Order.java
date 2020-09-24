package Collection.syn.neu;

public class Order <T>{
    private String orderName;
    private int orderId;

    private T orderT;
    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

}
