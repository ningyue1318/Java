package ChainOfResponsibility;

abstract class Handler{
    protected Handler successor = null;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handle();
}

class HandlerA extends Handler{

    @Override
    public void handle() {
        boolean handled = false;

        if(!handled&&successor!=null){
            successor.handle();
        }
    }
}

class HandlerB extends Handler{

    @Override
    public void handle() {
        boolean handled = false;

        if(!handled&&successor!=null){
            successor.handle();
        }
    }
}

class HandlerChain{
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);

        if(head==null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail=handler;
    }

    public void handle(){
        if(head!=null){
            head.handle();
        }
    }
}


public class main {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
