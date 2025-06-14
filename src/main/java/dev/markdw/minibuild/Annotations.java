package dev.markdw.minibuild;

import static java.lang.annotation.RetentionPolicy.RUNTIME;;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

public final class Annotations {
  @Qualifier
  @Documented
  @Retention(RUNTIME)
  public @interface Cwd {};
}
