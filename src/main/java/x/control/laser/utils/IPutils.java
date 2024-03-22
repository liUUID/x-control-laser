package x.control.laser.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * x.control.laser.utils
 *
 * @author yuanBin Li
 **/
public class IPutils {

    public static boolean isValidIPv4(String ipAddress) {
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipv4Pattern);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
}
