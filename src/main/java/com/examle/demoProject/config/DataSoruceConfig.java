package com.examle.demoProject.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.StringTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.examle.demoProject.dao", sqlSessionTemplateRef = "mainSqlSessionTemplate")
public class DataSoruceConfig {

    /**
     * create data source
     * @return
     */

    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "main.datasource")
    DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Create a factory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "mainSqlSessionFactory")
    SqlSessionFactory mainSqlSessionFactory(@Qualifier("mainDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //Specify the directory for mapper.xml
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/examle/mapper/*.xml"));
        bean.setTypeHandlers(new TypeHandler[]{
                new BooleanTypeHandler(),
                new DateTypeHandler(),
                new StringTypeHandler()
        });
        //Specify entity class directory
        bean.setTypeAliasesPackage("com.examle.demoProject");
        return bean.getObject();
    }

    /**
     * Create template
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "mainSqlSessionTemplate")
    SqlSessionTemplate mainqlSessionTemplate(@Qualifier("mainSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
