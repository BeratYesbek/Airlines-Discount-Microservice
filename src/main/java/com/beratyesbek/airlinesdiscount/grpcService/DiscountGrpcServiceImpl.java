package com.beratyesbek.airlinesdiscount.grpcService;

import com.beratyesbek.airlinesdiscount.models.Discount;
import com.beratyesbek.airlinesdiscount.repositories.DiscountRepository;
import com.beratyesbek.grpc.DiscountRequest;
import com.beratyesbek.grpc.DiscountResponse;
import com.beratyesbek.grpc.DiscountServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


@GrpcService
public class DiscountGrpcServiceImpl extends DiscountServiceGrpc.DiscountServiceImplBase {


    private final DiscountRepository repository;

    @Autowired
    public DiscountGrpcServiceImpl(DiscountRepository repository) {
        this.repository = repository;
    }


    @Override
    public void getDiscount(DiscountRequest request, StreamObserver<DiscountResponse> responseObserver) {
        Discount discount = repository.findDiscountByCode(request.getCode());
        if (discount != null) {
            float newPrice = request.getPrice() - discount.getDiscountPrice();
            DiscountResponse response = DiscountResponse.newBuilder()
                    .setCode(discount.getCode())
                    .setNewPRice(newPrice)
                    .setOldPrice(request.getPrice())
                    .setUserEmail(request.getUserEmail())
                    .setStatusCode(true)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        super.getDiscount(request, responseObserver);
    }
}
