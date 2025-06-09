load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "dependency_graph",
    srcs = [
        "DependencyGraph.java",
    ],
    deps = [
        "//src/main/java/dev/markdw/minibuild:util",
        "//src/proto:minibuild_java_proto",
    ],
)
