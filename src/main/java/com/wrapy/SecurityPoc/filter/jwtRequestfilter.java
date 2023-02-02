package com.wrapy.SecurityPoc.filter;

import com.wrapy.SecurityPoc.services.MyUserDetailsService;
import com.wrapy.SecurityPoc.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class jwtRequestfilter extends OncePerRequestFilter {
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwttoken;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader=request.getHeader("Authorization");
        //System.out.println(request.getHeader("Authorization"));
        String username = null;
        String Jwt = null;
        if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")){
            Jwt=authorizationHeader.substring(7);
            //System.out.println(Jwt);
            username=jwttoken.getUsernameFromToken(Jwt);
            //System.out.println(username.toString());
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication() ==null){
            UserDetails userDetails =this.userDetailsService.loadUserByUsername(username);
            if(jwttoken.validateToken(Jwt,userDetails))
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(
            userDetails,null,userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        }
        filterChain.doFilter(request,response);


    }
}
