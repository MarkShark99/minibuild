package dev.markdw.minibuild;

import dagger.Component;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;

@Component
@AssistedFactory
public interface MiniBuildFactory {
  MiniBuild create(@Assisted String cwd);
}
