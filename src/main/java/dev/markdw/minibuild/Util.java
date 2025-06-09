package dev.markdw.minibuild;

import java.util.regex.Pattern;

public class Util {
  public static final Pattern labelPattern = Pattern.compile("^\\/\\/([^\\\":]+):([^:]+)$");
}
