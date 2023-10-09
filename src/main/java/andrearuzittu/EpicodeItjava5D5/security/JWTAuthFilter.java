package andrearuzittu.EpicodeItjava5D5.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JWTTools jwtTools;

	@Autowired
	private UserService usersService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String authHeader = request.getHeader("Authorization");

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new IllegalArgumentException("Per favore passa il token nell'authorization header");
			}
			String token = authHeader.substring(7);
			System.out.println("TOKEN -------> " + token);

			jwtTools.verifyToken(token);

			Long userId = Long.parseLong(jwtTools.extractSubject(token));
			Utente currentUser = usersService.findById(userId);

			if (currentUser == null) {
				throw new ServletException("L'utente non è stato trovato.");
			}

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(currentUser, null,
					currentUser.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authToken);

			filterChain.doFilter(request, response);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		System.out.println(request.getServletPath());
		return new AntPathMatcher().match("/auth/**", request.getServletPath());
	}
}
