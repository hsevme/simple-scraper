package me.hsev;

import static me.hsev.UserCommunicationStrings.Info;
import static me.hsev.UserCommunicationStrings.Errors;

public class UserCommunicationService {
    public static void welcome() {
        System.out.println(Info.WELCOME);
        System.out.println(Info.DESCRIPTION);
    }

    public static void askToWait() {
        System.out.println(Info.PROCESSING);
    }

    public static void showOutput(String output) {
        System.out.println(output);
    }

    public static void noArgumentsGiven() {
        System.out.println(Errors.NO_ARGUMENTS);
        System.out.println(Info.USAGE);
    }

    public static void downloadFailed() {
        System.out.println(Errors.DOWNLOAD_FAILED);
    }

    public static void malformedUrl() {
        System.out.println(Errors.MALFORMED_URL);
    }
}
