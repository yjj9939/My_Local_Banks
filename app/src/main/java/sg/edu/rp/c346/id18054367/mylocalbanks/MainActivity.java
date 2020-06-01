package sg.edu.rp.c346.id18054367.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView DBSTV;
    TextView OCBCTV;
    TextView UOBTV;
    TextView getTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBSTV = findViewById(R.id.dbsTextView);
        OCBCTV = findViewById(R.id.ocbcTextView);
        UOBTV = findViewById(R.id.uobTextView);

        registerForContextMenu(DBSTV);
        registerForContextMenu(OCBCTV);
        registerForContextMenu(UOBTV);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getTV = (TextView) v;

        //menu.add(0,0,0,"Website");
        //menu.add(0,1,1,"Contact");
        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(getTV.getId() == R.id.dbsTextView){
            if (id == R.id.website) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intent);
                return true;

            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsnum)));
                startActivity(intentCall);
                return true;
            }


        } else if (getTV.getId() == R.id.ocbcTextView){
            if (id == R.id.website) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intent);
                return true;

            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.ocbcnum)));
                startActivity(intentCall);
                return true;

            }
        } else if (getTV.getId() == R.id.uobTextView){
            if (id == R.id.website) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
                startActivity(intent);
                return true;

            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.uobnum)));
                startActivity(intentCall);
                return true;

            }
        }


        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.English) {
            DBSTV.setText(getString(R.string.dbs));
            OCBCTV.setText(getString(R.string.ocbc));
            UOBTV.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.Chinese) {
            DBSTV.setText(getString(R.string.dbschinese));
            OCBCTV.setText(getString(R.string.ocbcchinese));
            UOBTV.setText(getString(R.string.uobchinese));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
