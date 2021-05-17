package com.example.googledemo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;
/**
 * @author ruchipatle
 *
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}