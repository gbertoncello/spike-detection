//package storm.applications.sink;

import backtype.storm.tuple.Fields;
import org.slf4j.Logger;
import AbstractBolt;
import BaseConstants.BaseConf;
import formatter.BasicFormatter;
import formatter.Formatter;
import util.config.ClassLoaderUtils;


public abstract class BaseSink extends AbstractBolt {
    protected Formatter formatter;
    
    @Override
    public void initialize() {
        String formatterClass = config.getString(getConfigKey(BaseConf.SINK_FORMATTER), null);
        
        if (formatterClass == null) {
            formatter = new BasicFormatter();
        } else {
            formatter = (Formatter) ClassLoaderUtils.newInstance(formatterClass, "formatter", getLogger());
        }
        
        formatter.initialize(config, context);
    }
    
    @Override
    public Fields getDefaultFields() {
        return new Fields("");
    }
    
    protected String getConfigKey(String template) {
        return String.format(template, configPrefix);
    }
    
    protected abstract Logger getLogger();
}
