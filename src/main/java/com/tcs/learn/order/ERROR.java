package com.tcs.learn.order;

public enum ERROR {
    OUT_OF_STOCK("Product Out of Stock"),
    OUT_OF_COVERAGE("DELIVERY OUT OF COVERAGE");

    private final String errorMessage;

    ERROR(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
