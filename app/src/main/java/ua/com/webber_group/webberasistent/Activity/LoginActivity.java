package ua.com.webber_group.webberasistent.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

import ua.com.webber_group.webberasistent.R;

/**
 * Created by dmytr_000 on 04.09.2016.
 */
public class LoginActivity extends Activity {
    TextView LoginText;
    Button btn;
    TextInputLayout Email;
    TextInputLayout Password;
    Animation AnimUp;
    Animation AnimDown;
    ImageView Earth;
    CheckBox CheckRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        LoginText = (TextView) findViewById(R.id.LoginText);
        btn = (Button) findViewById(R.id.btn_enter);
        Email = (TextInputLayout) findViewById(R.id.input_layout_email);
        Password = (TextInputLayout) findViewById(R.id.input_layout_password);
        Earth = (ImageView) findViewById(R.id.earth);
        CheckRemember = (CheckBox) findViewById(R.id.check_remember);

        //Подключение анимации для View элементов
        AnimUp = AnimationUtils.loadAnimation(this,
                R.anim.elements_up);
        AnimDown = AnimationUtils.loadAnimation(this,
                R.anim.elements_down);
        //Подключение шрифта и применение его для TextView
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Arciform.otf");
        final Spannable spans = new SpannableString(getString(R.string.company_name));
        final ForegroundColorSpan style =  new ForegroundColorSpan(Color.rgb(23,159,255));
        final ForegroundColorSpan style2 = new ForegroundColorSpan(Color.rgb(23,159,255));
        spans.setSpan(style, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spans.setSpan(style2, 7, 8, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        LoginText.setTypeface(null,Typeface.BOLD);
        LoginText.setText(spans);
        LoginText.setTypeface(face);

        LoginText.startAnimation(AnimUp);

        Email.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        CheckRemember.setVisibility(View.INVISIBLE);
//        LoginText.setVisibility(View.INVISIBLE);

       // Earth.startAnimation(AnimUp);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Email.setVisibility(View.VISIBLE);
                Password.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                CheckRemember.setVisibility(View.VISIBLE);

                Email.startAnimation(AnimUp);
                Password.startAnimation(AnimUp);
                btn.startAnimation(AnimUp);
                CheckRemember.startAnimation(AnimUp);

            }
        }, 3000);

        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {

               // LoginText.startAnimation(AnimDown);
                Email.startAnimation(AnimDown);
                Password.startAnimation(AnimDown);
                btn.startAnimation(AnimDown);
                CheckRemember.startAnimation(AnimDown);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Drawable drawable = Earth.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }
    }
}
