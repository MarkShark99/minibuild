load("@protobuf//bazel:java_proto_library.bzl", "java_proto_library")
load("@protobuf//bazel:proto_library.bzl", "proto_library")

package(default_visibility = ["//visibility:public"])

java_proto_library(
    name = "minibuild_java_proto",
    deps = [":minibuild_proto"],
)

proto_library(
    name = "minibuild_proto",
    srcs = ["minibuild.proto"],
)
