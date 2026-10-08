package util;

import java.util.Locale;

public final class FormatUtil {
    private static final Locale LOCALE_ID = Locale.forLanguageTag("id-ID");

    private FormatUtil() {
    }

    public static String rupiah(double nominal) {
        if (nominal == 0) {
            return "Gratis";
        }
        return String.format(LOCALE_ID, "Rp%,.0f", nominal);
    }
}
