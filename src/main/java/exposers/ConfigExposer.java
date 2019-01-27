package exposers;


import annotations.Config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ConfigExposer {

    private Properties properties;

    @PostConstruct
    private void initProps() throws IOException {
        try(InputStream is = ConfigExposer.class.getResourceAsStream("/application.properties")){
            properties = new Properties();
            properties.load(is);
        }
    }

    @Produces
    @Config("unused")
    public String exposeConfig(InjectionPoint injectionPoint){
        String key = injectionPoint.getAnnotated().getAnnotation(Config.class).value();
        return properties.getProperty(key);
    }


}
