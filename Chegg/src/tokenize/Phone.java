package tokenize;
import java.util.StringTokenizer;

public class Phone {
	public static void main(String[] args) {        
//        String phoneNumber = "(nnn) nnn-nnnn";
		String phoneNumber = "(860) 222-3344";
        StringTokenizer PHONE = new StringTokenizer(phoneNumber);
//        StringTokenizer tokenizeExchange = new StringTokenizer(phoneNumber, " ");
//        StringTokenizer areaCode = new StringTokenizer(phoneNumber, "()");
//        StringTokenizer exchange = new StringTokenizer(phoneNumber,")-");
//        StringTokenizer extension = new StringTokenizer(phoneNumber);
//        
//        System.out.println(areaCode.nextToken());
//        System.out.println(exchange.nextToken());
//        System.out.println(extension.nextToken());
//        System.out.println("\n \n");
//        System.out.println(tokenizeExchange.nextToken());
//        while (tokenizeExchange.hasMoreElements()) {
//          System.out.println(tokenizeExchange.nextToken());
////          System.out.println(tokenizeExchange.nextElement());
//        }
       Phone p = new Phone();
       System.out.println("AREA CODE: " + p.get_areacode(PHONE));
       System.out.println("EXCHANGE: " + p.get_exchange(PHONE));
       System.out.println("EXTENSION: " + p.get_extension(PHONE));
    }
	public String get_areacode (StringTokenizer PHONE) {
   	 String areaCode = PHONE.nextToken("()");
        return areaCode;
    }
    public String get_exchange (StringTokenizer PHONE) {
   	 String exchange = PHONE.nextToken(")-");
        return exchange;
    }
    public String get_extension (StringTokenizer PHONE) {
   	 String extension = PHONE.nextToken();
        return extension;
    }
}
