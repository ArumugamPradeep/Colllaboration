package com.niit.collaborate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborate.Dao.BlogDao;
import com.niit.collaborate.Dao.ChatDao;
import com.niit.collaborate.Dao.ForumDao;
import com.niit.collaborate.Dao.FriendDao;
import com.niit.collaborate.Dao.JobsDao;
import com.niit.collaborate.Dao.UserDao;
import com.niit.collaborate.DaoImpl.BlogDaoImpl;
import com.niit.collaborate.DaoImpl.ChatDaoImpl;
import com.niit.collaborate.DaoImpl.ForumDaoImpl;
import com.niit.collaborate.DaoImpl.FriendDaoImpl;
import com.niit.collaborate.DaoImpl.JobsDaoImpl;
import com.niit.collaborate.DaoImpl.UserDaoImpl;
import com.niit.collaborate.Model.Blog;
import com.niit.collaborate.Model.Chat;
import com.niit.collaborate.Model.Forum;
import com.niit.collaborate.Model.Friend;
import com.niit.collaborate.Model.Jobs;
import com.niit.collaborate.Model.User;

@Configuration
@ComponentScan("com.niit.collaborate")
@EnableTransactionManagement

public class DBConfig {
		
	// 1 create a DataSource obj which is used for LocalSessionFactory
	
		@Autowired
		@Bean
		public DataSource getOracleDataSource() 
		{
			DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
			
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			driverManagerDataSource.setUsername("HR");
			driverManagerDataSource.setPassword("HR");
			
			System.out.println("Data Souce Created");
			
			return driverManagerDataSource ;
			
		}
		
		
		// 2 create a Hibernate property for Datasource itz mentory,,,, which is used for LocalSessionFactory
		
		@Autowired
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			
			System.out.println("Hibernate property Object Created");
			
			return properties;
		}
		
		// 3 create a SessionFactory Bean.....local sessionfactory.....
		// sessionFactorydepend on ("hibernate core dependency").
		
		
		@Bean
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder= new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
			localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
			localSessionFactoryBuilder.addAnnotatedClass(User.class);
			localSessionFactoryBuilder.addAnnotatedClass(Jobs.class);
			localSessionFactoryBuilder.addAnnotatedClass(Chat.class); 
			localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
			System.out.println("SessionFactory Bean created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		
		// 4 HibernateTransaction Bean
		
		@Autowired
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
			
		
			return new HibernateTransactionManager(sessionFactory);
			
		}
		
		
		// 5 Application Specific Dao bean.
		
		@Autowired
		@Bean
		public BlogDaoImpl getBlogDAO(SessionFactory sessionFactory)
		{
		return new BlogDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean
		public ForumDao getForumDAO(SessionFactory sessionFactory)
		{
		return new ForumDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean
		public FriendDao getFriendDAO(SessionFactory sessionFactory)
		{
		return new FriendDaoImpl(sessionFactory);
		}
		
		
		@Autowired
		@Bean
		public ChatDao getChatDAO(SessionFactory sessionFactory)
		{
		return new ChatDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean
		public JobsDao getJobsDAO(SessionFactory sessionFactory)
		{
		return new JobsDaoImpl(sessionFactory);
		}
		

		
		@Autowired
		@Bean
		public UserDao getUserDAO(SessionFactory sessionFactory)
		{
			//sessionFactory used for userDaoImpl class
		return new UserDaoImpl(sessionFactory);
		}

}
