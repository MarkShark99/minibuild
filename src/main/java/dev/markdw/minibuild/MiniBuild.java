package dev.markdw.minibuild;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import dev.markdw.minibuild.proto.Minibuild.ProjectConfig;

public class MiniBuild {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private static final String CWD_PROPERTY = "user.dir";
  private static final String CONFIG_FILENAME = "config.txtpb";

  private String cwd;

  @AssistedInject
  public MiniBuild(@Assisted String cwd) {
    this.cwd = cwd;
  }

  public void run(String[] args) {
    if (args.length < 1) {
      logger.atSevere().log("Missing arguments");
      return;
    }

    // Find config file
    String cwd = System.getProperty(CWD_PROPERTY);
    Path configPath = Paths.get(cwd, CONFIG_FILENAME);
    if (!Files.exists(configPath)) {
      logger.atSevere().log("%s not found in %s", CONFIG_FILENAME, cwd);
      return;
    }

    // Parse config file
    ProjectConfig config;
    try {
      config = getProjectConfig(configPath);
    } catch (IOException e) {
      logger.atSevere().withCause(e).log("Error parsing minibuild config file");
      return;
    }

    logger.atInfo().log("Project name and format: %s, version %s", config.getName(),
        config.getVersion());
  }

  private static ProjectConfig getProjectConfig(Path configPath)
      throws IOException, ParseException {
    ProjectConfig.Builder builder = ProjectConfig.newBuilder();
    FileReader fileReader = new FileReader(configPath.toFile());
    TextFormat.merge(fileReader, builder);

    return builder.build();
  }
}
