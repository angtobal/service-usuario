package pe.org.alerta.usuario.persist;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, String> {
    //List<User> findByLastname(String lastname);
    //Page<User> findByFirstname(String firstname, Pageable pageable);
} 