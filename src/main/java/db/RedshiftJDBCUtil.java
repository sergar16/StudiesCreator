package db;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.redshift.AmazonRedshift;
import com.amazonaws.services.redshift.AmazonRedshiftClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * This class consists of methods that assigned to work with Redshift.
 * You shouldn't create connection before calling other methods.Class checks the connection and creates it if it's needed.
 * If you don't open connection before some operations then there will be an error(log will notify you about it).
 * To create connection used JDBC 4.0 and Postgresql driver.
 * There is a method that inserts the log into table as well.
 * As Redshift is a relation database to process the data in the tables, we use simple SQL queries.
 * Also they are used for table creation (that have constant structure).
 * The structure is constant because we need to save only logs.
 * This class includes also methods that make group queries to Redshift (that is its strong side).
 */
public class RedshiftJDBCUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RedshiftJDBCUtil.class);
    private static  String REDSHIFT_ENDPOINT = "logitech-analytics-ksolod.cdcrmjgf6mls.eu-west-1.redshift.amazonaws.com";
    private static  String masterUsername = "ksolod";
    private static  String masterUserPassword = "Logitech1234";
    private static  String dbURL = "jdbc:postgresql://logitech-analytics-ksolod.cdcrmjgf6mls.eu-west-1.redshift.amazonaws.com:5439/logs";
    private static  String LOGS_REDSHIFT_OUTPUT_TABLE_NAME = "logs";
    //redshift client and endpoint
    private static final AmazonRedshift redshift;
    private static Connection conn;

    /**
     * The initialization of AmazonRedshiftClient.
     */
    static {
        redshift = new AmazonRedshiftClient(new ProfileCredentialsProvider());
       // redshift.setEndpoint("logitech-analytics-ksolod.cdcrmjgf6mls.eu-west-1.redshift.amazonaws.com");
    }

    /**
     * This method is used to create  connection with Redshift cluster.
     * It should be called first before all the other operations.
     */
    public static void createConnection() throws Exception {
        try {
            //Dynamically load driver at runtime.
            //Redshift JDBC 4.1 driver: com.amazon.redshift.jdbc41.Driver
            //Redshift JDBC 4 driver: com.amazon.redshift.jdbc4.Driver
            Class.forName("org.postgresql.Driver");
            //Open a connection and define properties.
            System.out.println("Connecting to database...");
            final Properties props = new Properties();
            //Uncomment the following line if using a keystore.
            //props.setProperty("ssl", "true");
            props.setProperty("user", masterUsername);
            props.setProperty("password",masterUserPassword);
            conn = DriverManager.getConnection(dbURL, props);
            LOG.info("\t Redshift: Connection successfully created");
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("\t Redshift: Connection is not created " + e.toString());
            e.printStackTrace();
            throw new Exception("Connection isn't created");

        }
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
                LOG.info("\t Redshift: Connection closed");
            } else {
                LOG.error("\t Redshift: Connection cannot be closed, because It's not created.11'");
            }
        } catch (SQLException sqle) {
            LOG.error("\t Redshift: Connection can not be closed");
        }
    }

    /**
     * Method creates table with a permanent structure that describes everything inside of it.
     * This table is assigned to save only logs.
     *
     * @param tableName -name of table that we want to create.
     */
    public static void createTableForLogs(final String tableName) {

            final String tableConstructor = " (" +
                    "id varchar(100) CONSTRAINT key PRIMARY KEY," +
                    "time varchar(40)," +
                    "userid integer," +
                    "key varchar(70)," +
                    "value varchar(70));";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("CREATE TABLE " + tableName + tableConstructor);
                LOG.info("\t Redshift: Table " + tableName + " successfully created");
            } catch (SQLException sqle) {
                LOG.error("\t Redshift: Table " + tableName + " can not be created \n" + sqle.toString());
            } catch (NullPointerException npe) {
                LOG.error("\t Redshift: Table " + tableName + " can not be created. No connection.");
            }

    }

    /**
     * This method deletes a table with this name from database.
     *
     * @param tableName-it's a name of a table that will be deleted.
     */
    public static void deleteTable(final String tableName) {

            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("DROP TABLE " + tableName);
                LOG.info("\t Redshift: Table " + tableName + " successfully deleted");
            } catch (SQLException sqsle) {
                LOG.error("\t Redshift: Table " + tableName + " can not be deleted \n" + sqsle.toString());
            }

    }

    /**
     * This method inserts an object of log into a table, which name is tableName.
     *
     * @param tableName - it's a name of a table which will be used for inserting of log.
     * @param log       - log that will be inserted.
     */

}

