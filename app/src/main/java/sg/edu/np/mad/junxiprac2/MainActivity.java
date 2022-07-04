package sg.edu.np.mad.junxiprac2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        int randomnumber = i.getIntExtra("number", 1739039545);

        TextView namezz = findViewById(R.id.nameTxt);
        namezz.setText("MAD " + randomnumber);



    user student1 = new user("Junxi Lu",
                "Second year IT student at Ngee Ann Polytechnic",
                10219098,
                false);


        Intent intent1 = getIntent();
        String name = intent1.getStringExtra("name");
        String desc = intent1.getStringExtra("description");
        Boolean follow = intent1.getBooleanExtra("follow", false);


        TextView nameTxt = findViewById(R.id.nameTxt);
        nameTxt.setText(name);

        TextView descTxt = findViewById(R.id.descTxt);
        descTxt.setText(desc);

        Button followBtn = findViewById(R.id.followBtn);
        if (follow = true) {
            followBtn.setText("unfollow");
        }
        else {
            followBtn.setText("follow");
        }
        SQLAdapter db = new SQLAdapter(this);
        int id = getIntent().getIntExtra("id", 0);
        ArrayList<user> data = db.getUsers();
        user dbuser = data.get(id);
        followBtn.setOnClickListener(v -> {
            Button followBtn1 = findViewById(R.id.followBtn);
            if (student1.followed){
                followBtn1.setText(R.string.follow);
                db.updateUser(dbuser);
                Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
            } else {
                followBtn1.setText(R.string.unfollow);
                db.updateUser(dbuser);
                Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
            }

            //Update followed status accordingly
            student1.followed = !student1.followed;
        });


    Button messageBtn = findViewById(R.id.messageBtn);
           messageBtn.setOnClickListener(v -> {
                  Intent messageIntent = new Intent(MainActivity.this, MessageGroup.class);
                  startActivity(messageIntent);
                    });
            }
    }