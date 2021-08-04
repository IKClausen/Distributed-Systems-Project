package grpc.service3;

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
 * <pre>
 * Unary gRPC definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class newServiceGrpc {

  private newServiceGrpc() {}

  public static final String SERVICE_NAME = "newService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.service3.balanceRequest,
      grpc.service3.balanceResponse> getViewBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewBalance",
      requestType = grpc.service3.balanceRequest.class,
      responseType = grpc.service3.balanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.service3.balanceRequest,
      grpc.service3.balanceResponse> getViewBalanceMethod() {
    io.grpc.MethodDescriptor<grpc.service3.balanceRequest, grpc.service3.balanceResponse> getViewBalanceMethod;
    if ((getViewBalanceMethod = newServiceGrpc.getViewBalanceMethod) == null) {
      synchronized (newServiceGrpc.class) {
        if ((getViewBalanceMethod = newServiceGrpc.getViewBalanceMethod) == null) {
          newServiceGrpc.getViewBalanceMethod = getViewBalanceMethod = 
              io.grpc.MethodDescriptor.<grpc.service3.balanceRequest, grpc.service3.balanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "newService", "viewBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service3.balanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service3.balanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new newServiceMethodDescriptorSupplier("viewBalance"))
                  .build();
          }
        }
     }
     return getViewBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.service3.transactionRequest,
      grpc.service3.transactionResponse> getViewTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewTransactions",
      requestType = grpc.service3.transactionRequest.class,
      responseType = grpc.service3.transactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.service3.transactionRequest,
      grpc.service3.transactionResponse> getViewTransactionsMethod() {
    io.grpc.MethodDescriptor<grpc.service3.transactionRequest, grpc.service3.transactionResponse> getViewTransactionsMethod;
    if ((getViewTransactionsMethod = newServiceGrpc.getViewTransactionsMethod) == null) {
      synchronized (newServiceGrpc.class) {
        if ((getViewTransactionsMethod = newServiceGrpc.getViewTransactionsMethod) == null) {
          newServiceGrpc.getViewTransactionsMethod = getViewTransactionsMethod = 
              io.grpc.MethodDescriptor.<grpc.service3.transactionRequest, grpc.service3.transactionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "newService", "viewTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service3.transactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service3.transactionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new newServiceMethodDescriptorSupplier("viewTransactions"))
                  .build();
          }
        }
     }
     return getViewTransactionsMethod;
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
   * <pre>
   * Unary gRPC definition
   * </pre>
   */
  public static abstract class newServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client requests to view balance
     * </pre>
     */
    public void viewBalance(grpc.service3.balanceRequest request,
        io.grpc.stub.StreamObserver<grpc.service3.balanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getViewBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * View account transaction history
     * </pre>
     */
    public void viewTransactions(grpc.service3.transactionRequest request,
        io.grpc.stub.StreamObserver<grpc.service3.transactionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getViewTransactionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViewBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.service3.balanceRequest,
                grpc.service3.balanceResponse>(
                  this, METHODID_VIEW_BALANCE)))
          .addMethod(
            getViewTransactionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.service3.transactionRequest,
                grpc.service3.transactionResponse>(
                  this, METHODID_VIEW_TRANSACTIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Unary gRPC definition
   * </pre>
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
     * <pre>
     * Client requests to view balance
     * </pre>
     */
    public void viewBalance(grpc.service3.balanceRequest request,
        io.grpc.stub.StreamObserver<grpc.service3.balanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getViewBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * View account transaction history
     * </pre>
     */
    public void viewTransactions(grpc.service3.transactionRequest request,
        io.grpc.stub.StreamObserver<grpc.service3.transactionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getViewTransactionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Unary gRPC definition
   * </pre>
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
     * <pre>
     * Client requests to view balance
     * </pre>
     */
    public grpc.service3.balanceResponse viewBalance(grpc.service3.balanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getViewBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * View account transaction history
     * </pre>
     */
    public grpc.service3.transactionResponse viewTransactions(grpc.service3.transactionRequest request) {
      return blockingUnaryCall(
          getChannel(), getViewTransactionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Unary gRPC definition
   * </pre>
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
     * <pre>
     * Client requests to view balance
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.service3.balanceResponse> viewBalance(
        grpc.service3.balanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getViewBalanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * View account transaction history
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.service3.transactionResponse> viewTransactions(
        grpc.service3.transactionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getViewTransactionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VIEW_BALANCE = 0;
  private static final int METHODID_VIEW_TRANSACTIONS = 1;

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
        case METHODID_VIEW_BALANCE:
          serviceImpl.viewBalance((grpc.service3.balanceRequest) request,
              (io.grpc.stub.StreamObserver<grpc.service3.balanceResponse>) responseObserver);
          break;
        case METHODID_VIEW_TRANSACTIONS:
          serviceImpl.viewTransactions((grpc.service3.transactionRequest) request,
              (io.grpc.stub.StreamObserver<grpc.service3.transactionResponse>) responseObserver);
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
      return grpc.service3.NewServiceImpl.getDescriptor();
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
              .addMethod(getViewBalanceMethod())
              .addMethod(getViewTransactionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
