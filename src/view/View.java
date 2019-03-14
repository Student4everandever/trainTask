package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

//import static task3.view.TextConstants.INPUT_STRING_DATA;
// import static task3.view.TextConstants.WRONG_INPUT_DATA;

        private static String MESSAGE_BUNDLE_NAME = "messages";
        private static final ResourceBundle bundle =
                ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,
                        //new Locale("ua", "UA")); //Ukrainian
                        new Locale("en"));                       //English

        //Utility methods

        public void printMyString(String message) {
            System.out.println(bundle.getString(message));
        }

        public String returnMyString(String message) {
            return (bundle.getString(message));
        }
}
