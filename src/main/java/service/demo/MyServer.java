package service.demo;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by didi on 2016/11/20.
 */
public class MyServer {
    public static void StartsImplServer(Hello.Processor<HelloImpl> processer){
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(
              new TServer.Args(serverTransport).processor(processer)
            );
            System.out.println("Starting the simpler server");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartsImplServer(new Hello.Processor<HelloImpl>(new HelloImpl()));
    }

}
