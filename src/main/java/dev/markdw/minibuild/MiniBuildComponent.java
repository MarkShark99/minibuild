package dev.markdw.minibuild;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {MiniBuildModule.class})
public interface MiniBuildComponent {
  MiniBuild miniBuild();

  @Component.Builder
  interface Builder {
    MiniBuildComponent build();

    @BindsInstance
    Builder setCwd(@Named("cwd") String cwd);

    @BindsInstance
    Builder setArgs(@Named("args") String[] args);
  }
}
