package com.javeriana.aes.dockerwebtest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Integer sum(List<Integer> arguments) {
        int result = 0;
        try {
            result = arguments.stream().mapToInt(Integer::intValue).sum();
        } catch (Exception e) {
            logger.error("Exception calculating sum", e);
        }
        return result;
    }

    public Integer mul(List<Integer> arguments) {
        int result = 0;
        try {
            result = arguments.stream().reduce(1, (a, b) -> a * b);
        } catch (Exception e) {
            logger.error("Exception calculating mul", e);
        }
        return result;
    }

    public Integer res(List<Integer> arguments) {
        int result = 0;

        try {
            result = arguments.get(0) - arguments.get(1);
        } catch (Exception e) {
            logger.error("Exception calculating res", e);
        }
        return result;
    }

    public double div(List<Integer> arguments) {
        double result = 0;

        try {
            result = (double) arguments.get(0) / (double) arguments.get(1);
        } catch (Exception e) {
            logger.error("Exception calculating div", e);
        }
        return result;
    }
}
