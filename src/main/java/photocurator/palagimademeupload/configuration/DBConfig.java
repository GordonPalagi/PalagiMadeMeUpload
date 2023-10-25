//package photocurator.palagimademeupload.configuration;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//import org.apache.commons.dbcp2.BasicDataSource;
//
//@Component
//@ConfigurationProperties(prefix = "palagimademe")
//@Data
//public class DBConfig {
//    @Value("${palagimademe.username}")
//    private String username;
//    @Value("${palagimademe.password}")
//    private String password;
//    @Value("${palagimademe.url}")
//    private String url;
//
//    public BasicDataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//}
