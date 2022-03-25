package com.ewmw.client.http.filters;

import com.ewmw.client.exceptions.UnauthorizedRequestException;
import com.ewmw.client.exceptions.responses.UnauthorizedExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class AuthorizedRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            authorize(request);
        } catch (UnauthorizedRequestException e) {
            System.out.println("Unauthorized request!");

            UnauthorizedExceptionResponse unauthorizedExceptionResponse = new UnauthorizedExceptionResponse();

            response.getWriter().write(new ObjectMapper().writeValueAsString(unauthorizedExceptionResponse));
            response.setStatus(unauthorizedExceptionResponse.getResponseStatusCode().value());
            response.setHeader("Content-Type", "application/json");

            return;
        }

        filterChain.doFilter(request, response);
    }

    protected void authorize(HttpServletRequest request) throws UnauthorizedRequestException {
        String authorization = request.getHeader("Authorization");

        if (authorization != null && ! authorization.equals("123"))
            throw new UnauthorizedRequestException();

    }
}
