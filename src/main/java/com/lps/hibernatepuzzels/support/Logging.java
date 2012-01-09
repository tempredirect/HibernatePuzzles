package com.lps.hibernatepuzzels.support;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 */
public class Logging {
   public static void configure() {
      BasicConfigurator.configure();

      Logger.getLogger("org.hibernate").setLevel(Level.WARN);
      Logger.getLogger("org.hibernate.tool.hbm2ddl.SchemaExport").setLevel(Level.WARN);
      Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
   }
}
