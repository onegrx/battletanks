package edu.paszgr.control;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;



public class MyFormatter extends Formatter {

    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }

    public String getHead(Handler h) {
        return super.getHead(h);
    }

    public String getTail(Handler h) {
        return super.getTail(h);
    }
}