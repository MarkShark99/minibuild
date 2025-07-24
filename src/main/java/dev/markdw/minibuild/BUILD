load("@dagger//:workspace_defs.bzl", "dagger_rules")
load("@rules_java//java:defs.bzl", "java_binary", "java_library")
load("@rules_java//java:java_single_jar.bzl", "java_single_jar")

package(default_visibility = ["//visibility:public"])

dagger_rules()

java_binary(
    name = "minibuild",
    srcs = glob(["**/*.java"]),
    main_class = "dev.markdw.minibuild.MiniBuildLauncher",
    plugins = [
        ":dagger-compiler",
    ],
    deps = [
        ":dagger",
        "//src/main/java/dev/markdw/minibuild/graph:dependency_graph",
        "//src/proto:minibuild_java_proto",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_flogger_flogger_system_backend",
        "@maven//:javax_inject_javax_inject",
        "@protobuf//java/core",
    ],
)

java_library(
    name = "util",
    srcs = ["Util.java"],
    deps = [],
)

java_single_jar(
    name = "minibuild-jar",
    deps = [":minibuild"],
)
