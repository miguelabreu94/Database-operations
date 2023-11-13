package pt.rumos.academia.bd.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
	
	public static String calcularHash(String texto) {

	MessageDigest md5;
	try {
		md5 = MessageDigest.getInstance("MD5");
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		throw new RuntimeException("Erro ao efetuar o MD5");
	}
	
	md5.update(StandardCharsets.UTF_8.encode(texto));
	
	return String.format("%032x", new BigInteger(1, md5.digest()));
	
}
}
