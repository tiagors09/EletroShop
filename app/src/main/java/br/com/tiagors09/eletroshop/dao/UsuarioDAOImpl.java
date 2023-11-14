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

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private Gson gson;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        firebaseAuth = FirebaseAuth.getInstance();
        gson = new Gson();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
        }

        return instance;
    }

    @Override
    public Task<Boolean> salvar(Usuario u) {
        final TaskCompletionSource<Boolean> task = new TaskCompletionSource<>();

        firebaseAuth
                .createUserWithEmailAndPassword(
                        u.getEmail(),
                        u.getSenha()
                )
                .addOnSuccessListener(
                        authResult -> {
                            if (authResult.getUser() != null) {
                                firebaseAuth
                                        .signInWithEmailAndPassword(
                                                u.getEmail(),
                                                u.getSenha()
                                        )
                                                .addOnSuccessListener(
                                                        new OnSuccessListener<AuthResult>() {
                                                            @Override
                                                            public void onSuccess(AuthResult authResult) {
                                                                
                                                            }
                                                        }
                                                );
                            }
                        }
                )
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                task.setException(e);
                            }
                        }
                );


        return task.getTask();
    }

    @Override
    public Task<Boolean> apagar(String CPF) {
        final TaskCompletionSource<Boolean> task = new TaskCompletionSource<>();

        databaseReference
                .child(CPF)
                .removeValue()
                .addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                task.setResult(true);
                            }
                        }
                )
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                task.setException(e);
                            }
                        }
                );

        return task.getTask();
    }

    @Override
    public Task<Usuario> ler(String CPF) {
        final TaskCompletionSource<Usuario> task = new TaskCompletionSource<>();

        databaseReference
                .addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Usuario usuario = snapshot
                                        .child(CPF)
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
}
