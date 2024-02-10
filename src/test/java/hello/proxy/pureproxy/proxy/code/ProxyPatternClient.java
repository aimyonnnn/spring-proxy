package hello.proxy.pureproxy.proxy.code;

public class ProxyPatternClient {

    private Subject subject; // Subject라는 인터페이스에 의존

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }

}
