package jobtech.ecomerce.ecommercesearch.infrastructure.configurations.elasticsearch;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties("elasticsearch")
@Configuration
public class ElasticProperties {

    private boolean sniff;
    private String clusterName;
    private List<String> hosts;
    private int port;

}
