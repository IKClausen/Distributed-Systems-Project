// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package grpc.service2;

public final class NewServiceImpl {
  private NewServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_credentials_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_credentials_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_confirmation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_confirmation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_authentication_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_authentication_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016service2.proto\"\037\n\013credentials\022\020\n\010passw" +
      "ord\030\001 \001(\t\"$\n\014confirmation\022\024\n\014confirmatio" +
      "n\030\001 \001(\t\"(\n\016authentication\022\026\n\016authenticat" +
      "ion\030\001 \001(\t2n\n\nnewService\022.\n\013GeneratePIN\022\014" +
      ".credentials\032\r.confirmation\"\000(\001\0220\n\tChang" +
      "ePIN\022\014.credentials\032\017.authentication\"\000(\0010" +
      "\001B!\n\rgrpc.service2B\016NewServiceImplP\001b\006pr" +
      "oto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_credentials_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_credentials_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_credentials_descriptor,
        new java.lang.String[] { "Password", });
    internal_static_confirmation_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_confirmation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_confirmation_descriptor,
        new java.lang.String[] { "Confirmation", });
    internal_static_authentication_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_authentication_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_authentication_descriptor,
        new java.lang.String[] { "Authentication", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
