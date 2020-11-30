package com.pjatk.proj1;

public class IrresponsibleSenderWithDangerousGoods extends Exception {
    String containerInformation;

    IrresponsibleSenderWithDangerousGoods(String containerInformation){
        this.containerInformation = containerInformation;
    }
}
