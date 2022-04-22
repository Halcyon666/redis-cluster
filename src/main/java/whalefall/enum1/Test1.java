package whalefall.enum1;

import org.springframework.util.Assert;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(getChannelFlag(""));

    }

    public static String getChannelFlag(String flagStr) {
        Assert.isTrue(flagStr != null, "flagStr入参不能为空");
        switch (flagStr) {
            case "DSK" : return Channel.DSK.getFlag();
            default: return Channel.ICO.getFlag();
        }

    }
}
