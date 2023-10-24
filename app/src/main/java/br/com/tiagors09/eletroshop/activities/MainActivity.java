package br.com.tiagors09.eletroshop.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.fragments.CarrinhoFragment;
import br.com.tiagors09.eletroshop.fragments.ExibicaoPerfilFragment;
import br.com.tiagors09.eletroshop.fragments.ExibicaoProdutosFragment;
import br.com.tiagors09.eletroshop.fragments.FavoritosFragment;
import br.com.tiagors09.eletroshop.fragments.MeusProdutosFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(this);

        loadFragment(new ExibicaoProdutosFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.home)
            loadFragment(new ExibicaoProdutosFragment());

        if (item.getItemId() == R.id.meus_produtos) {
            loadFragment(new MeusProdutosFragment());
        }

        if (item.getItemId() == R.id.carrinho) {
            loadFragment(new CarrinhoFragment());
        }

        if (item.getItemId() == R.id.favoritos) {
            loadFragment(new FavoritosFragment());
        }

        if (item.getItemId() == R.id.perfil) {
            loadFragment(new ExibicaoPerfilFragment());
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