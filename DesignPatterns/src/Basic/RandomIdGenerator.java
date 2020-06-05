package Basic;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Logger;

public class RandomIdGenerator implements IdGenerator1 {
    private static final Logger logger = Logger.getLogger("RandomIdGenerator.class");

    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",substrOfHostName,currentTimeMillis,randomString);
        return id;
    }

    private String getLastfieldOfHostName(){
        String substrOfHostName = null;
        try{
            String hostName = InetAddress.getLocalHost().getHostName();
            String [] tokens = hostName.split("\\.");
            substrOfHostName = tokens[tokens.length-1];
            return substrOfHostName;
        } catch (UnknownHostException e) {
            logger.warning("Failed to get the host name"+e);
        }
        return substrOfHostName;
    }
    private String generateRandomAlphameric(int length){
        char [] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while(count<length){
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii>='0'&&randomAscii<='9';
            boolean isUppercase = randomAscii>='A'&&randomAscii<='Z';
            boolean idLowercase = randomAscii>='a'&&randomAscii<='z';
            if(isDigit||isUppercase||idLowercase){
                randomChars[count] = (char)(randomAscii);
                count++;
            }
        }

        return new String(randomChars);
    }

    public static void main(String[] args) {
        RandomIdGenerator id = new RandomIdGenerator();
        System.out.println(id.generate());
    }
}
