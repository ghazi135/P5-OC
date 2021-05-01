package com.SafetyNet.api.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Errors implements ErrorController {

    private static final Logger logger = LogManager.getLogger(Errors.class);


    @Override
    public String getErrorPath() {
        return "/error";
        }

        @GetMapping("/error")
        public ModelAndView handleError(HttpServletRequest request) {

            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

            logger.error(status);

            return new ModelAndView("error");
        }

    
}
