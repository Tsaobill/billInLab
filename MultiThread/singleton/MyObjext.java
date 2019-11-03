package MultiThread.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-15 18:34
 **/
public class MyObjext {
    public enum MySingleton {
        INSTANCE;


        private Connection connection;

        MySingleton() {
            // 枚举的构造方法里可以用来进行连接
            try {

                connection = DriverManager.getConnection ("", "", "");
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }

        public Connection getConnection() {
            return connection;
        }


    }

    public static Connection getConnection() {
        return MySingleton.INSTANCE.getConnection ();

    }
}
