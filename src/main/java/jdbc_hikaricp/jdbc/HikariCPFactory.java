package jdbc_hikaricp.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPFactory {

	private HikariDataSource dataSource;
	private int minIdle = 10;
	private int maxPoolSize = 100;

	public HikariCPFactory() {
		try (InputStream is = ClassLoader.getSystemResourceAsStream("application.properties")) {
			Properties prop = new Properties();
			prop.load(is);
			HikariConfig cfg = new HikariConfig(prop);
			dataSource = new HikariDataSource(cfg);
			dataSource.setMinimumIdle(minIdle);
			dataSource.setMaximumPoolSize(maxPoolSize);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
	}

	public HikariDataSource getDataSource() {
		return dataSource;
	}

}
