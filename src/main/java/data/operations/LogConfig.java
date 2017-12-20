package data.operations;

import org.apache.log4j.*;

public class LogConfig {
    private static final String pattern = "%d %-5p [%c{1}] %m%n";
    private static Logger log = null;

    public static Level consoleLogLevel = Level.DEBUG;
    public static Level fileLOgLevel = Level.DEBUG;
    public static boolean enableConsoleLog = true;
    public static boolean enableFileLog = false;

    public static Logger getLoger(Class<?> myClass) {
        log = Logger.getLogger(myClass);
        if (enableConsoleLog)
            addConsoleAppender(consoleLogLevel);
        if (enableFileLog)
            addFileAppender(fileLOgLevel);
        return log;
    }

    private static void addConsoleAppender(Level level) {
        ConsoleAppender console = new ConsoleAppender();
        console.setLayout(new PatternLayout(pattern));
        console.setThreshold(level);
        console.activateOptions();
        log.addAppender(console);
    }

    private static void addFileAppender(Level level) {
        FileAppender fa = new FileAppender();
        fa.setFile("file.log");
        fa.setName("myFile");
        fa.setLayout(new PatternLayout(pattern));
        fa.setThreshold(level);
        fa.activateOptions();
        log.addAppender(fa);
    }
}