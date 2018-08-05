public class Codec {

  HashMap h = new HashMap();

    char[] CharMap =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl == null || longUrl.length() == 0) return null;
        int key1 = longUrl.hashCode();
        
    
        //we need to convert int key to positive numbers
        long key = key1 + 2147483648l - 1;
        
        if(h.containsKey(key) == true){
           return ConvertToBase62(key); 
        }
        else {
            String s = ConvertToBase62(key);
            System.out.println("Putting key: "+ Integer.toHexString((int)key) + " for string " + s + " of " + longUrl);

            h.put(key, longUrl);
            return s;
        }
      
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortUrl==null) return null;
        long key = ConvertFromBase62(shortUrl);
        System.out.println("Trying to decode " + shortUrl + " with " + Integer.toHexString((int)key));
        if(h.containsKey(key)){
            return (String)h.get(key);
        }
        return null;
    }
    
    String ConvertToBase62(long k){
        String s = "";
        while ( k!=0 ){
            int p = (int)(k%62);
            s += CharMap[p];
            k /= 62;
        }    
        return s;
    }
    
    long ConvertFromBase62(String s){
        int len = s.length();
        long res = 0; 
        int cnt = 1;
        String m = new String(CharMap);
        for( int j = 0; j < len; j++){
            char x = s.charAt(j);
            int i = m.indexOf(x);
            if(j == 0) res = i;
            else res = res + (long)i*(long)cnt;
            cnt*=62;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
