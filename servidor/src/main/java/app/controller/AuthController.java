package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Aqui você pode autenticar com banco de dados ou serviço real

        // Exemplo simples apenas para teste:
        if ("admin".equals(loginRequest.getUsername()) && "123".equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(Map.of("message", "Login realizado com sucesso"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Usuário ou senha inválidos"));
        }
    } //q q é isso? em q vídeo eu fiz isso?
    // Classe interna para representar o JSON recebido
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters e Setters obrigatórios
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
}