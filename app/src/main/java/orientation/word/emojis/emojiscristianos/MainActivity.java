package orientation.word.emojis.emojiscristianos;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


public class MainActivity extends AppCompatActivity {


    TextView versiculo,txtHome,libroYcap,txtVattribution;
    boolean isHome=true;
 //   ImageView squareGold;
    String emoji=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crea el toolbar que contiene home y share
        Toolbar toolbar=(Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        //atribucion
        txtVattribution=findViewById(R.id.id_attribution);
        txtVattribution.setMovementMethod(LinkMovementMethod.getInstance() );




        //Crea la lista
        ArrayList<Icono> arrIcono=new ArrayList<Icono>();
        arrIcono.add(new Icono("accidentado",R.drawable.accidentado));
        arrIcono.add(new Icono("corazon_roto",R.drawable.break_heart));
        arrIcono.add(new Icono("enfermo",R.drawable.face_thermometer));
        arrIcono.add(new Icono("fuerte",R.drawable.strong_arm));
        arrIcono.add(new Icono("enamorado",R.drawable.enamorado));
        arrIcono.add(new Icono("dinero",R.drawable.money));
        arrIcono.add(new Icono("asombro",R.drawable.fear_face));
        arrIcono.add(new Icono("suenio",R.drawable.sleeping_face));
        arrIcono.add(new Icono("malvado",R.drawable.smiling_devil));
        arrIcono.add(new Icono("feliz",R.drawable.smiling_face));
        arrIcono.add(new Icono("santidad",R.drawable.smiling_halo));
        arrIcono.add(new Icono("serpiente",R.drawable.snake));
        arrIcono.add(new Icono("enojado",R.drawable.very_angry));
        arrIcono.add(new Icono("oveja",R.drawable.oveja));
        arrIcono.add(new Icono("prudencia",R.drawable.prudencia));





        versiculo=(TextView) findViewById(R.id.id_versiculo);
        libroYcap=findViewById(R.id.id_libroYcap);

        Typeface helvetica= Typeface.createFromAsset(getAssets(),"fonts/Helvetica-Regular.ttf");
        versiculo.setTypeface(helvetica);

        txtHome=findViewById(R.id.id_home);
      //  txtHome.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);




        //Despliegue el Home
       // squareGold=findViewById(R.id.id_imgdorado);
        ImageButton btnHome=findViewById(R.id.id_btnhome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isHome)
                {   versiculo.setVisibility(View.INVISIBLE);
                    libroYcap.setVisibility(View.INVISIBLE);
                  //  squareGold.setVisibility(View.INVISIBLE);
                    txtHome.setVisibility(View.VISIBLE);
                    isHome=true;
                }

            }
        });

       //share
       ImageButton share=findViewById(R.id.id_imgshare);
       share.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent sendIntent = new Intent();
               sendIntent.setAction(Intent.ACTION_SEND);
               sendIntent.putExtra(Intent.EXTRA_TEXT,emoji+"..."+ versiculo.getText()+"  "+libroYcap.getText());
               sendIntent.setType("text/plain");
               startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.compartir)));
           }
       });


        IconoArrayAdapter icArray=new IconoArrayAdapter(this,arrIcono);
        GridView gridView;
        gridView=(GridView) findViewById(R.id.id_gridicon);
        gridView.setAdapter(icArray);


        //Listener para los emojis
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String emocion=((Icono) adapterView.getItemAtPosition(i)).getEmocion();
                Random randomGenerator = new Random();
                int randomVerso;
                int id,indexTexto;
                String texto,captxt;

                 if(isHome){
                     isHome=false;
                  //   squareGold.setVisibility(View.VISIBLE);
                     versiculo.setVisibility(View.VISIBLE);
                     libroYcap.setVisibility(View.VISIBLE);
                     txtHome.setVisibility(View.INVISIBLE);

                 }
                randomVerso = randomGenerator.nextInt(17);
                 switch (emocion)
                 {
                     case "enojado":

                         id = getResources().getIdentifier("enojo_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.ANGRY_FACE;
                         break;
                     case "feliz":
                         id = getResources().getIdentifier("alegre_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.GRINNING_FACE;
                         break;
                     case "enfermo":

                         id = getResources().getIdentifier("sanidad_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_THERMOMETER;
                         break;
                     case "dinero":
                         id = getResources().getIdentifier("money_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.MONEY_WITH_WINGS;
                         break;
                     case "serpiente":
                         randomVerso = randomGenerator.nextInt(5);
                         id = getResources().getIdentifier("snake_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.SNAKE;
                         break;
                     case "fuerte":

                         id = getResources().getIdentifier("fortaleza_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FLEXED_BICEPS_TYPE_3;
                         break;
                     case "suenio":

                         id = getResources().getIdentifier("cansado_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.SLEEPY_FACE;
                         break;

                         case "corazon_roto":
                         id = getResources().getIdentifier("heartbreak_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.BROKEN_HEART;
                         break;

                     case "accidentado":
                         id = getResources().getIdentifier("sanidad_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "oveja":
                         randomVerso = randomGenerator.nextInt(7);
                         id = getResources().getIdentifier("oveja_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "prudencia":
                         randomVerso = randomGenerator.nextInt(24);
                         id = getResources().getIdentifier("lengua_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "enamorado":
                         randomVerso = randomGenerator.nextInt(10);
                         id = getResources().getIdentifier("enamorado_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "asombro":

                         id = getResources().getIdentifier("miedo_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "malvado":
                         randomVerso = randomGenerator.nextInt(13);
                         id = getResources().getIdentifier("malvado_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     case "santidad":

                         id = getResources().getIdentifier("santidad_"+(randomVerso), "string", getPackageName());
                         texto=getString(id);
                         indexTexto=texto.indexOf("_");
                         captxt=texto.substring(indexTexto+1);
                         texto=texto.substring(0,indexTexto);
                         versiculo.setText(texto);
                         libroYcap.setText(captxt);
                         emoji=emojisIcons.FACE_WITH_HEAD_BANDAGE;
                         break;
                     default:
                         versiculo.setText("default");
                         break;
                 }

            }
        });

    }
}
