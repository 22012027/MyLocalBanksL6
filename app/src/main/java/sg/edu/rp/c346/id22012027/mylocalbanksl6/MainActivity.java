package sg.edu.rp.c346.id22012027.mylocalbanksl6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Selection;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewDbs;
    TextView textViewOcbc;
    TextView textViewUob;
    String wordClicked= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDbs=findViewById(R.id.textViewDBS);
        textViewOcbc=findViewById(R.id.textViewOCBC);
        textViewUob=findViewById(R.id.textViewUOB);

        registerForContextMenu(textViewDbs);
        registerForContextMenu(textViewOcbc);
        registerForContextMenu(textViewUob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");

        if (v== textViewDbs) {
            wordClicked= "DBS";
        }
        else if (v== textViewOcbc) {
            wordClicked= "OCBC";
        }
        else {
            wordClicked= "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800111111));
                startActivity(intentcall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800363333));
                startActivity(intentcall);
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentcall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800222212));
                startActivity(intentcall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textViewDbs.setText("DBS");
            textViewOcbc.setText("OCBC");
            textViewUob.setText("UOB");
            return true;
        } else {
            textViewDbs.setText("星展银行");
            textViewOcbc.setText("华侨银行");
            textViewUob.setText("大华银行");
            return true;
        }
    }

}