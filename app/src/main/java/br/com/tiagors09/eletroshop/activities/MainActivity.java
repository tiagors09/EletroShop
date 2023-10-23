package br.com.tiagors09.eletroshop.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.fragments.Carrinho;
import br.com.tiagors09.eletroshop.fragments.ExibicaoPerfil;
import br.com.tiagors09.eletroshop.fragments.ExibicaoProdutos;
import br.com.tiagors09.eletroshop.fragments.Favoritos;
import br.com.tiagors09.eletroshop.fragments.MeusProdutos;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // bottomNav = findViewById(R.id.bottomNav);
       // bottomNav.setOnNavigationItemSelectedListener(this);

       // loadFragment(new ExibicaoProdutos());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.home)
            loadFragment(new ExibicaoProdutos());

        if (item.getItemId() == R.id.meus_produtos) {
            loadFragment(new MeusProdutos());
        }

        if (item.getItemId() == R.id.carrinho) {
            loadFragment(new Carrinho());
        }

        if (item.getItemId() == R.id.favoritos) {
            loadFragment(new Favoritos());
        }

        if (item.getItemId() == R.id.perfil) {
            loadFragment(new ExibicaoPerfil());
        }

        return true;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }
}