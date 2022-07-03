package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component // 마치 provider를 쓰는 것과 똑같이 됐다
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 생존범위가 request 니깐 autowired 과정에서 문제가 생김
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " +  message);
    }

    @PostConstruct
    public void init(){
        // 완전히 구분되는 . 중복 확률 거의 없음
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created : " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean closed : " + this);
    }

}
