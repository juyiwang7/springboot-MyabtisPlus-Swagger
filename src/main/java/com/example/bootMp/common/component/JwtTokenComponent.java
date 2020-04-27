package com.example.bootMp.common.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @Usage: JWT Token 处理组件
 * @Author: gjq
 * @Date: 2019/3/20 11:30 AM
 */
@Component
public class JwtTokenComponent implements TokenComponent {
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenComponent.class);
	private final int millisecondToSecond = 1000;
	private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkngXDsTy7Vuo1CcDu0mUP+3lN2JarCYJa6lDJhbBwUstEE/HCTtZwsgoWFJFb2T3WAxCsXlxYKo9DiWJbBeMV7TRTzKbAz0Wp4M6ygAWo3NLlzeOa+4cMOVQ9kq0doHormzxzA/tHXTx9BYBtZBJryuXL3+qxWsb0CLtMa/W6Gs1+zKxo3FGvW0t1QnoZfoJV1VF8kvSEsDpsmV3kqerE0cVPkn/BOZ22x32F8Q3k3g0+g9npWIUZ3zVn/pemuG7vYTtPjBKAJCKeFF86gW2Fqb0EjrGCZx7BCO4gV3Gb6vng2mLEb3DkIcGBelmE0rnYAmlYAtJnSxWVI8gNUhwlwIDAQAB";
	private String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSeBcOxPLtW6jUJwO7SZQ/7eU3YlqsJglrqUMmFsHBSy0QT8cJO1nCyChYUkVvZPdYDEKxeXFgqj0OJYlsF4xXtNFPMpsDPRangzrKABajc0uXN45r7hww5VD2SrR2geiubPHMD+0ddPH0FgG1kEmvK5cvf6rFaxvQIu0xr9boazX7MrGjcUa9bS3VCehl+glXVUXyS9ISwOmyZXeSp6sTRxU+Sf8E5nbbHfYXxDeTeDT6D2elYhRnfNWf+l6a4bu9hO0+MEoAkIp4UXzqBbYWpvQSOsYJnHsEI7iBXcZvq+eDaYsRvcOQhwYF6WYTSudgCaVgC0mdLFZUjyA1SHCXAgMBAAECggEATH1chUEDIEOa0lghkcAmJJCnAJpjgb1HdCrrv0tpGfmZaghPiBmvkZIXx7AHRNo0dY3Jkoc6V2HwCqA9uO4/Q1pRaIuj+jf/ybE1lWIgcHF4i1rfDKxHmp1W/5gZ0D2dduG8EHZMvPJinLaVY+0bHdik1pBUbU63MqXauvT6RVtUgZZP1hoD6O23ZYwMiCtib9gkisniaoLBn1CIZ4MDcWbn6dxne1yJLDeoVpP4ZFU3sVlmnekh5KcUhklNkdMvLOSeuchP0dFXDgQtwUDfJNd5JWFOVCo1f4yl3pAYZTvQp/+v4+6LDff4z4ft5HPjPrktGT85GRQDdJM6pX6u4QKBgQDWfyYj5UbiJxpVD+M4SChY/WIY8mSkYIEH5Tj/KfKddCOUdx4kBacMl47Q/131c1y/ztasVwVPA1CObNQthVcIftyuqhdp06VvO2GmiMlaBMAG0vB4mZ7Y47Tr5vW4atpV/G7iNpCQ5GriTLzg9VFAWzRT0/tNfOjmeUtBqukz5wKBgQCuz0WbdyMwjq6T9d83gFKbrNhupNMOVmjuSO9oDNQOyvnQrDYZsghOfEAs4VCoEwkI01bkE6eIxKn93xlEfG/ztqqcZ0y40LCbYZgbdB4s2966lj2n+IZp22wLIjZGuLlRxRb6uBuD+aGsLt9NO1fN6OwtsVcE3ie2X2pDFIBH0QKBgBf8tiYzgL7Pwqkakr17jE+PXoYNrWWYiTV50+rtJP2ovEXhIFTE8Q5+cHE87aQCV6/3kJhLTwOsCjkzQHMqwzXnAgTibqXeDlUnHd+C0omnmFXrBwtlmpcEt/ndpUMPaAVPqpLPqVEayj0uebzqkkCRMoPhY+wheOY1UE4yr8unAoGBAKawBlPEOs3mgBmebgbiWeMP4iE/EfGt+8iby42QDfU9HxEX5U6DMOCGIjupbduWqxq7SzOYejw0K1RlFBb2AVqHaBBTgBkLBhxj50Lmao+j6LJK6OfuV11BWbkUGmU9Z5jNMqhIPhSOSNeCqnNejs9Nt0eqvqtpmryQJydnuRrBAoGART1cwZj3Z3yLAqbWaxoOkCCoT0EGPTKi760R2eNaKwHn+lP9kO8y2DsvmtkwmANUoBOEW4tyqRjFxAAK+U5K6pkM9PHKq/q8+HbIUbCY1gg3KINHProsbFv3VCX+dcjuwMxtEPXna9GSTyn2ycMsiKLnVAuMBVG1antVQKrfGJ8=";
	private PrivateKey privateKeyObject;
	private PublicKey publicKeyObject;
	/**
	 * Token失效时间，单位为秒
	 */
	@Value("${project.auth.jwt-expiration-in-sec}")
	private long jwtExpirationInSec;
	/**
	 * User失效时间，单位为秒
	 */
	@Value("${project.auth.user-expiration-in-min}")
	private long userExpirationInMin;

	{
		try {
			//由密钥字节数组获取密钥规范
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			//实例化密钥工厂
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			//生成密钥
			privateKeyObject = keyFactory.generatePrivate(keySpec);

			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
			KeyFactory x509KeyFactory = KeyFactory.getInstance("RSA");
			//生成公钥
			publicKeyObject = x509KeyFactory.generatePublic(x509KeySpec);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据map签发Token
	 *
	 * @param id
	 * @param claims
	 * @return
	 */
	@Override
	public String generateToken(String id, Map claims) {
		logger.debug("生成Token：{}", id);
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInSec * millisecondToSecond);
		return Jwts.builder().setClaims(claims).setSubject(id).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(privateKeyObject).compact();
	}

	/**
	 * 解析JWT，返回null表示Token不合法
	 *
	 * @param jwt
	 * @return
	 */
	@Override
	public Map<String, Object> getClaimsFromToken(String jwt) {
		try {
			Claims claims = Jwts.parser().setSigningKey(publicKeyObject).parseClaimsJws(jwt).getBody();
			return claims;
		} catch (Exception e) {
			logger.warn("Token不合法：{}", jwt);
			return null;
		}
	}

	/**
	 * 从过期Token获取信息，null为Token不合法
	 *
	 * @param token
	 * @return
	 */
	@Override
	public Map<String, Object> getClaimsFromOldToken(String token) {
		try {
			Claims claims = Jwts.parser().setAllowedClockSkewSeconds(8 * 60 * 60).setSigningKey(publicKeyObject).parseClaimsJws(token).getBody();
			return claims;
		} catch (Exception e) {
			logger.warn("Token不合法：{}", token);
			return null;
		}
	}

	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * 可核查token超时
	 *
	 * @param token
	 * @return
	 */
	public JWTResultEnum checkToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(publicKeyObject).parseClaimsJws(token).getBody();
			return JWTResultEnum.SUCCESS.setValue(claims);
		} catch (ExpiredJwtException e) {
			// 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
			Claims claims = Jwts.parser().setAllowedClockSkewSeconds(8 * 60 * 60).setSigningKey(publicKeyObject).parseClaimsJws(token).getBody();
			return JWTResultEnum.TOKEN_TIMEOUT.setValue(claims);
		} catch (SignatureException e) {
			// 在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
			return JWTResultEnum.TOKEN_NO_AUTH;
		} catch (Exception e) {
			return JWTResultEnum.TOKEN_NO_AUTH;
		}
	}

	public enum JWTResultEnum {
		// Token合法
		SUCCESS(1),
		// Token超时
		TOKEN_TIMEOUT(0),
		// Token未认证
		TOKEN_NO_AUTH(-1);
		int code;
		Map<String, Object> value;

		JWTResultEnum(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public Map<String, Object> getValue() {
			return value;
		}

		public JWTResultEnum setValue(Map<String, Object> value) {
			this.value = value;
			return this;
		}
	}
}
