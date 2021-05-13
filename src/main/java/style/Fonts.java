package style;

import java.awt.*;

public class Fonts {

    public static final Font HEADER_FONT;
    public static final Font HEADER2_FONT;
    public static final Font HEADER3_FONT;
    public static final Font TEXT_FONT;

    static {
        HEADER_FONT = new Font("Microsoft Yahei", Font.BOLD, 26);
        HEADER2_FONT = new Font("Microsoft Yahei", Font.BOLD, 22);
        HEADER3_FONT = new Font("Microsoft Yahei", Font.BOLD, 18);
        TEXT_FONT = new Font("Microsoft Yahei", Font.BOLD, 16);
    }
}
