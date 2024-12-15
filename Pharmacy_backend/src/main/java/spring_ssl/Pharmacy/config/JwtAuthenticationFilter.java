package spring_ssl.Pharmacy.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//I want this filter be active every time a request occures
@Component
//@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization"); //The name of the headet which have the JWT
        final String jwt;
        final String userEmail;
        final String userRole;

        //Implement the Check if the header has the jwt
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response); //with this i stop the execution
            return;
        }

        //Try to extract the JWT from the Header
        jwt = authHeader.substring(7); //The 7 is because the word Bearer with the space is 7 letters
        userEmail = jwtService.extractUsername(jwt);//extract the userEmail from JWT token




        //Checks if the user is not authenticated and if not bring user from DB
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            //or to keep the 3 separate tables (https://github.com/chintan-golakiya/exam-portal-springboot-app/blob/jwt-authentication/exam-portal-springboot-app/src/main/java/com/examportal/security/JwtAuthenticationFilter.java)
            //The following implementation creates search depends on the ROLE
//            customUserDetailsService.setUserType(UserType.valueOf(userType));
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userEmail);


            if(jwtService.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request) //build some more details out of the request
                );
                //Update the security holder of the image of the video
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }
        filterChain.doFilter(request, response);//Pass the hand to the next filter

    }
}
