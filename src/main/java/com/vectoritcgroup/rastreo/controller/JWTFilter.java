package com.vectoritcgroup.rastreo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.util.encoders.Base64Encoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

//@Configuration
public class JWTFilter extends GenericFilterBean{
	
	private static final String PRIVATE_KEY = "MIIEpAIBAAKCAQEA3XTyzHtUtTxj2HqSNEyOOvutS0HLxvm9TVXimpxMTkgSUIFn1mo//yeJxj2BN+AOtynDt4hcyn1x+2nUV43Uj2evNdHItsyqAu8vumbTQ/QIsNPIgq9IdJu34OrVlPKPq2QjJpFAcdlYyoam8yjTZNav0s1gepGKp9Crpwdtkk12xex20/R19S8WW/9psoZvCrpt/RIqyN0x/OXbekZghrg0DeLXLNKdr0A6oaaOxhl3rCF2Fn61Kcy214a/lkNmbamUcqh9jsmnlyhrPO650QanJI1V28bsX1swSrZzAOofAeCO17f6N1vDcSjRN6VWsIorKND3KloAHC8OzD6KDwIDAQABAoIBAQCrLrJb892XtpWriZuoR6EN4Oukp7iAFx4IQKJIRxcIz9cwWcdNS5YqgoKSNYrECTL2zJbYMNUhRPStlbGo+B5dt5UNMhtHik7Es+Ud3kviVCm/ngV5V0rXsGLjvkLYvuLlZiNxtYeuOYbUDl/QyDcX1IfWmCDCvewDKl71Xt2I314cAZJfC5OIha/PtdSoljqb5hzaO1y21B2CgN3GmvJUSOfjF9G6Daca3eCCOz5FxeuBYMqVdl/q4j6BQXd1/o/P8846kVsUlerk5hugey+nCSRNwKxOc2mgWB/YWlZkxXobrbCCVpPPmLnU1Vcr9hYz4fOg7XMelBqqwb+zSFb5AoGBAO7ePjnqwSI5cj9b0KuUA/5WpUaBQ3lKkBp31cSL3FLsDgIwZ9lxP4PQry5PNbEawwBzwMSvrxX1PiIdnEhr1HS9lKJ9/TNa9anvAhEsb/0cBKw1XqOjO++6b+qDGv5mihggmBu7fe6vLw9iZbc16hAfL4KPSx/Td/5qUNfg4lv1AoGBAO1XBhGw8Pka8UmQcuF7EW9qCBUVHHciwn2cRCISWGbmzFB/tL9QVaak8BCz6Xuc9G73bhHLOi5SPBeoPopPjOqw+mtAIjFn3jOKyNYICBUs/db63GVxqbIsbVdK2RuytTZr7IhQbYnUoTo6QX33ao/eEaeW8ffsbUboJPrf8G9zAoGBAJpONyRy4hCZy5PiXAp6s5m5n0rMdioEYNK4Vv+A2fM3SlVfr7Zn0f/07zWbNbQS9aV1ITHty80Df//J4QtnnPdNAJd3i/mA6PG91DgD3NRFJT+Zumk7KZzTczirOOTemJa9d4VyuQdXY68sgUi5K1r+ylIs/vqwQPO4+kB6pb+BAoGAYiRGIjKksp1tgRn2Jz8YqpWR2gXsy2bYPdDMa7piS8rMWc01FJdHk61Ih9+dgLwaZ3hxT3JWEKl4p9+uXMsgXjvokUjn2r40p+OPwNF5ZihAnxEE6f3iSgcM/7e3pzhyrppaKNP5N7FxKf7E7i3NJsiRTFeinv5pAZUlFYhch/kCgYAxfbTNGjdGHNJAQIbwY2CjzOHVX19Czdwop9jrpcgutUPHEgz7wxRHJLv+66dBGSlHmMNK0kSO9psvgJxmH1xCaTdLRN2rZnSSlW6AEsYduGoWDtdNV3Ycz38o1iwoTHaWbfSDjFIdgsa0G2Lt/fU7tRRREJyUlf8oPnam7WR6Mw==";
	private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3XTyzHtUtTxj2HqSNEyOOvutS0HLxvm9TVXimpxMTkgSUIFn1mo//yeJxj2BN+AOtynDt4hcyn1x+2nUV43Uj2evNdHItsyqAu8vumbTQ/QIsNPIgq9IdJu34OrVlPKPq2QjJpFAcdlYyoam8yjTZNav0s1gepGKp9Crpwdtkk12xex20/R19S8WW/9psoZvCrpt/RIqyN0x/OXbekZghrg0DeLXLNKdr0A6oaaOxhl3rCF2Fn61Kcy214a/lkNmbamUcqh9jsmnlyhrPO650QanJI1V28bsX1swSrZzAOofAeCO17f6N1vDcSjRN6VWsIorKND3KloAHC8OzD6KDwIDAQAB";
	private static final String RSA = "RSA";
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String auth = request.getHeader("Authorization");
		String token = "";
		if(auth == null || auth.isEmpty() ) {
			response.sendError(401,"Token no informado");
		}else{
			if(auth.startsWith("Bearer ")) {
				token = auth.split("Bearer ")[1];
			}else {
				token = auth;
			}
			
			validarToken(token, response);
			
		}
		
	}
	
	private static void validarToken(String token, HttpServletResponse response) throws IOException{
		try{
			Algorithm algorithm = Algorithm.HMAC256("secret");
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("vector")
					.build();
			verifier.verify(token);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			response.sendError(401,"Tipo de algoritmo no soportado");
		}catch(SignatureVerificationException e) {
			e.printStackTrace();
			response.sendError(401,"Token Invalido: " + e.getMessage());
		}catch(TokenExpiredException e) {
			e.printStackTrace();
			response.sendError(401,"Token Expirado: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		///generate
		System.out.println(generarToken());
	}
	
	private static String generarToken(){
		String token = "";
		Algorithm algorithm = Algorithm.RSA256(keyPublic(),keyPrivate());
		/*token = JWT.create()
				.withIssuer("vector")
				.sign(algorithm);*/
		return token;
	}
	
	private static final RSAPrivateKey keyPrivate() {
		RSAPrivateKey privateKey = null;
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(PRIVATE_KEY));
		try {
			KeyFactory kf = KeyFactory.getInstance(RSA);
			privateKey = (RSAPrivateKey)kf.generatePrivate(spec);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return privateKey;
	}
	
	private static final RSAPublicKey keyPublic() {
		RSAPublicKey publicKey = null;
		X509EncodedKeySpec  spec = new X509EncodedKeySpec(Base64.getDecoder().decode(PUBLIC_KEY));
		try {
			KeyFactory kf = KeyFactory.getInstance(RSA);
			publicKey = (RSAPublicKey)kf.generatePublic(spec);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publicKey;
	}
	
	public static void generaLlaves() {
		
	}
	

	

}
