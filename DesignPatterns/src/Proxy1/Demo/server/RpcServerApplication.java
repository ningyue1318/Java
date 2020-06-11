package Proxy1.Demo.server;

import Proxy1.RpcServer;

public class RpcServerApplication {
    public static void main(String[] args) throws Exception {
        CalculatorService service = new CalculatorServiceImpl();
        RpcServer server = new RpcServer();
        server.export(service,1234);
    }
}
