package social.db;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DbInitializer implements InitializingBean {

    private final DataSource dataSource;

    @Autowired
    public DbInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassPathResource resource = new ClassPathResource("org/springframework/social/connect/jdbc/JdbcUsersConnectionRepository.sql");
        runScript(resource);
    }

    private void runScript(Resource resource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        populator.addScript(resource);
        DatabasePopulatorUtils.execute(populator, dataSource);
    }

}
