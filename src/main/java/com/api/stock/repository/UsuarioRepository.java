package com.api.stock.repository;

import com.api.stock.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findUsuarioByEmail(String email);
}
