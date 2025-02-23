package com.buildingblocks.shared.application;

public interface ICommandUseCase<I extends Request, R> {

    R execute(I request);

}
