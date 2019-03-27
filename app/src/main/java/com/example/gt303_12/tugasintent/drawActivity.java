package com.example.gt303_12.tugasintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
import android.widget.TextView;

public class drawActivity extends AppCompatActivity {

    ImageView imageView;
    TextView logUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        logUser = findViewById(R.id.logUser);

        String stringExtra = getIntent().getExtras().getString("LOG_USER");
        logUser.setText("Log as " + stringExtra);

        imageView = findViewById(R.id.imageView);
        draw();
    }

    private void draw(){
        Bitmap blankBitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(blankBitmap);
        imageView.setImageBitmap(blankBitmap);
        Paint paint = new Paint();
        canvas.drawColor(Color.argb(255, 255, 255, 255));
        paint.setColor(Color.argb(255, 26, 128, 182));
        canvas.drawText("RUMAHKU", 250, 570, paint);
        drawTriangle(canvas, paint, 300, 150, 310);
        paint.setColor(Color.argb(255, 249, 129, 0));
        canvas.drawRect(170, 305, 430, 550, paint);
    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width){
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y-halfWidth);    //top level
        path.lineTo(x - halfWidth, y + halfWidth);      //bottom left level
        path.lineTo(x + halfWidth, y + halfWidth);      //bottom right lvek
        path.lineTo(x, y-halfWidth);        //back to top level
        path.close();

        canvas.drawPath(path, paint);
    }
}
