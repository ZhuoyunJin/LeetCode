import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
	Map<String, String> longToShortMap = new HashMap<String, String>();
	Map<String, String> shortToLongMap = new HashMap<String, String>();
	int Id = 0;
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String shortUrl = "";
		if(longToShortMap.containsKey(longUrl))
			shortUrl = longToShortMap.get(longUrl);
		else{
			shortUrl = "http://tynyurl.com/"+(Id++);
			longToShortMap.put(longUrl, shortUrl);
			shortToLongMap.put(shortUrl, longUrl);
		}
		return shortUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLongMap.get(shortUrl);

	}
	public static void main(String[] args) {
		EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();
		String url = "hfdhfg";
		System.out.println(codec.decode(codec.encode(url)));

	}
}