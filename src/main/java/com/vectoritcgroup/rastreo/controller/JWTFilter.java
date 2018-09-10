package com.vectoritcgroup.rastreo.controller;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.vectoritcgroup.rastreo.model.Parametro;
import com.vectoritcgroup.rastreo.service.ParametroService;

@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com", maxAge = 3600)
@RestController
@Configuration
public class JWTFilter extends GenericFilterBean{
	 private ParametroService service;
	
	private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArov/vqjvFrpMd0IxmPkTNpI9mO0IxLfOfPldIF8311tI5bKmxPZCXlxYD8wigAjhFsJHBhHMR8X3oaq8Ld2XhSyROIOwLhtC7W5lWfT/nqcoUBI2OtFAIiqh/zKynFoL7kCsSu8OrIMMRaAuHY4xRfhgvHGvJdAKFeG5FXODOJrw3M/IcY6Zlx3XUEFp/aj68L+r9jGUY4WhFsyUzdQB03nBvF/0f58B1b63P8yU/eYrkKnD8JCWByPKggz4/x2YPC6QDc4AoyW/uZf7JJLICZPykSvBj5o+P43GpI2C+0U/Gk6Czw4Ut4Cz0OTdT6GZ4hX5/qdyBnKwqXsmoCsWQwIDAQAB";
	

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		ParametroService service = service(request);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,x-requested-with, authorization");
	    
		String token = "";
		String Authorization = request.getHeader("Authorization");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        	System.out.println("OPTIONS");
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
        //	Parametro parametro = service.findByIdParametro(13);
        //	if(parametro.getStatus().equals("A")) {
        		
        		if( Authorization == null || Authorization.isEmpty() ) {
        			System.out.println("Token nulo");
        			response.sendError(401,"Token no informado");
        		}else {
        			if(Authorization.startsWith("Bearer ")) {
        				token = Authorization.split("Bearer ")[1];
        			}else {
        				token = Authorization;
        			}
    			
        			validarToken(token, response, request);
    			
        			filterChain.doFilter(req, res);
    			
        		}
        //	}else {
        		filterChain.doFilter(req, res);
        //	}
        }
        	
	}
	
	public void validarToken(String token, HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			//Algorithm algorithm = Algorithm.RSA256(getPublicKey(request),null);
			Algorithm algorithm = Algorithm.RSA256(getPublicKey(request),null);
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("vector")
					.build() ;
			verifier.verify(token);
		}catch(SignatureVerificationException e){
			response.sendError(401,"Token Invalido: " + e.getMessage());
			e.printStackTrace();
		}catch(TokenExpiredException e) {
			response.sendError(401,"Token expirado: " + e.getMessage());
			e.printStackTrace();
		}catch(AlgorithmMismatchException e) {
			response.sendError(401,"Algoritmo del token incorrecto: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static RSAPublicKey getPublicKey(HttpServletRequest request) {
		PublicKey publicKey = null;
		try {
			
			ParametroService service = service(request);
			
			Parametro parametro = service.findByIdParametro(13);
			
			byte [] decodeValor = Base64.getDecoder().decode(parametro.getValorbd());
	    	
	    	String key = new String(decodeValor);
	    	
			KeyFactory kf = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(PUBLIC_KEY));
			publicKey = kf.generatePublic(spec);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return (RSAPublicKey)publicKey;
	}
	
	
	public static ParametroService service(HttpServletRequest request) {
		ParametroService service;
		ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        service = webApplicationContext.getBean(ParametroService.class);
        
        return service;
	}
	
	private static void generarLlaves() {
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
			KeyPair kp = kpg.generateKeyPair();
			System.out.println("Llave publica");
			System.out.println(Base64.getMimeEncoder().encodeToString(kp.getPublic().getEncoded()));
			System.out.println("Llave privada");
			System.out.println(Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded()));
			/*
			 * Aqui va codigo para guardar el las llaves en la BD
			 * Llave privada: Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded())
			 * Llave publica: Base64.getMimeEncoder().encodeToString(kp.getPublic().getEncoded())
			 * 
			 * */
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error al generar las llaves " + e.getMessage());
			e.printStackTrace();
		} 
	}
	
	

	
}
