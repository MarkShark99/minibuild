package dev.markdw.minibuild;

public class MiniBuildLauncher {
  private static final String CWD_PROPERTY = "user.dir";

  public static void main(String[] args) {
    MiniBuildComponent.Builder builder = DaggerMiniBuildComponent.builder();
    builder.setCwd(System.getProperty(CWD_PROPERTY));
    builder.setArgs(args);

    MiniBuildComponent component = builder.build();
    MiniBuild miniBuild = component.miniBuild();
    
    miniBuild.run();
  }
}