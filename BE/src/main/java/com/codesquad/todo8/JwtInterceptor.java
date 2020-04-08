package com.codesquad.todo8;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

  // JWT 요청 : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Imd1ZXN0MTIzNCJ9.ziPecPMs-euqNDajS5_C0uO7-uCkT5Y0kD_GACuxWH4
  private static Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

  @Value("${jwt.token.secret}")
  private String key;

  private final UserService userService;

  public JwtInterceptor(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    String jwt = request.getHeader("Authorization").split(" ")[1];
    logger.debug("JWT : {}", jwt);
    return validationToken(jwt);
  }

  private Boolean validationToken(String jwt) {
    String userId = "";
    if (jwt != null) {
      userId = getUserId(jwt);
      logger.debug("userId : {}", userId);
    }

    if (userId != null) {
      return userService.findById(userId).isPresent();
    }
    return false;
  }

  private String getUserId(String jwt) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(key)
          .build()
          .parseClaimsJws(jwt)
          .getBody()
          .get("id", String.class);
    } catch (JwtException e) {
      logger.debug("JwtException : {}", e.getMessage());
      return null;
    }
  }
}
