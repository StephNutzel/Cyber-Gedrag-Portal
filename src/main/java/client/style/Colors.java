package client.style;

import java.awt.*;

public class Colors {

    public static final Color PRIMARY_COLOR;
    public static final Color SECONDARY_COLOR;
    public static final Color TERTIARY_COLOR;
    public static final Color QUATERNARY_COLOR;

    public static final Color HEADER_COLOR;
    public static final Color SUB_HEADER_COLOR;
    public static final Color TEXT_COLOR;

    public static final Color TRANSPARENT;

    static {
        PRIMARY_COLOR = new Color(54, 57, 63);
        SECONDARY_COLOR = new Color(47, 49, 54);
        TERTIARY_COLOR = new Color(42, 44, 49);
        QUATERNARY_COLOR = new Color(32, 34, 37);

        HEADER_COLOR = new Color(245, 245, 245);
        SUB_HEADER_COLOR = new Color(180, 180, 180);
        TEXT_COLOR = new Color(180, 180, 180);

        TRANSPARENT = new Color(0, 0, 0, 0);
    }

}
