package util;


import org.apache.log4j.Logger;
import org.testng.Reporter;

public class ReportWriter {
    private static final Logger LOGGER = Logger.getLogger(ReportWriter.class);

    // ****************** Default message content ********************
    private static final String SEPARATOR = "***********************************************************************";
    private static final String ELEMENT_PRESENT = "PASS: element \"%s\" presents!";
    private static final String ELEMENT_NOT_FOUND = "FAIL: element \"%s\" not found!";
    private static final String PROPERTY_NOT_LOADED = "FAIL: Could not load property \"%s\"!";
    private static final String TEST_FINISHED_SUCCESS = "INFO: test \"%s\" is PASS";
    private static final String TEST_FINISHED_FAILURE = "INFO: test \"%s\" is FAIL, see log for details";
    private static final String PAGE_NOT_LOADED = "FAIL: Could not load page \"%s\"!";
    private static final String INFO_LOG = "INFO: \"%s\"";
    private static final String ERROR_LOG = "ERROR: \"%s\"";

    public static String logElementPresent (String name)
    {
        LOGGER.info(String.format(ELEMENT_PRESENT, name));
        Reporter.log(String.format(ELEMENT_PRESENT, name));
        return String.format(ELEMENT_PRESENT, name);
    }

    public static String logElementNotPresent(String name) {
        LOGGER.info(String.format(ELEMENT_NOT_FOUND, name));
        Reporter.log(String.format(ELEMENT_NOT_FOUND, name));
        return String.format(ELEMENT_NOT_FOUND, name);
    }

    public static String logPropertyNotLoaded(String s)
    {
        LOGGER.error(String.format(PROPERTY_NOT_LOADED, s));
        Reporter.log(String.format(PROPERTY_NOT_LOADED, s));
        return String.format(PROPERTY_NOT_LOADED, s);
    }

    public static void logTestFinishSuccess(Class<?> clazz) {
        LOGGER.info(String.format(TEST_FINISHED_SUCCESS, clazz.getSimpleName()));
        LOGGER.info(SEPARATOR);
        Reporter.log(String.format(TEST_FINISHED_SUCCESS, clazz.getSimpleName()));
        Reporter.log(SEPARATOR);
    }

    public static void logTestFinishFailure(Class<?> clazz) {
        LOGGER.info(String.format(TEST_FINISHED_FAILURE, clazz.getSimpleName()));
        LOGGER.info(SEPARATOR);
        Reporter.log(String.format(TEST_FINISHED_FAILURE, clazz.getSimpleName()));
        Reporter.log(SEPARATOR);
    }

    public static String info (String str)
    {
        LOGGER.info(String.format(INFO_LOG, str));
        Reporter.log(String.format(INFO_LOG, str));
        return String.format(INFO_LOG, str);
    }

    public static String error (String str)
    {
        LOGGER.error(String.format(ERROR_LOG, str));
        Reporter.log(String.format(ERROR_LOG, str));
        return String.format(ERROR_LOG, str);
    }

    public static String logPageNotLoaded(String s)
    {
        LOGGER.error(String.format(PAGE_NOT_LOADED, s));
        Reporter.log(String.format(PAGE_NOT_LOADED, s));
        return String.format(PAGE_NOT_LOADED, s);
    }

}

