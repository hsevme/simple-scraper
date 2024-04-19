package me.hsev;

public record UserCommunicationStrings() {

    record Errors() {
        static String MALFORMED_URL = """
            The URL you entered is wrong. Terminating...
            """;
        static String NO_ARGUMENTS = """
            You provided no arguments. Terminating...
            """;
        static String DOWNLOAD_FAILED = """
                Downloading the given page failed!
                This can be due to connection issues
                but also double check your URL
                """;
    }

    record Info() {
        static String DESCRIPTION = """
            web-scraper is a simple scraper capable of
            - downloading HTML pages
            - searching for info specified by the user
            - exporting the info to a CSV file
            """;
        static String PROCESSING = """
            Processing your request...
            """;
        static String USAGE = """
            Usage:
            web-scraper <url> - returns the html of the given source to stdout
            """;
        static String WELCOME = """
            Welcome to web-scraper!
            -----------------------
            """;
    }

}
