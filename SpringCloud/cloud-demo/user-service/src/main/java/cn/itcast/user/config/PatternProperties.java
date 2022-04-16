package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Doromv
 * @create 2022-04-16-15:36
 */
@Data
@ConfigurationProperties(prefix = "pattern")
@Component
public class PatternProperties {
    private String dateformat;
}
