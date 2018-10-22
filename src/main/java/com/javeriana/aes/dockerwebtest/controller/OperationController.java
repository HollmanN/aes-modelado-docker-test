package com.javeriana.aes.dockerwebtest.controller;

import com.javeriana.aes.dockerwebtest.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationController {

    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping(value = "/sum/{arguments}", method = RequestMethod.GET)
    public float sum(@PathVariable List<Integer> arguments) {
        Assert.notNull(arguments, "The arguments can't be null");
        Assert.notEmpty(arguments, "The arguments can't be empty");
        return operationService.sum(arguments);
    }

    @RequestMapping(value = "/res/{arguments}", method = RequestMethod.GET)
    public float res(@PathVariable List<Integer> arguments) {
        Assert.notNull(arguments, "The arguments can't be null");
        Assert.notEmpty(arguments, "The arguments can't be empty");
        Assert.isTrue(arguments.size() == 2, "The arguments size must be 2");
        return operationService.res(arguments);
    }

    @RequestMapping(value = "/mul/{arguments}", method = RequestMethod.GET)
    public float mul(@PathVariable List<Integer> arguments) {
        Assert.notNull(arguments, "The arguments can't be null");
        Assert.notEmpty(arguments, "The arguments can't be empty");
        return operationService.mul(arguments);
    }

    @RequestMapping(value = "/div/{arguments}", method = RequestMethod.GET)
    public double div(@PathVariable List<Integer> arguments) {
        Assert.notNull(arguments, "The arguments can't be null");
        Assert.notEmpty(arguments, "The arguments can't be empty");
        Assert.isTrue(arguments.size() == 2, "The arguments size must be 2");
        Assert.isTrue(arguments.get(1) != 0, "The second argument of a division can't be 0");
        return operationService.div(arguments);
    }
}
