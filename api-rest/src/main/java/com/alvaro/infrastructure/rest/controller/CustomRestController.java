package com.alvaro.infrastructure.rest.controller;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.web.bind.annotation.RestController
public @interface CustomRestController {

}
