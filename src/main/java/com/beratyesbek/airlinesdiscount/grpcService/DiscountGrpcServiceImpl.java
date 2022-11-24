package com.beratyesbek.airlinesdiscount.grpcService;

import com.beratyesbek.airlinesdiscount.repositories.DiscountRepository;
import com.beratyesbek.grpc.DiscountRequest;
import com.beratyesbek.grpc.DiscountResponse;
import com.beratyesbek.grpc.DiscountServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;


public class DiscountGrpcServiceImpl extends DiscountServiceGrpc.DiscountServiceImplBase {

    @Override
    public void getDiscount(DiscountRequest request, StreamObserver<DiscountResponse> responseObserver) {

        super.getDiscount(request, responseObserver);
    }
}
