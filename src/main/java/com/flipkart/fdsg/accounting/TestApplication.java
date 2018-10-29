package com.flipkart.fdsg.accounting;


import com.flipkart.fdsg.accounting.dao.EmployeeDAO;
import com.flipkart.fdsg.accounting.entities.Employee;
import com.flipkart.fdsg.accounting.resources.DefaultResource;
import com.flipkart.fdsg.accounting.resources.EmployeeResource;
import com.flipkart.fdsg.accounting.resources.TestEntityResource;
import com.flipkart.fdsg.accounting.service.EmployeeService;
import com.flipkart.fdsg.accounting.setup.PopulateTestEntityManaged;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

/**
 * Created by amith.prasad on 22/10/18.
 */
public class TestApplication extends Application<TestConfiguration> {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World !!");
        new TestApplication().run(args);
    }

    private final HibernateBundle<TestConfiguration> hibernateBundle =
            new HibernateBundle<TestConfiguration>(ImmutableList.of(Employee.class), new SessionFactoryFactory()) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(TestConfiguration configuration) {
            return configuration.getDatabase();
        }

    };

    @Override
    public void initialize(Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(TestConfiguration testConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new DefaultResource());
        environment.jersey().register(new TestEntityResource());

        PopulateTestEntityManaged populateTestEntityManaged = new PopulateTestEntityManaged();
        environment.lifecycle().manage(populateTestEntityManaged);

        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        EmployeeService employeeService = new EmployeeService(new EmployeeDAO(sessionFactory));
        environment.jersey().register(new EmployeeResource(employeeService));
    }
}

//    on run -
//    1. JDK converts to byte code
//    2. create a .class file
//    3. Maven - for every file that is changed - passes the file to javac and .class file is generated
//    4. java runtime (`java` cmd)
//    Eg: javac
//    Eg: java -cp target/classes com.flipkart.fdsg.accounting

// Outproc
// - Tomcat
// - service is already running, we hook our jar or library to it


// Improc
// - Dropwizard
// - will host webservice also

// JAR - java archive - similar to zip

// the dependencies gets downloaded to ~/.m2/repository/

// slim jar deployment
// -
// fat jar
// -

// mvn package
// java -jar target/testproject-1.0.0-SNAPSHOT.jar

// javax - extensions - jpa, injections

// jetty
// - maintains a thread pool
// - manages http connections
// - sends content length - to show progress - optional header

// jersey
// - caches the path
// - finds the path and returns string

// jackson
// - serialize / deserialize
// - converts to json and send it back


// Resources, services and DAOs should be singletons
// - service = business
// - entities - can be any no of objs

// representational state transfer
