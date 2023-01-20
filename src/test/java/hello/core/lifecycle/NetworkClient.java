package hello.core.lifecycle;


import org.springframework.context.annotation.Bean;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url : "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    //서비스 시작 호출
    public void connect(){
        System.out.println("NetworkClient.connect =" +url);
    }
    
    public void call(String msg){
        System.out.println("NetworkClient.call url : "+url+", msg : "+msg);
    }
    //서비스 종료
    public void disconnect(){
        System.out.println("NetworkClient.disconnect close:"+url);
    }
    public void init() throws Exception {
        System.out.println("init");
        connect();
        call("초기화 연결메시지");
    }
    public void close() throws Exception {
        System.out.println("close");
        disconnect();
    }
}
