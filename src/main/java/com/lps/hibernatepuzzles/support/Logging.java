package com.lps.hibernatepuzzles.support;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 */
public class Logging {
   public static void configure() {
      BasicConfigurator.configure();
      Logger.getRootLogger().setLevel(Level.WARN);
//      Logger.getLogger("org.hibernate").setLevel(Level.WARN);
      Logger.getLogger("org.hibernate.tool.hbm2ddl.SchemaExport").setLevel(Level.WARN);
      Logger.getLogger("com.lps.hibernatepuzzles").setLevel(Level.INFO);
      enableSql();
   }

   public static void disableSql() {
      Logger.getLogger("org.hibernate.SQL").setLevel(Level.WARN);
   }

   public static void enableSql() {
      Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
   }
}
