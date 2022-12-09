package com.in28minutes.springboot.springbootwebapp.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class with auxiliary functions.
 */
public class Utils {

  private Utils() {
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

  public static String getResourceFileAsString(final String filename) {
    try {
      return Files.readString(Path.of(
              String.format("src/main/resources/html/%s", filename)),
          StandardCharsets.UTF_8);
    } catch (Exception e) {
      LOGGER.info("Error getting the file {}", filename);
    }
    return null;
  }
}
