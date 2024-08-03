package gabriel.dev.com.steam.Models;

import gabriel.dev.com.steam.Models.Enums.Pais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String Password;
    private Pais pais;
    private LocalDateTime lastlogin;
    private LocalDateTime createdAt;
    private Integer nivel;
    private float coins;
}
