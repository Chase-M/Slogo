package properties;

import java.util.ResourceBundle;


public class LanguageProperties {
    private static final String PATH = "resources.constants/";
    private static final String DEFAULT_LANGUAGE = "English";
    public static String Language = DEFAULT_LANGUAGE;

    public ResourceBundle getResourceBundle () {
        return ResourceBundle.getBundle(PATH + Language);
    }
}
