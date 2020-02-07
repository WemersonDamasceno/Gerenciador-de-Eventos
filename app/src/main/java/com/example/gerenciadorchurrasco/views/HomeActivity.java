package com.example.gerenciadorchurrasco.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gerenciadorchurrasco.R;
import com.example.gerenciadorchurrasco.fragments.CoisasParaFazerFragment;
import com.example.gerenciadorchurrasco.fragments.EventosParticipadosFragment;
import com.example.gerenciadorchurrasco.fragments.EventosProxFragment;
import com.example.gerenciadorchurrasco.fragments.PerfilFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Fragment> fragments;
    ArrayList<String> titles;
    Button buttonAddEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      //  fragments = new ArrayList<Fragment>(4);
      //  titles = new ArrayList<>();
        buttonAddEvento = findViewById(R.id.buttonAddEvento);
        buttonAddEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),CriarEventosActivity.class);
                startActivity(intent);
            }
        });
/*
        //Tab Layout
        //Precisamos de um view page e um tabLayout
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        //tablayout
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
*/
    }

    private class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);

            fragments.add(new PerfilFragment());
            fragments.add(new EventosProxFragment());
            fragments.add(new EventosParticipadosFragment());
            fragments.add(new CoisasParaFazerFragment());

            //vincular com os titulos

            titles.add(getString(R.string.perfil));
            titles.add(getString(R.string.coisas_para_fazer));
            titles.add(getString(R.string.eventos_proximos));
            titles.add(getString(R.string.eventos_participados));

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


}
