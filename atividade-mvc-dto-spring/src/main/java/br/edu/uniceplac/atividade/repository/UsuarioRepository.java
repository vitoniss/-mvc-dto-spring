package br.edu.uniceplac.atividade.repository;

import br.edu.uniceplac.atividade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
