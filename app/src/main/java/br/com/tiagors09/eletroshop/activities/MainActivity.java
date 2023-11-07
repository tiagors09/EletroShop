package br.com.tiagors09.eletroshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.fragments.CarrinhoFragment;
import br.com.tiagors09.eletroshop.fragments.ExibicaoPerfilFragment;
import br.com.tiagors09.eletroshop.fragments.ExibicaoProdutosFragment;
import br.com.tiagors09.eletroshop.fragments.HistoricoFragment;
import br.com.tiagors09.eletroshop.fragments.MeusProdutosFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        Map<Integer, Fragment> fragments = new HashMap<Integer, Fragment>(){{
                put(R.id.home, new ExibicaoProdutosFragment());
                put(R.id.meus_produtos, new MeusProdutosFragment());
                put(R.id.carrinho, new CarrinhoFragment());
                put(R.id.favoritos, new HistoricoFragment());
                put(R.id.perfil, new ExibicaoPerfilFragment());
        }};

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                loadFragment(fragments.get(item.getItemId()));

                return true;
            }
        });

        loadFragment(new ExibicaoProdutosFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }
}