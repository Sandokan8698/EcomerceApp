package jobtech.ecomerce.ecommercesearch.infrastructure.configurations;


import jobtech.ecomerce.ecommercesearch.infrastructure.configurations.elasticsearch.ElasticProperties;
import jobtech.ecomerce.ecommercesearch.infrastructure.security.SecurityProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
public class GlobalProperties {

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    ElasticProperties elasticProperties;


}
