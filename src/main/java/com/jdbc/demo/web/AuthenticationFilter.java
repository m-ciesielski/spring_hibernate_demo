package com.jdbc.demo.web;

import javax.servlet.annotation.WebFilter;

/**
 * Created by Mateusz on 14-Nov-15.
 */

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter extends Filter {
}
