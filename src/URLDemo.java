import java.net.MalformedURLException;
import java.net.URL;
public class URLDemo {

    public static void main(String[] args) throws MalformedURLException {
        String web = "https://en.wikipedia.org/wiki/URL#Citations";
        URL url = new URL(web);
        getURL(url);
    }

    static void getURL(URL url){
        System.out.println("HOST="+url.getHost());
        System.out.println("PATH="+url.getPath());
        System.out.println("REF="+url.getRef());
    }


}
