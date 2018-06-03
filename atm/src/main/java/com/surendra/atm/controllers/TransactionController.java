package com.surendra.atm.controllers;

import com.surendra.atm.configuration.annotations.EnableTransactionsApiSwaggerFilter;
import com.surendra.atm.enums.TransactionType;
import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.exceptions.UnauthorizedException;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.requests.TransactionRequest;
import com.surendra.atm.model.responses.UserTransactionsResponse;
import com.surendra.atm.services.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping(value = "/transactions")
@EnableTransactionsApiSwaggerFilter
@Api(tags = "Transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/deposit/{amount}", method = RequestMethod.POST)
    @ApiOperation(value = "Deposit amount to account", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Status deposit(@PathVariable("amount") BigDecimal amount, Principal principal) throws UnauthorizedException, TransactionException {
        if (principal == null) throw new UnauthorizedException();
        return transactionService.makeTransaction(new TransactionRequest(amount, null, TransactionType.DEPOSIT, TransactionType.DEPOSIT.name()), principal.getName());
    }

    @RequestMapping(value = "/withdraw/{amount}", method = RequestMethod.POST)
    @ApiOperation(value = "Withdraw amount to account", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Status withdraw(@PathVariable("amount") BigDecimal amount, Principal principal) throws UnauthorizedException, TransactionException {
        if (principal == null) throw new UnauthorizedException();
        return transactionService.makeTransaction(new TransactionRequest(amount, null, TransactionType.WITHDRAW, TransactionType.WITHDRAW.name()), principal.getName());
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @ApiOperation(value = "Transfer amount to another account", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Status transfer(@RequestBody TransactionRequest request, Principal principal) throws Exception {
        if (principal == null) throw new UnauthorizedException();
        if (request == null || request.getAmount() == null || StringUtils.isEmpty(request.getToAccountEmail())) {
            throw new TransactionException("Invalid transaction details");
        }
        request.setTransactionType(TransactionType.TRANSFER);
        return transactionService.makeTransaction(request, principal.getName());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get user transactions", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.OK)
    public UserTransactionsResponse getUserTransactions(Principal principal) throws UnauthorizedException {
        if (principal == null) throw new UnauthorizedException();
        return transactionService.getUserTransactions(principal.getName());
    }

}
