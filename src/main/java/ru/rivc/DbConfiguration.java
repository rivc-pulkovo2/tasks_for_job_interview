package ru.rivc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = {DbConfiguration.SCAN_PACKAGE_DAO},
        entityManagerFactoryRef = DbConfiguration.ENTITY_MANAGER
)
public class DbConfiguration {
    public static final String TRANSACTION_MANAGER = "transactionManager";
    public static final String ENTITY_MANAGER = "entityManager";
    public static final String SCAN_PACKAGE_DAO = "ru.rivc";
    public static final String DATASOURCE = "dataSource";

    @Bean(name = DATASOURCE)
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:h2:mem:test");

        return dataSource;
    }

    @Bean(name = ENTITY_MANAGER)
    @Primary
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManager(@Qualifier(DATASOURCE) DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(SCAN_PACKAGE_DAO);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        // we try to auto-assign properties
        HashMap<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProperties.put("hibernate.format_sql", false);
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.jdbc.time_zone", "UTC");
        jpaProperties.put("org.hibernate.flushMode", "COMMIT");
        jpaProperties.put("hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        em.setJpaPropertyMap(jpaProperties);

        return em;
    }

    @Bean(name = TRANSACTION_MANAGER)
    @Primary
    @Autowired
    JpaTransactionManager transactionManager(@Qualifier(DATASOURCE) DataSource datasource, @Qualifier(ENTITY_MANAGER) EntityManagerFactory emf) {
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setDataSource(datasource);
        tx.setEntityManagerFactory(emf);
        return tx;
    }

}
