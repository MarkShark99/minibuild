load("@rules_java//java:defs.bzl", "java_binary")
load("@rules_java//java:java_single_jar.bzl", "java_single_jar")

package(default_visibility = ["//visibility:public"])

java_binary(
    name = "minibuild",
    srcs = ["MiniBuild.java"],
    main_class = "dev.markdw.minibuild.MiniBuild",
    deps = [
        "//src/proto:minibuild_java_proto",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_flogger_flogger_system_backend",
        "@protobuf//java/core",
    ],
)

java_single_jar(
    name = "minibuild-jar",
    deps = [":minibuild"],
)
