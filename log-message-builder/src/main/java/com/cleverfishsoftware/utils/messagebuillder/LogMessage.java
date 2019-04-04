/*
 */
package com.cleverfishsoftware.utils.messagebuillder;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class LogMessage {

    private final HashMap<String, String> tags;
    private String body;

    public enum Level {
        trace,
        debug,
        warn,
        info,
        error,
        severe;
    }

    private LogMessage(Builder builder) {
        tags = new HashMap<>((Map<? extends String, ? extends String>) builder);
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "LogMessage{" + "tags=" + tags + ", body=" + body + '}';
    }

    public static class Builder {

        private final HashMap<String, String> tags = new HashMap<>();
        private final String body;
        private final String ts;
        private final Logger logger;
        private Level level;

        Builder(Logger logger, Level level, String body) {
            this.logger = logger;
            this.body = body;
            ts = Instant.now().toString();
        }

        public Builder addTag(final String key, final String value) {
            tags.put(key, value);
            return this;
        }

        void log() {
            LogMessage msg = new LogMessage(this);
            serializeMsgtoJson(msg);
            switch (level) {
                case trace:
                    logger.trace(msg);
                    break;
                case debug:
                    logger.debug(msg);
                    break;
                case warn:
                    logger.warn(msg);
                    break;
                case info:
                    logger.info(msg);
                    break;
                default:
                    logger.error(msg);
            }
        }

        private void serializeMsgtoJson(LogMessage msg) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
