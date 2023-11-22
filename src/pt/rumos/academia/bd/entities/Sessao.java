package pt.rumos.academia.bd.entities;

import java.time.LocalDateTime;

public record Sessao(String username, String token, LocalDateTime dataValidade) {
	
	
}
