package br.edu.uniceplac.atividade.controller;

import br.edu.uniceplac.atividade.dto.UsuarioCadastroDTO;
import br.edu.uniceplac.atividade.model.Usuario;
import br.edu.uniceplac.atividade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario criarUsuario(@RequestBody UsuarioCadastroDTO dto) {
        // Conversão: DTO -> Entidade
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        // isAdmin continua false (valor padrão) e o id é gerado pelo banco

        return repository.save(usuario);
    }
}
