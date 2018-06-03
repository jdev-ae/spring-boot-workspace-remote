package com.surendra.atm.controllers;

import com.surendra.atm.configuration.annotations.EnableAccountsApiSwaggerFilter;
import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.exceptions.UnauthorizedException;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.StatusFactory;
import com.surendra.atm.model.requests.RegisterAccountRequest;
import com.surendra.atm.model.responses.AccountBalanceResponse;
import com.surendra.atm.model.responses.AccountInfoResponse;
import com.surendra.atm.model.responses.RegisterAccountResponse;
import com.surendra.atm.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/account")
@EnableAccountsApiSwaggerFilter
@Api(tags = "Accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "Register new account")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterAccountResponse registerNewAccount(@RequestBody final RegisterAccountRequest request) throws TransactionException {
        return accountService.registerNewAccount(request);
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ApiOperation(value = "Get account balance", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.OK)
    public AccountBalanceResponse getAccountBalance(Principal principal) throws UnauthorizedException {
        if (principal == null) throw new UnauthorizedException();
        return accountService.getAccountBalance(principal.getName());
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value = "Get account information", authorizations = {@Authorization(value = "basicAuth")})
    @ResponseStatus(HttpStatus.OK)
    public AccountInfoResponse getAccountInfo(Principal principal) throws UnauthorizedException {
        if (principal == null) throw new UnauthorizedException();
        return accountService.getAccountInfo(principal.getName());
    }

}
