package grpc.service1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class newServiceGrpc {

  private newServiceGrpc() {}

  public static final String SERVICE_NAME = "newService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.service1.paymentDetails,
      grpc.service1.confirmation> getSetRecurringPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetRecurringPayment",
      requestType = grpc.service1.paymentDetails.class,
      responseType = grpc.service1.confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.service1.paymentDetails,
      grpc.service1.confirmation> getSetRecurringPaymentMethod() {
    io.grpc.MethodDescriptor<grpc.service1.paymentDetails, grpc.service1.confirmation> getSetRecurringPaymentMethod;
    if ((getSetRecurringPaymentMethod = newServiceGrpc.getSetRecurringPaymentMethod) == null) {
      synchronized (newServiceGrpc.class) {
        if ((getSetRecurringPaymentMethod = newServiceGrpc.getSetRecurringPaymentMethod) == null) {
          newServiceGrpc.getSetRecurringPaymentMethod = getSetRecurringPaymentMethod = 
              io.grpc.MethodDescriptor.<grpc.service1.paymentDetails, grpc.service1.confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "newService", "SetRecurringPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service1.paymentDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service1.confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new newServiceMethodDescriptorSupplier("SetRecurringPayment"))
                  .build();
          }
        }
     }
     return getSetRecurringPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.service1.cancelPayment,
      grpc.service1.cancelled> getCancelRecurringPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelRecurringPayment",
      requestType = grpc.service1.cancelPayment.class,
      responseType = grpc.service1.cancelled.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.service1.cancelPayment,
      grpc.service1.cancelled> getCancelRecurringPaymentMethod() {
    io.grpc.MethodDescriptor<grpc.service1.cancelPayment, grpc.service1.cancelled> getCancelRecurringPaymentMethod;
    if ((getCancelRecurringPaymentMethod = newServiceGrpc.getCancelRecurringPaymentMethod) == null) {
      synchronized (newServiceGrpc.class) {
        if ((getCancelRecurringPaymentMethod = newServiceGrpc.getCancelRecurringPaymentMethod) == null) {
          newServiceGrpc.getCancelRecurringPaymentMethod = getCancelRecurringPaymentMethod = 
              io.grpc.MethodDescriptor.<grpc.service1.cancelPayment, grpc.service1.cancelled>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "newService", "CancelRecurringPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service1.cancelPayment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service1.cancelled.getDefaultInstance()))
                  .setSchemaDescriptor(new newServiceMethodDescriptorSupplier("CancelRecurringPayment"))
                  .build();
          }
        }
     }
     return getCancelRecurringPaymentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static newServiceStub newStub(io.grpc.Channel channel) {
    return new newServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static newServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new newServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static newServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new newServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class newServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.service1.paymentDetails> setRecurringPayment(
        io.grpc.stub.StreamObserver<grpc.service1.confirmation> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetRecurringPaymentMethod(), responseObserver);
    }

    /**
     */
    public void cancelRecurringPayment(grpc.service1.cancelPayment request,
        io.grpc.stub.StreamObserver<grpc.service1.cancelled> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelRecurringPaymentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetRecurringPaymentMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.service1.paymentDetails,
                grpc.service1.confirmation>(
                  this, METHODID_SET_RECURRING_PAYMENT)))
          .addMethod(
            getCancelRecurringPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.service1.cancelPayment,
                grpc.service1.cancelled>(
                  this, METHODID_CANCEL_RECURRING_PAYMENT)))
          .build();
    }
  }

  /**
   */
  public static final class newServiceStub extends io.grpc.stub.AbstractStub<newServiceStub> {
    private newServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.service1.paymentDetails> setRecurringPayment(
        io.grpc.stub.StreamObserver<grpc.service1.confirmation> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSetRecurringPaymentMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void cancelRecurringPayment(grpc.service1.cancelPayment request,
        io.grpc.stub.StreamObserver<grpc.service1.cancelled> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelRecurringPaymentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class newServiceBlockingStub extends io.grpc.stub.AbstractStub<newServiceBlockingStub> {
    private newServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.service1.cancelled cancelRecurringPayment(grpc.service1.cancelPayment request) {
      return blockingUnaryCall(
          getChannel(), getCancelRecurringPaymentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class newServiceFutureStub extends io.grpc.stub.AbstractStub<newServiceFutureStub> {
    private newServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.service1.cancelled> cancelRecurringPayment(
        grpc.service1.cancelPayment request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelRecurringPaymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CANCEL_RECURRING_PAYMENT = 0;
  private static final int METHODID_SET_RECURRING_PAYMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final newServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(newServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANCEL_RECURRING_PAYMENT:
          serviceImpl.cancelRecurringPayment((grpc.service1.cancelPayment) request,
              (io.grpc.stub.StreamObserver<grpc.service1.cancelled>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_RECURRING_PAYMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setRecurringPayment(
              (io.grpc.stub.StreamObserver<grpc.service1.confirmation>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class newServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    newServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.service1.NewServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("newService");
    }
  }

  private static final class newServiceFileDescriptorSupplier
      extends newServiceBaseDescriptorSupplier {
    newServiceFileDescriptorSupplier() {}
  }

  private static final class newServiceMethodDescriptorSupplier
      extends newServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    newServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (newServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new newServiceFileDescriptorSupplier())
              .addMethod(getSetRecurringPaymentMethod())
              .addMethod(getCancelRecurringPaymentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
