//package storm.applications.spout.parser;

import java.util.List;
import util.config.Configuration;
import util.stream.StreamValues;

/**
 *
 * @author Maycon Viana Bordin <mayconbordin@gmail.com>
 */
public abstract class Parser {
    protected Configuration config;

    public void initialize(Configuration config) {
        this.config = config;
    }

    public abstract List<StreamValues> parse(String input);
}
