package com.example.gerenciadorchurrasco.views;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.example.gerenciadorchurrasco.R;
import com.example.gerenciadorchurrasco.dateTime.DatePickerFragment;
import com.example.gerenciadorchurrasco.dateTime.TimePickerFragment;

public class CriarEventosActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    final int GALERIA_IMAGENS = 1;
    final int PERMISSAO_REQUEST = 2;
    Button buttonAddFoto;
    Button buttonCriarEvento;
    EditText criarNomeEvento;
    TextView criarDataEvento;
    TextView criarHoraEvento;
    EditText criarLocalizacaoEvento;
    CheckBox criarCategoriaEvento;
    ImageView imagemView;

    //acessar a galeria
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_eventos);

        buttonAddFoto = findViewById(R.id.buttonAddFoto);
        imagemView = findViewById(R.id.imageViewEvento);
        buttonCriarEvento = findViewById(R.id.buttonCriarEvento);
        criarNomeEvento = findViewById(R.id.criarNameEvento);
        criarLocalizacaoEvento = findViewById(R.id.criarLocalizacaoEvento);
        criarCategoriaEvento = findViewById(R.id.categoria);
        criarDataEvento = findViewById(R.id.criarDataEvento);
        criarHoraEvento = findViewById(R.id.criarHoraEvento);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }

        //BOTOES DA FOTO
        buttonAddFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddFoto.setText("ESCOLHER OUTRA FOTO");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });


        //hora e data
        criarDataEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "criarDataEvento");

            }
        });
        criarHoraEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "criarHoraEvento");
            }
        });


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String minuto = minute + "";
        String hora = hourOfDay + "";
        if (hourOfDay <= 9) {
            hora = "0" + hora;
        }
        if (minute <= 9) {
            minuto = "0" + minuto;
        }
        criarHoraEvento.setText(hora + ":" + minuto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            assert selectedImage != null;
            Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
            assert c != null;
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            imagemView.setImageBitmap(thumbnail);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // A permissão foi concedida. sumir o botão

            } else {
                // A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
    }




/*
    public void mascarasDataeHora() {
        //Criação das mascaras mascara da data
        SimpleMaskFormatter data = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher dataMask = new MaskTextWatcher(criarDataEvento, data);
        criarDataEvento.addTextChangedListener(dataMask);
        //mascara da hora
        SimpleMaskFormatter hora = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher horaMask = new MaskTextWatcher(criarHoraEvento, hora);
        criarHoraEvento.addTextChangedListener(horaMask);
        //Fim das mascaras
    }
*/


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String dia = dayOfMonth + "";
        String mes = month + "";
        if (dayOfMonth <= 9) {
            dia = "0" + dia;
        }
        if (month <= 9) {
            mes = "0" + mes;
        }
        criarDataEvento.setText(dia + "/" + mes + "/" + year);
    }
}
