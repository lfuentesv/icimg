package cl.lfuentes.icimg.service;

import cl.lfuentes.icimg.dao.UsuarioRepository;
import cl.lfuentes.icimg.entityTo.Usuario;
import cl.lfuentes.icimg.requestTO.LoginRTO;
import cl.lfuentes.icimg.requestTO.UsuarioRTO;
import cl.lfuentes.icimg.resposeTO.UsuarioResponseTO;
import cl.lfuentes.icimg.validacion.DeleteException;
import cl.lfuentes.icimg.validacion.UsuarioNoEncontradoException;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public Usuario crear(UsuarioRTO usuario) {
        Usuario usuarioPO = new Usuario( usuario.getRut(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFono(), usuario.getCargo(), usuario.getEmpresa(), usuario.getPerfil(), usuario.getPassword());
        Usuario usuarioCreado = repo.saveAndFlush(usuarioPO);
        return usuarioCreado;
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = repo.findAll();

        return usuarios;
    }

    public Optional<Usuario> buscar(String rut) {

        return Optional.ofNullable(repo.findByRut(rut).orElseThrow(() -> new UsuarioNoEncontradoException(rut)));
    }

    public Usuario actualizar(String rut, UsuarioRTO usuario) {
        Optional<Usuario> existente = repo.findByRut(usuario.getRut());
        if (!existente.isPresent()) throw new UsuarioNoEncontradoException(rut);

        Usuario usuarioPO = new Usuario( usuario.getRut(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFono(), usuario.getCargo(), usuario.getEmpresa(), usuario.getPerfil(), usuario.getPassword());
        return repo.saveAndFlush(usuarioPO);
    }

    @Transactional
    public void eliminar(String rut) {
        Optional<Usuario> existente = repo.findByRut(rut);
        if (!existente.isPresent()) throw new UsuarioNoEncontradoException(rut);
        try {
            repo.deleteByRut(rut);
            repo.flush();
        }catch (DataIntegrityViolationException e){
            throw new DeleteException("Error eliminando Usuario, revise que no este asociado con otro recurso");
        }
    }

    public Usuario login(LoginRTO login) {

        return repo.findByRutAndPassword(login.getUserName(), login.getPassword()).orElseThrow(() -> new UsuarioNoEncontradoException(login.getUserName()));

    }
}
