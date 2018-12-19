package com.clic.cloudops.scheduler.util.beetlsql;


import org.beetl.sql.core.*;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.GenFilter;
import org.beetl.sql.ext.gen.MapperCodeGen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.clic.cloudops.scheduler.util.beetlsql.GenBeetlSql.MysqlDBConfig.password;
import static com.clic.cloudops.scheduler.util.beetlsql.GenBeetlSql.MysqlDBConfig.userName;


public class GenBeetlSql {

    public static void main(String[] args) throws Exception {
        MySqlStyle style = new MySqlStyle();


        ConnectionSource cs = ConnectionSourceHelper.getSimple(MysqlDBConfig.driver,
                MysqlDBConfig.url, userName, password);
        SQLLoader loader = new ClasspathLoader("/sql");
//        C:\Users\Chinalife\Project_Java\server-chg
        System.setProperty("user.dir","C:\\Users\\Chinalife\\Project_Java\\server-chg\\cloudops-scheduler");

        SQLManager sql = new SQLManager(style, loader, cs, new MyNameConversion(), new Interceptor[]{new DebugInterceptor()});


        GenConfig cfg = new GenConfig();
        cfg.setPreferDate(true);
        MapperCodeGen mapper = new MapperCodeGen("com.clic.cloudops.scheduler.dao");
        cfg.codeGens.add(mapper);
//        sql.genPojoCodeToConsole("co_user",cfg);

//        sql.genPojoCode("com.clic.cloudops.scheduler.model",,);
        sql.genALL("com.clic.cloudops.scheduler.model", cfg, new GenFilter() {
            public boolean accept(String tableName) {
                if (tableName.equalsIgnoreCase("area")) {
                    return true;
                } else {
                    return false;
                }
            }
        });


    }


    static class MySqlConnectoinSource implements ConnectionSource {

        private Connection _getConn() {
            String driver = MysqlDBConfig.driver;
            String dbName = MysqlDBConfig.dbName;
            String password = MysqlDBConfig.password;
            String userName = MysqlDBConfig.userName;
            String url = MysqlDBConfig.url;
            Connection conn = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName,
                        password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        public Connection getMaster() {
            return _getConn();
        }

        public Connection getConn(String sqlId, boolean isUpdate, String sql, List paras) {
            return _getConn();
        }


        public boolean isTransaction() {
            // TODO Auto-generated method stub
            return false;
        }

        public Connection getSlave() {
            return this.getMaster();
        }

        public void forceBegin(boolean isMaster) {
            // TODO Auto-generated method stub

        }

        public void forceEnd() {
            // TODO Auto-generated method stub

        }

        @Override
        public Connection getMetaData() {
            // TODO Auto-generated method stub
            return null;
        }


    }

    static class MysqlDBConfig {
        public static String driver = "com.mysql.cj.jdbc.Driver";
        public static String dbName = "stsmanage";
        public static String password = "root";
        public static String userName = "root";
//        public static String url = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
        public static String url = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true";

    }


}
