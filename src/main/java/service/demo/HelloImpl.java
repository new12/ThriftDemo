package service.demo;

import org.apache.thrift.TException;

/**
 * Created by didi on 2016/11/20.
 */
public class HelloImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "hello," + para;
    }
}
