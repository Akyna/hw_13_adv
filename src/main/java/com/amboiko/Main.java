package com.amboiko;

import com.amboiko.common.Logger;
import com.amboiko.service.FillingService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger.info("START");
        final FillingService fillingService = new FillingService(3);
        final List<Integer> result = fillingService.getFilledList(10);
        Logger.info(Arrays.toString(result.toArray()));
        Logger.info("FINISH");
    }
}
