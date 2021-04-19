package hu.szabo.painmeasure.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.stereotype.Component;

import hu.szabo.painmeasure.constant.DatabasePropertiesConstant;
import hu.szabo.painmeasure.constant.DatasourceModeConstant;
import hu.szabo.painmeasure.utils.PropertiesUtils;


@Configuration
@Component
public class DatabaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	@Primary
	public DataSource dataSource() {

		Properties p;
		try {
			p = PropertiesUtils.getProperties(DatabasePropertiesConstant.MYSQL_DATABASE_CONFIGURATION);

			if (Boolean.TRUE.equals(
					p.getProperty(DatabasePropertiesConstant.MODE.trim()).equals(DatasourceModeConstant.PROPERTIES))) {

				return DataSourceBuilder.create().username(p.getProperty(DatabasePropertiesConstant.USERNAME))
						.password(p.getProperty(DatabasePropertiesConstant.PW))
						.url(p.getProperty(DatabasePropertiesConstant.URL))
						.driverClassName(p.getProperty(DatabasePropertiesConstant.DRIVER_CLASS_NAME)).build();

			} else if (Boolean.TRUE
					.equals(p.getProperty(DatabasePropertiesConstant.MODE).equals(DatasourceModeConstant.JNDI))) {

				JndiObjectFactoryBean jndiFactory = new JndiObjectFactoryBean();
				jndiFactory.setJndiName(p.getProperty(DatabasePropertiesConstant.JNDI_NAME));
				jndiFactory.setResourceRef(true);
				jndiFactory.setProxyInterface(DataSource.class);
				jndiFactory.setLookupOnStartup(false);
				jndiFactory.afterPropertiesSet();
				return (DataSource) jndiFactory.getObject();

			} else {

				throw new BadDatasourceModeNameException("DatasourceMode:"
						+ p.getProperty(DatabasePropertiesConstant.MODE) + " Must be jndi or properties!");
			}

		} catch (Exception e) {

			LOGGER.error("Datasource not found! ", e.getMessage(), e);
			return null;
		}

	}
}
