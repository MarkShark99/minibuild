package dev.markdw.minibuild;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Named;
import com.google.common.flogger.FluentLogger;
import com.google.protobuf.TextFormat;
import dagger.Module;
import dagger.Provides;
import dev.markdw.minibuild.proto.Minibuild.ProjectConfig;

@Module
public final class MiniBuildModule {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private static final String CONFIG_FILENAME = "config.txtpb";

  @Provides
  ProjectConfig provideProjectConfig(@Named("cwd") String cwd) {
    try {
      Path configPath = Paths.get(cwd, CONFIG_FILENAME);
      if (!Files.exists(configPath)) {
        logger.atSevere().log("%s not found in %s", CONFIG_FILENAME, cwd);
        throw new RuntimeException("Config file could not be found");
      }

      ProjectConfig.Builder builder = ProjectConfig.newBuilder();
      FileReader fileReader = new FileReader(configPath.toFile());
      TextFormat.merge(fileReader, builder);
      return builder.build();
    } catch (IOException e) {
      logger.atSevere().withCause(e).log("Config file could not be read.");
      throw new RuntimeException(e);
    }
  }
}
