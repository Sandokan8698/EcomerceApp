package jobtech.ecomerce.ecommercesearch.infrastructure.configurations.elasticsearch;


import jobtech.ecomerce.ecommercesearch.infrastructure.configurations.GlobalProperties;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
public class ElasticSearchConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfiguration.class);

    @Autowired
    GlobalProperties globalProperties;

    @Bean
    public Client elasticsearchClient() throws Exception {
        try {

            PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.builder()
                    .put("client.transport.sniff", globalProperties.getElasticProperties().isSniff())
                    .put("cluster.name",  globalProperties.getElasticProperties().getClusterName())
                    .build());

            for (String host:  globalProperties.getElasticProperties().getHosts()) {
                logger.info("ES - Connecting to: "+host+":"+  globalProperties.getElasticProperties().getPort());
                client.addTransportAddress(new TransportAddress(InetAddress.getByName(host),  globalProperties.getElasticProperties().getPort()));
                logger.info("ES - Connected to: "+host+":"+  globalProperties.getElasticProperties().getPort());
            }

            return client;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(elasticsearchClient());
    }

}