package dev.markdw.minibuild;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Inject;
import javax.inject.Named;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;
import dev.markdw.minibuild.proto.Minibuild.ProjectConfig;

public class MiniBuild {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private ProjectConfig projectConfig;
  private String cwd;

  @Inject
  public MiniBuild(ProjectConfig projectConfig, @Named("cwd") String cwd) {
    this.cwd = cwd;
    this.projectConfig = projectConfig;
  }

  public void run() {
    // Parse config file
    logger.atInfo().log("Project name and format: %s, version %s", projectConfig.getName(),
        projectConfig.getVersion());
  }
}
