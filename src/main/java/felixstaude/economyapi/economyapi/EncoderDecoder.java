package felixstaude.economyapi.economyapi;

import java.util.Base64;

public class EncoderDecoder {

    public String getEncodedString(String string){ return Base64Encode(string); }
    public String getDecodedString(String string){ return Base64Decode(string); }

    private String Base64Encode(String string){
        String encodedString = Base64.getEncoder().encodeToString(string.getBytes());
        return encodedString;
    }
    private String Base64Decode(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
