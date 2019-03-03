package com.home.rcncalculator.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * {@code SystemConfig} define the RCN calculator simple system com.airwallex.config items.
 */
public class SystemConfig {

  private static int DEFAULT_STORE_SCALE = 15;
  private static int DEFAULT_DISPLAY_SCALE = 10;
  private static String STORE_SCALE_PROP = "store-scale";
  private static String DISPLAY_SCALE_PROP = "display-scale";
  private static String CONFIG_FILE = "config.properties";

  public static int STORE_SCALE;
  public static int DISPLAY_SCALE;

  //Load system com.airwallex.config from configuration file.
  static {
    try {
      Properties properties = new Properties();
      InputStream in = SystemConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
      properties.load(in);
      STORE_SCALE = Integer.parseInt(properties.getProperty(STORE_SCALE_PROP));
      DISPLAY_SCALE = Integer.parseInt(properties.getProperty(DISPLAY_SCALE_PROP));
    } catch (Exception err) {
      STORE_SCALE = DEFAULT_STORE_SCALE;
      DISPLAY_SCALE = DEFAULT_DISPLAY_SCALE;
    }
  }
}
