package 设计模式.行为模式.责任链模式;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.行为模式.责任链模式
 * Created by MacBook Air on 2020/07/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    @Test
    public void test1(){

        Request builder = new Request.RequestBuilder()
                .setFrequentOk(true)
                .setLoggedOn(true)
                .setPermits(false)
                .builder();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(new PermitsHandler(null)));
        System.out.println("---- 登陆是否成功：" + requestFrequentHandler.process(builder)+"  ----");
    }
}


class Request{
    private boolean logging;
    private boolean frequentOk;
    private boolean isPermites;

    public boolean isLogging() {
        return logging;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermites() {
        return isPermites;
    }

    public Request(boolean logging, boolean frequentOk, boolean isPermites) {
        this.logging = logging;
        this.frequentOk = frequentOk;
        this.isPermites = isPermites;
    }

    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;

        public RequestBuilder setLoggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        public RequestBuilder setFrequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        public RequestBuilder setPermits(boolean permits) {
            isPermits = permits;
            return this;
        }

        public Request builder(){
            Request request = new Request(loggedOn, frequentOk, isPermits);
            return request;
        }
    }
}

@Data
@NoArgsConstructor
abstract class Handler{
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends  Handler{

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率判断：");
        if(request.isFrequentOk()){
            System.out.println("\t频率正常！");
            if(this.next == null){
                return true;
            }else {
                Handler next = this.next;
                boolean process = next.process(request);
                return process;
            }
        }else {
            System.out.println("\t频率异常!");
            return false;
        }
    }
}
class LoggingHandler extends Handler{

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登陆判断：");
        if(request.isLogging()){
            System.out.println("\t登陆成功！");
            if(this.next == null){
                return true;
            }else {
                return next.process(request);
            }
        }else {
            System.out.println("\t登陆失败！");
            return false;
        }
    }
}
class PermitsHandler extends Handler{
    public PermitsHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("许可证验证：");
        if (request.isPermites()){
            System.out.println("\t许可证正常！");
            if(next == null){
                return false;
            }else {
                return next.process(request);
            }
        }else {
            System.out.println("\t许可证错误！");
            return false;
        }
    }
}