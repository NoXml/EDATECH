package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public abstract class DbAwareTest {

    @Autowired
    private DataSource dataSource;

    protected void executeSql(String sql) {
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            try {
                statement.execute(sql);
                connection.commit();
            } catch (Exception ex) {
                connection.rollback();
                throw new RuntimeException("Error while executing sql", ex);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Can not insert data to DB", ex);
        }
    }

}