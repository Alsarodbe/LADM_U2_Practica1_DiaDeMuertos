package mx.tecnm.tepic.ladm_u2_practica1_diademuertos
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

class Lienzo(p: MainActivity):View(p){

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint();//Sirve para añadir los atributos del elemento que queramos dibujar posteriormente
        c.drawARGB(255, 0, 8, 60);
        //-------LUNA
        p.setColor(Color.parseColor("#FAFFD9"));
        c.drawCircle(120f, 108f, 106f, p);
        p.setColor(Color.parseColor("#00083C"));
        c.drawCircle(226f, 108f, 106f, p);
        //-------NUBE1
        p.setColor(Color.parseColor("#BCBCBC"));
        c.drawCircle(500f, 140F, 50f, p);
        c.drawCircle(550f, 140F, 50f, p);
        c.drawCircle(600f, 140F, 50f, p);
        //-------NUBE2
        c.drawCircle(60f, 240F, 70f, p);
        c.drawCircle(130f, 240F, 70f, p);
        c.drawCircle(200f, 240F, 70f, p);
        //-------NUBE3
        c.drawCircle(365f, 348f, 83f, p);
        c.drawCircle(448f, 348f, 83f, p);
        c.drawCircle(531f, 348f, 83f, p);
        //-------SUELO/PISO
        p.setColor(Color.parseColor("#593B18"));
        c.drawRect(0f, 810f, 720f, 1180f, p);//Coordenada superior izquierda, Coordenada inferior derecha, p que es el estilo
        //Arbol
        p.setColor(Color.parseColor("#35240F"));
        c.drawRect(620f, 550f, 720f, 950f, p);//Coordenada superior izquierda, Coordenada inferior derecha, p que es el estilo
        p.setColor(Color.parseColor("#004302"));
        c.drawCircle(650f, 480f, 150f, p);
        //lápidas
        val lapida1 = BitmapFactory.decodeResource(resources, R.drawable.lapida);
        val lapida2 = BitmapFactory.decodeResource(resources, R.drawable.lapida2);
        val lapida3 = BitmapFactory.decodeResource(resources, R.drawable.lapida3);
        val lapida4 = BitmapFactory.decodeResource(resources, R.drawable.lapida4);
        val lapida5 = BitmapFactory.decodeResource(resources, R.drawable.lapida5);
        val lapida6 = BitmapFactory.decodeResource(resources, R.drawable.lapida6);
        c.drawBitmap(lapida1,0F, 710F, p);//
        c.drawBitmap(lapida2,350F, 710F, p);
        c.drawBitmap(lapida4,450F, 800F, p);
        c.drawBitmap(lapida5,250F, 870F, p);
        //-------MI NOMBRE
        p.textSize = 10f;
        p.setColor(Color.WHITE);
        c.drawText("Alex Rodríguez", 600f, 800f, p);
        //Esqueleto
        val esqueleto = BitmapFactory.decodeResource(resources, R.drawable.esqueleto);
        c.drawBitmap(esqueleto,xc, 550F, p);
        //Mas lápidas
        c.drawBitmap(lapida3,50F, 950F, p);
        c.drawBitmap(lapida6,450F, 1000F, p);
    }
    var xc=-30f;
    var incrementoX=6
    val timer=object: CountDownTimer(50,50){
        override fun onFinish() {
            start();
        }
        override fun onTick(millisUntilFinished: Long) {
            xc+=incrementoX;
            if(xc<=-30 || xc>=425){
                incrementoX*=-1;
            }
            invalidate();
        }
    }.start();
}