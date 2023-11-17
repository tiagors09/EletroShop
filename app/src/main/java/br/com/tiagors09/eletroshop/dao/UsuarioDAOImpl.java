package br.com.tiagors09.eletroshop.dao;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private static UsuarioDAO instance;
    private Gson gson;

    private UsuarioDAOImpl() {
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("usuarios");
        gson = new Gson();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
        }

        return instance;
    }

    private Task<AuthResult> criarUsuario(Usuario u) {
        return firebaseAuth
                .createUserWithEmailAndPassword(u.getEmail(), u.getSenha());
    }

    @Override
    public Task<Boolean> salvar(Usuario u) {
        final TaskCompletionSource<Boolean> myTask = new TaskCompletionSource<>();

        criarUsuario(u)
                .addOnSuccessListener(authResultCreate -> {
                                 entrar(u)
                                         .addOnSuccessListener(authResultSigIn -> {
                                             databaseReference
                                                     .child(authResultSigIn.getUser().getUid())
                                                     .setValue(u.toMap());
                                         })
                                         .addOnFailureListener(entrarFalha -> {
                                             myTask.setException(entrarFalha);
                                         });
                        })
                .addOnFailureListener(criarUsuarioResultado -> {
                    myTask.setException(criarUsuarioResultado);
                });

        return myTask.getTask();
    }

    @Override
    public Task<Boolean> apagar() {
        final TaskCompletionSource<Boolean> task = new TaskCompletionSource<>();

        databaseReference
                .child(firebaseAuth.getUid())
                .removeValue()
                .addOnSuccessListener(
                        unused -> task.setResult(true)
                )
                .addOnFailureListener(
                        e -> task.setException(e)
                );

        return task.getTask();
    }

    @Override
    public Task<Usuario> ler() {
        final TaskCompletionSource<Usuario> task = new TaskCompletionSource<>();

        databaseReference
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Usuario usuario = snapshot
                                        .child(firebaseAuth.getUid())
                                        .getValue(Usuario.class);
                                task
                                        .setResult(usuario);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                task
                                        .setException(
                                                error
                                                        .toException()
                                        );
                            }
                        }
                );

        return task.getTask();
    }

    @Override
    public Task<List<Usuario>> lerTodosUsuarios() {
        final TaskCompletionSource<List<Usuario>> task = new TaskCompletionSource<>();

        databaseReference
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                List<Usuario> usuarios = snapshot.getValue(List.class);
                                task.setResult(usuarios);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                task.setException(error.toException());
                            }
                        }
                );

        return task.getTask();
    }

    @Override
    public Task<AuthResult> entrar(Usuario u) {
        return firebaseAuth
                .signInWithEmailAndPassword(u.getEmail(), u.getSenha());
    }

    @Override
    public Task<Void> sair() {
        firebaseAuth.signOut();
        return null;
    }
}
