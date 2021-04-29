package jobtech.ecomerce.ecommercesearch.infrastructure.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

@Getter
@Setter
@ConfigurationProperties("security")
@Configuration
public class SecurityProperties {

    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private ResourceLoader resourceLoader;

    private String publicKeyPath;

    @Setter(AccessLevel.NONE)
    private org.springframework.core.io.Resource publicKey;


    @PostConstruct
    private void postConstruct() {
        publicKey = resourceLoader.getResource(publicKeyPath);
    }

}