package dev.markdw.minibuild;

public class MiniBuildLauncher {

  private static final String CWD_PROPERTY = "user.dir";

  public static void main(String[] args) {
    String cwd = System.getProperty(CWD_PROPERTY);

    MiniBuildFactory factory = DaggerMiniBuildFactory.create(cwd);
    factory.create().run(args);
  }
}
